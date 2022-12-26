package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pham Nhat Quang CE170036 (FPTU CANTHO)
 */
public class DAO {

    /**
     * Connection to database
     */
    protected Connection con = null;

    /**
     * Move query from Netbeans to SQl
     */
    protected PreparedStatement ps = null;

    /**
     * Save query result
     */
    protected ResultSet rs = null;

    protected void closeConnections() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                /* Ignored */
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                /* Ignored */
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                /* Ignored */
            }
        }
    }
}
