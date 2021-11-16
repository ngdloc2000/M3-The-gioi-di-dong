package dao.role;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RoleDAO {
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("JDBC_DATABASE_DRIVER");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/blog",
                    "root",
                    "ngdloc1532k");
            System.out.println("ket noi thanh cong");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Ket noi khong thanh cong");
        }
        return connection;
    }
}
