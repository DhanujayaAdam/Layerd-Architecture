package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.custom.OrderDAO;
import com.example.layeredarchitecture.dao.custom.impl.OrderDAOImpl;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderBOImpl implements OrderBO {
    OrderDAO orderDAO = new OrderDAOImpl();
    @Override
    public String generateOrderId() throws SQLException, ClassNotFoundException {
       return orderDAO.generateId();
    }
    @Override
    public OrderDTO find(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }
    @Override
    public void getOrderId(String orderId) throws SQLException, ClassNotFoundException {
        orderDAO.getOrderId(orderId);
    }
    @Override
    public boolean findOrderId(String orderId) throws SQLException, ClassNotFoundException {
        return orderDAO.findOrderId(orderId);
    }
    @Override
    public void update(OrderDTO dto) throws SQLException, ClassNotFoundException {
    }
    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {
    }
    @Override
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
    @Override
    public boolean addOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        return orderDAO.add(orderDTO);
    }
}
