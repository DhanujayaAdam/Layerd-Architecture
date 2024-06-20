package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.CustomerBO;
import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getObject().getDao(DAOFactory.DAOType.CUSTOMER);
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        return customerDAO.getAll();
    }
    public void updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
       customerDAO.update(customerDTO);
    }
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
       return customerDAO.exist(id);
    }
    public void deleteCustomer(String id) throws SQLException, ClassNotFoundException {
       customerDAO.delete(id);
    }
    public boolean addCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.add(customerDTO);
    }
    public String generateCustomerId() throws SQLException, ClassNotFoundException {
        return customerDAO.generateId();
    }
    public CustomerDTO findCustomer(String newValue) throws SQLException, ClassNotFoundException {
        return customerDAO.find(newValue);
    }
}
