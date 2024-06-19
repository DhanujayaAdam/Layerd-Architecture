package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO =  new CustomerDAOImpl();
    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        return customerDAO.getAll();
    }
    @Override
    public void updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
       customerDAO.update(customerDTO);
    }
    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
       return customerDAO.exist(id);
    }
    @Override
    public void deleteCustomer(String id) throws SQLException, ClassNotFoundException {
       customerDAO.delete(id);
    }
    @Override
    public boolean addCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.add(customerDTO);
    }
    @Override
    public String generateCustomerId() throws SQLException, ClassNotFoundException {
        return customerDAO.generateId();
    }
    @Override
    public CustomerDTO findCustomer(String newValue) throws SQLException, ClassNotFoundException {
        return customerDAO.find(newValue);
    }
}
