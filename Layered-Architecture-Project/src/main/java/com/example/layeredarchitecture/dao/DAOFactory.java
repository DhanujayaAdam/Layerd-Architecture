package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.dao.custom.impl.*;

//Factory design pattern - to hide object creations
public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){
    }
    public static DAOFactory getObject(){

        return (daoFactory == null) ? new DAOFactory() : daoFactory;
    }
    public enum DAOType{
        CUSTOMER,ITEM,ORDER,ORDER_DETAIL,QUERY
    }
    public SuperDAO getDao(DAOType orderType){
        switch (orderType){
            case CUSTOMER:
                return  new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case ORDER_DETAIL:
                return new OrderDetailDAOImpl();
            case QUERY:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }
}
