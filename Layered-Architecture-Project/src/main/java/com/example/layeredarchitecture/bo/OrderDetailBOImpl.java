package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.bo.custom.impl.OrderDetailBO;
import com.example.layeredarchitecture.dao.custom.OrderDetailDAO;
import com.example.layeredarchitecture.dao.custom.impl.OrderDetailDAOImpl;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailBOImpl implements OrderDetailBO {
    @Override
    public boolean addOrderDetail(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
        return orderDetailDAO.add(dto);
    }
    @Override
    public void updateOrderDetail(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {

    }
    @Override
    public boolean existOrderDetail(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
    @Override
    public void deleteOrderDetail(String id) throws SQLException, ClassNotFoundException {

    }
    @Override
    public ArrayList<OrderDetailDTO> getAllOrderDetail() throws SQLException, ClassNotFoundException {
        return null;
    }
    @Override
    public String generateOrderDetailId() throws SQLException, ClassNotFoundException {
        return null;
    }
    @Override
    public OrderDetailDTO findOrderDetailId(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }
}
