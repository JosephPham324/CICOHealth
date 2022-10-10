/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Thinh
 */
public class DBContext {

    private static final String dbPrefix = "jdbc:sqlserver://localhost:1433;databaseName=Nutrition";
    private static final String dbPort = "1433";
    private static final String databaseName = "Nutrition";
    private final String instance = "";
    private static final String user = "sa";
    private static final String pass = "123456";

    public Connection getConnection() {
        Connection conn = null;
        String dbURL = dbPrefix + ":" + dbPort + "\\" + instance + ";" + "databaseName=" + databaseName;
        if (instance == null || instance.trim().isEmpty()) {
            dbURL = dbPrefix + ":" + dbPort + ";" + "databaseName=" + databaseName;
        }
        try {
            DriverManager.registerDriver(new SQLServerDriver());
            conn = DriverManager.getConnection(dbURL, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}

