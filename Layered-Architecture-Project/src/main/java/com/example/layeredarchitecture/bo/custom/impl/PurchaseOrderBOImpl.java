package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.PurchaseOrderBO;
import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.dao.custom.OrderDAO;
import com.example.layeredarchitecture.dao.custom.OrderDetailDAO;
import com.example.layeredarchitecture.dao.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.ItemDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.OrderDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.OrderDetailDAOImpl;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PurchaseOrderBOImpl implements PurchaseOrderBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getObject().getDao(DAOFactory.DAOType.CUSTOMER);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getObject().getDao(DAOFactory.DAOType.ITEM);
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getObject().getDao(DAOFactory.DAOType.ORDER);
    OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getObject().getDao(DAOFactory.DAOType.ORDER_DETAIL);
    @Override
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }
    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }
    @Override
    public String generateNewOrderId() {
        try {
            return orderDAO.generateId();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to generate a new order id").show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "OID-001";
    }
    @Override
    public ArrayList<CustomerDTO> loadAllCustomerIds() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> customerDTOS = customerDAO.getAll();
        return customerDTOS;
    }
    @Override
    public ArrayList<ItemDTO> loadAllItemCodes() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO> items = itemDAO.getAll();
        return items;
    }
    @Override
    public boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) {
        /*Transaction*/
        Connection connection = null;
        try {
            connection = DBConnection.getDbConnection().getConnection();
            connection.setAutoCommit(false);
            System.out.println("come to try catch");
            System.out.println(orderId);
            boolean idFound = orderDAO.findOrderId(orderId);
            System.out.println(idFound);
            /*if order id already exist*/
            if (idFound) {
                System.out.println("isFound?");
            }
            System.out.println(orderId+","+orderDate+","+customerId);
            boolean saveOrder = orderDAO.add(new OrderDTO(orderId,orderDate,customerId));
            if (!saveOrder) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
            for (OrderDetailDTO detail : orderDetails) {
                boolean saveDetail = orderDetailDAO.add(detail);
                if (!saveDetail) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
                System.out.println("isSaveDetail");

//                //Search & Update Item
                ItemDTO item = findItem(detail.getItemCode());
                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());
                boolean update = itemDAO.updateItemAfterPlaceOrder(item);
                if (!update){
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }
            connection.commit();
            connection.setAutoCommit(true);
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }
    @Override
    public ItemDTO findItem(String code) {
        try {
            ItemDTO item = itemDAO.find(code);
            return new ItemDTO(code, item.getDescription(), item.getQtyOnHand(), item.getUnitPrice());
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find the Item " + code, e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public CustomerDTO searchCustomer(String newValue) throws SQLException, ClassNotFoundException {
       return customerDAO.find(newValue);
    }
}
