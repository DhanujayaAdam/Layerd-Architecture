package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.bo.SuperBO;
import com.example.layeredarchitecture.entity.Item;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException ;
    public void deleteItem(String code) throws SQLException, ClassNotFoundException ;
    public boolean addItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException ;
    public void updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException ;
    public boolean existItem(String code) throws SQLException, ClassNotFoundException ;
    public String generateItemId() throws SQLException, ClassNotFoundException ;
    public Item findItem(String newItemCode) throws SQLException, ClassNotFoundException ;
    public boolean updateItemAfterPlaceOrder(ItemDTO item) throws SQLException, ClassNotFoundException ;
}
