package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.custom.OrderDAO;
import com.example.layeredarchitecture.dao.custom.impl.OrderDAOImpl;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderBOImpl {
    OrderDAO orderDAO = new OrderDAOImpl();
    public String generateOrderId() throws SQLException, ClassNotFoundException {
       return orderDAO.generateId();
    }
    public OrderDTO find(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }
    public void getOrderId(String orderId) throws SQLException, ClassNotFoundException {
        orderDAO.getOrderId(orderId);
    }
    public boolean findOrderId(String orderId) throws SQLException, ClassNotFoundException {
        return orderDAO.findOrderId(orderId);
    }
    public void update(OrderDTO dto) throws SQLException, ClassNotFoundException {
    }
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
    public void delete(String id) throws SQLException, ClassNotFoundException {
    }
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
    public boolean addOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        return orderDAO.add(orderDTO);
    }
}
