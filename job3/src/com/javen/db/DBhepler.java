package com.javen.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBhepler {
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://127.0.0.1;DatabaseName=courseplan;";
    /*String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://127.0.0.1:3306/courseplan";*/
    
    
    Connection con = null;
    ResultSet res = null;

    public void getDataBaseConnection() {
            try {
                Class.forName(driver);
                con = DriverManager.getConnection(url, "sa", "123");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                  System.out.println("装载 JDBC/ODBC 驱动程序失败。");  
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("无法连接数据库"); 
                e.printStackTrace();
            }
    }

    // 查询
    public ResultSet  getAllinformation(String sql, String str[]) {
    	getDataBaseConnection();
        try {
            PreparedStatement pst =con.prepareStatement(sql);
            if (str != null) {
                for (int i = 0; i < str.length; i++) {
                    pst.setString(i + 1, str[i]);
                }
            }
            res = pst.executeQuery();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return res;
    }

    // 增删修改
    public int AddUpdate(String sql, String str[]) {
        int a = 0;
        getDataBaseConnection();
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            if (str != null) {
                for (int i = 0; i < str.length; i++) {
                    pst.setString(i + 1, str[i]);
                }
            }
            a = pst.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return a;
    }

}