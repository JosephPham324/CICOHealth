package context;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Semester: FALL 2022 Subject : FRJ301 Class : SE1606 Project : Nutrition
 *
 * @author : Group 4 CE161130 Nguyen Le Quang Thinh (Leader) CE170036 Pham Nhat
 * Quang CE160464 Nguyen The Lu CE161096 Nguyen Ngoc My Quyen CE161025 Tran Thi
 * Ngoc Hieu
 */
public class DBContext {

    private static final String dbPrefix = "jdbc:sqlserver://quangpnce.database.windows.net:1433;database=script_nutrition;user=quangpnce170036@quangpnce;password=azure73768665!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    private static final String dbPort = "1433";
    private static final String databaseName = "script_nutrition";
    private final String instance = "";
    private static final String user = "quangpnce170036@fpt.edu.vn";
    private static final String pass = "azure73768665!";
    private static final String connectionString = "jdbc:sqlserver://quangpnce.database.windows.net:1433;database=script_nutrition;user=quangpnce170036@quangpnce;password=azure73768665!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30";

    /**
     * Connect to database
     *
     * @return object Connection
     */
    public Connection getConnection() {
        Connection conn = null;
//        String dbURL = dbPrefix + ":" + dbPort + "\\" + instance + ";" + "databaseName=" + databaseName;
//        if (instance == null || instance.trim().isEmpty()) {
////            dbURL = dbPrefix + ":" + dbPort + ";" + "databaseName=" + databaseName;
//              dbURL = connectionString;
//        }
//        try {
//            DriverManager.registerDriver(new SQLServerDriver());
//            conn = DriverManager.getConnection(dbURL, user, pass);
//            System.out.println(dbPrefix);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        String hostName = "quangpnce.database.windows.net";
        String dbName = "script_nutrition";
        String user = "quangpnce170036";
        String password = "azure73768665!";
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        try {
            DriverManager.registerDriver(new SQLServerDriver());
            conn = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
