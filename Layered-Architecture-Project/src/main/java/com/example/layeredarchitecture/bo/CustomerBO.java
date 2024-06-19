package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO {
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException ;
    public void updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException ;
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException ;
    public void deleteCustomer(String id) throws SQLException, ClassNotFoundException ;
    public boolean addCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException ;
    public String generateCustomerId() throws SQLException, ClassNotFoundException ;
    public CustomerDTO findCustomer(String newValue) throws SQLException, ClassNotFoundException ;

}
