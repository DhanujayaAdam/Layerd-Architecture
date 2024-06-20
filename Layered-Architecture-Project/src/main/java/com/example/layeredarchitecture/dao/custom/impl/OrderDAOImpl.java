package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.OrderDAO;
import com.example.layeredarchitecture.entity.Order;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.*;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public String generateId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }
    @Override
    public Order find(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }
    @Override
    public void getOrderId(String orderId) throws SQLException, ClassNotFoundException {
        SQLUtil.execute("SELECT oid FROM `Orders` WHERE oid=?");
    }
    @Override
    public boolean findOrderId(String orderId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT oid FROM Orders WHERE oid = ?", orderId);
        return resultSet.next();
    }
    @Override
    public void update(Order order) throws SQLException, ClassNotFoundException {

    }
    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {

    }
    @Override
    public ArrayList<Order> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
    @Override
    public boolean add(Order order) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",order.getOrderId(),order.getOrderDate(),order.getCustomerId());
    }
}

