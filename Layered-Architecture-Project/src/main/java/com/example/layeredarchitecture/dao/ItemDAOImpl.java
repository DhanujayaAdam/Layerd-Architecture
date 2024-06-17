package com.example.layeredarchitecture.dao;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROm Item");
        ArrayList<ItemDTO> itemDTOS = new ArrayList<>();
        while (rst.next()){
            itemDTOS.add(new ItemDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getBigDecimal(3),
                    rst.getInt(4)
            ));
        }
        return itemDTOS;
    }
    @Override
    public void deleteItem(String code) throws SQLException, ClassNotFoundException {
       SQLUtil.execute("DELETE FROM Item WHERE code=?",code);
    }
    @Override
    public void saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        SQLUtil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",itemDTO.getCode(),itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand());
    }
    @Override
    public void updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand(),itemDTO.getCode());
    }
    @Override
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT code FROM Item WHERE code=?",code);
        return resultSet.next();
    }
    @Override
    public String generateId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()){
            return rst.getString("code");
        }
        return null;
    }
    @Override
    public ItemDTO findItem(String newItemCode) throws SQLException, ClassNotFoundException {
        ResultSet rst =SQLUtil.execute("SELECT * FROM Item WHERE code=?",newItemCode + "");
        rst.next();
        ItemDTO item = new ItemDTO(newItemCode + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
    return item;
    }
    @Override
    public boolean updateItemAfterPlaceOrder(ItemDTO item) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",item.getDescription(),item.getUnitPrice(),item.getQtyOnHand(),item.getCode());
    }
}
