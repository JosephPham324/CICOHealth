package context;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Semester: FALL 2022
 * Subject : FRJ301
 * Class   : SE1606
 * Project : Nutrition 
 * @author : Group 4
 * CE161130  Nguyen Le Quang Thinh (Leader)
 * CE170036  Pham Nhat Quang
 * CE160464  Nguyen The Lu
 * CE161096  Nguyen Ngoc My Quyen
 * CE161025  Tran Thi Ngoc Hieu
 */
public class DBContext {

    private static final String dbPrefix = "jdbc:sqlserver://localhost:1433;databaseName=Nutrition [sa on SA]";
    private static final String dbPort = "1433";
    private static final String databaseName = "Nutrition";
    private final String instance = "";
    private static final String user = "sa";
    private static final String pass = "123456";

    /**
     * Connect to database
     * @return object Connection
     */
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

