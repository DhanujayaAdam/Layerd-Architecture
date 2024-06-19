package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderBO {
    public String generateOrderId() throws SQLException, ClassNotFoundException ;
    public OrderDTO find(String newValue) throws SQLException, ClassNotFoundException ;
    public void getOrderId(String orderId) throws SQLException, ClassNotFoundException ;
    public boolean findOrderId(String orderId) throws SQLException, ClassNotFoundException ;
    public void update(OrderDTO dto) throws SQLException, ClassNotFoundException ;
    public boolean exist(String id) throws SQLException, ClassNotFoundException ;
    public void delete(String id) throws SQLException, ClassNotFoundException ;
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException ;
    public boolean addOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException ;
}
