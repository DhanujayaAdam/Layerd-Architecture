package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.*;
import java.util.ArrayList;

public interface OrderDAO {
    public String generateId() throws SQLException, ClassNotFoundException ;
    public void getOrderId(String orderId) throws SQLException, ClassNotFoundException ;
    public boolean placeOrder(String orderId, String orderDate, ArrayList<OrderDetailDTO> orderDetails, String customerId) throws SQLException, ClassNotFoundException ;
}
