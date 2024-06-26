package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.entity.Order;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.*;

public interface OrderDAO extends CrudDAO<Order> {
    public void getOrderId(String orderId) throws SQLException, ClassNotFoundException ;
    public boolean findOrderId(String orderId) throws SQLException, ClassNotFoundException ;

}
