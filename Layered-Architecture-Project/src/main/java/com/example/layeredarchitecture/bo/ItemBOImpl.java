package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.dao.custom.impl.ItemDAOImpl;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl {
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        ItemDAO itemDAO = new ItemDAOImpl();
        return itemDAO.getAll();
    }

    public void delete(String code) throws SQLException, ClassNotFoundException {
        SQLUtil.execute("DELETE FROM Item WHERE code=?",code);
    }
    public boolean add(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",itemDTO.getCode(),itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand());
    }

    public void update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand(),itemDTO.getCode());
    }

    public boolean exist(String code) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT code FROM Item WHERE code=?",code);
        return resultSet.next();
    }

    public String generateId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()){
            return rst.getString("code");
        }
        return null;
    }

    public ItemDTO find(String newItemCode) throws SQLException, ClassNotFoundException {
        ResultSet rst =SQLUtil.execute("SELECT * FROM Item WHERE code=?",newItemCode + "");
        rst.next();
        ItemDTO item = new ItemDTO(newItemCode + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
        return item;
    }

    public boolean updateItemAfterPlaceOrder(ItemDTO item) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",item.getDescription(),item.getUnitPrice(),item.getQtyOnHand(),item.getCode());
    }
}
