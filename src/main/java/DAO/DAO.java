package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * FPT University Can Tho Semester: FALL 2022
 * <br>Subject : FRJ301
 * <br>Class : SE1606
 * <br>Project : Nutrition
 * <br>
 * <br>
 *
 * @author : Group 4
 * @author: CE161130 Nguyen Le Quang Thinh (Leader)
 * @author: CE170036 Pham Nhat Quang
 * @author: CE160464 Nguyen The Lu <br>CE161096 Nguyen Ngoc My Quyen
 * @author: CE161025 Tran Thi Ngoc Hieu
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
