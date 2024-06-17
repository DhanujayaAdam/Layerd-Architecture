package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.custom.OrderDetailDAO;
import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public boolean add(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
       return SQLUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",dto.getOrderId(),dto.getItemCode(),dto.getUnitPrice(),dto.getQty());
    }

    @Override
    public void update(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {

    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public ArrayList<OrderDetailDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }


    @Override
    public String generateId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public OrderDetailDTO find(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }
}
