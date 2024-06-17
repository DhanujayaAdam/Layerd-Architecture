package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.OrderDetailDAO;
import com.example.layeredarchitecture.dao.custom.impl.OrderDetailDAOImpl;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailBOImpl{
    public boolean addOrderDetail(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
        return orderDetailDAO.add(dto);
    }
    public void updateOrderDetail(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {

    }
    public boolean existOrderDetail(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
    public void deleteOrderDetail(String id) throws SQLException, ClassNotFoundException {

    }
    public ArrayList<OrderDetailDTO> getAllOrderDetail() throws SQLException, ClassNotFoundException {
        return null;
    }

    public String generateOrderDetailId() throws SQLException, ClassNotFoundException {
        return null;
    }
    public OrderDetailDTO findOrderDetailId(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }
}
