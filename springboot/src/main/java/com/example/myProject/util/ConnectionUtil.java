package com.example.myProject.util;

import java.sql.*;

public class ConnectionUtil {
    Connection con = null;

    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/cti?useSSL=true&serverTimezone=Asia/Shanghai&characterEncoding=UTF8";
        String username = "root";
        String password = "123456";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("驱动加载成功");
            con = DriverManager.getConnection(url, username, password);
            System.out.println("连接成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) throws SQLException {
        Connection con;
        Statement sql;
        ResultSet res;

        ConnectionUtil c = new ConnectionUtil();
        con = c.getConnection();

        sql = con.createStatement();
        res = sql.executeQuery("select * from a");
        while (res.next()) {
            String name = res.getString("name");
            System.out.println(name);
        }
    }
}
