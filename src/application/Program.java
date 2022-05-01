package application;

import com.mysql.cj.jdbc.StatementImpl;
import db.DB;
import db.DbException;
import db.DbIntegrityException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Program {
    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;

        try {
            conn = DB.getConnection();
            conn.setAutoCommit(false);
            st = conn.createStatement();




        } catch (SQLException e) {
            try {
                conn.rollback();
                throw new DbException("Transaction rolled back. Caused by " + e.getMessage());
            } catch (SQLException ex) {
                throw new DbException("Error trying do rollback. Caused by " + ex.getMessage());
            }
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
