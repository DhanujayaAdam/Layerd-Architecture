package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.dao.custom.OrderDetailDAO;
import com.example.layeredarchitecture.dao.custom.impl.OrderDetailDAOImpl;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDetailBO {
    public boolean addOrderDetail(OrderDetailDTO dto) throws SQLException, ClassNotFoundException ;
    public void updateOrderDetail(OrderDetailDTO dto) throws SQLException, ClassNotFoundException ;
    public boolean existOrderDetail(String id) throws SQLException, ClassNotFoundException ;
    public void deleteOrderDetail(String id) throws SQLException, ClassNotFoundException ;
    public ArrayList<OrderDetailDTO> getAllOrderDetail() throws SQLException, ClassNotFoundException ;

    public String generateOrderDetailId() throws SQLException, ClassNotFoundException ;
    public OrderDetailDTO findOrderDetailId(String newValue) throws SQLException, ClassNotFoundException ;
}
