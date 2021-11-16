package dao.role;

import model.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO implements IRole {
    private static final String SELECT_ALL_ROLES = "select * from role";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/casestudym3",
                    "root",
                    "ngdloc1532k");
            System.out.println("ket noi thanh cong");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Ket noi khong thanh cong");
        }
        return connection;
    }

    @Override
    public List<Role> findAll() {
        Connection connection = getConnection();
        List<Role> roleList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ROLES);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idRole");
                String name = rs.getString("nameRole");
                roleList.add(new Role(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleList;
    }

    @Override
    public void add(Role role) {

    }

    @Override
    public Role findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Role role) {

    }

    @Override
    public void remove(int id) {

    }
}
