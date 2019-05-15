package com.soft841.jdbc;

import javafx.scene.control.PasswordField;

import java.sql.*;

public class JDBCDemo1 {
    //JDBC驱动以及数据库连接
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/db_jdbc";

    static final String USER ="root";
    static final String PASS ="root";

    public static void main(String[] args)throws SQLException,ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        System.out.println("连接数据库。。。");
        Connection conn = DriverManager.getConnection(DB_URL,USER, PASS);
        System.out.println("实例化statement对象。。。");
        Statement stmt = conn.createStatement();
        String sql = "SELECT* FROM t_student";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            System.out.println("ID:" + id);
            System.out.print("姓名：" +name);
            System.out.print("年纪：" + age);
        }
        rs.close();
        stmt.close();
        conn.close();

    }
}





















