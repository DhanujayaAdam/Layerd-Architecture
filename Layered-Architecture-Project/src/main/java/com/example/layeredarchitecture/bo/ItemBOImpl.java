package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.dao.custom.impl.ItemDAOImpl;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl {
    ItemDAO itemDAO = new ItemDAOImpl();
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }
    public void deleteItem(String code) throws SQLException, ClassNotFoundException {
        itemDAO.delete(code);
    }
    public boolean addItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDAO.add(itemDTO);
    }
    public void updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        itemDAO.update(itemDTO);
    }
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }
    public String generateItemId() throws SQLException, ClassNotFoundException {
       return itemDAO.generateId();
    }
    public ItemDTO findItem(String newItemCode) throws SQLException, ClassNotFoundException {
        return itemDAO.find(newItemCode);
    }
    public boolean updateItemAfterPlaceOrder(ItemDTO item) throws SQLException, ClassNotFoundException {
        return itemDAO.updateItemAfterPlaceOrder(item);
    }
}
