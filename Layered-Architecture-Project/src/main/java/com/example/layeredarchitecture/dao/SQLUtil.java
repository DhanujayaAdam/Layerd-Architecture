package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLUtil {
    public static <T> T execute(String sql, Object... obj) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        int index = 1;
        for (Object i : obj){
            pstm.setObject(index,i);
            ++index;
        }
        if (sql.startsWith("SELECT")){
            return (T) pstm.executeQuery();
        } else {
            return (T) (Boolean)(pstm.executeUpdate() > 0);
        }
    }
}
