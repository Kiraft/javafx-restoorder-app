package com.application.restoorderapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

//     Conexion en la nube
    private static String url = "jdbc:mysql://35.232.239.181:3306/resto_order?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String username = "root";
    private static String password = "lolxx4321";

//    private static String url = "jdbc:mysql://localhost:3306/resto_order?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=UTF-8";
//    private static String username = "root";
//    private static String password = "";

    private static Connection connection;

    public static Connection getInstance() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }

}



