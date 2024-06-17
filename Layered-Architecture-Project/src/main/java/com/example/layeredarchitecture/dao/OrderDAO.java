package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public interface OrderDAO extends CrudDAO<OrderDTO> {
    public void getOrderId(String orderId) throws SQLException, ClassNotFoundException ;
    public boolean findOrderId(String orderId) throws SQLException, ClassNotFoundException ;

}
