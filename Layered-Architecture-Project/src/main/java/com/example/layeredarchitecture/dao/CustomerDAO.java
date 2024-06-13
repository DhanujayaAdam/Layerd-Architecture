package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO {
    public void updateCustomer(String id, String name, String address) throws SQLException, ClassNotFoundException ;

    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException ;

    public void deleteCustomer(String id) throws SQLException, ClassNotFoundException ;

    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException ;
    public void saveCustomer(String id, String name, String address) throws SQLException, ClassNotFoundException ;
    public String generateId() throws SQLException, ClassNotFoundException ;
    public CustomerDTO findCustomer(String newValue) throws SQLException, ClassNotFoundException ;
}
