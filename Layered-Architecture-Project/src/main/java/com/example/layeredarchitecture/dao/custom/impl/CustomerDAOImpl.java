package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public void update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        SQLUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?",customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress());
    }
    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT id FROM Customer WHERE id=?",id);
        return resultSet.next();
    }
    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {
        SQLUtil.execute("DELETE FROM Customer WHERE id=?",id);
    }
    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer");
        ArrayList<CustomerDTO> customer = new ArrayList<>();
        while (rst.next()){
            CustomerDTO customerDTO = new CustomerDTO(rst.getString(1),rst.getString(2),rst.getString(3));
            customer.add(customerDTO);
        }
        return customer;
    }
    @Override
    public boolean add(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
       return SQLUtil.execute("INSERT INTO Customer (id,name,address) VALUES (?,?,?)",customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress());
    }
    @Override
    public String generateId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("id");
            return id;
        } else {
            return null;
        }
    }
    @Override
    public CustomerDTO find(String newValue) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer WHERE id=?",newValue + "");
        rst.next();
        CustomerDTO customerDTO = new CustomerDTO(newValue + "", rst.getString("name"), rst.getString("address"));
        return customerDTO;
    }

}
