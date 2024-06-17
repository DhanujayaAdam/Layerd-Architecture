package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;

public interface ItemDAO extends CrudDAO<ItemDTO> {
    public boolean updateItemAfterPlaceOrder(ItemDTO item) throws SQLException, ClassNotFoundException;
}