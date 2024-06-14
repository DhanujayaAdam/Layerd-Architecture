package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface OrderDetailDAO {
    public boolean saveDetail(Connection connection,String orderId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;
}
