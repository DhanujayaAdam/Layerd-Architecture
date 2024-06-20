package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.dao.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.ItemDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.OrderDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.OrderDetailDAOImpl;

//Factory design pattern - to hide object creations
public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){
    }
    public static DAOFactory getObject(){

        return (daoFactory == null) ? new DAOFactory() : daoFactory;
    }
    public enum DAOType{
        CUSTOMER,ITEM,ORDER,ORDER_DETAIL
    }
    public CrudDAO getDao(DAOType orderType){
        switch (orderType){
            case CUSTOMER:
                return  new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case ORDER_DETAIL:
                return new OrderDetailDAOImpl();
            default:
                return null;
        }
    }
}
