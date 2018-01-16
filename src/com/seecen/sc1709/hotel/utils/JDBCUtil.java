package com.seecen.sc1709.hotel.utils;

import java.sql.*;

public class JDBCUtil {
    private final static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    private final static String user ="hotel";
    private final static String pass ="hotel";
    public static Connection getConnection(){

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            return DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public static void close(Connection conn, Statement stm, ResultSet set){
        try {
            if(set!=null){
                set.close();
            }
            if(stm!=null){
                stm.close();
            }
            if (conn!=null){
                conn.close();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
