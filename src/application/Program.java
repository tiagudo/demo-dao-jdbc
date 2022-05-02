package application;

import com.mysql.cj.jdbc.StatementImpl;
import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.entities.Department;
import model.entities.Seller;

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

            Department obj = new Department(1, "Books");
            Seller seller = new Seller(21, "Bob Brown", "bob@gmail.com", LocalDate.now(),
                    3200.00, obj);

            System.out.println(seller);



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
