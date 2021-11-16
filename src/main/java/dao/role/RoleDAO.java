package dao.role;

<<<<<<< HEAD
<<<<<<< HEAD
=======
import config.Config;
>>>>>>> fde021ca9380dcd896fbda1193945ab52658fca4
import model.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO implements IRole {
    private static final String SELECT_ALL_ROLES = "select * from role";
    private static final String SELECT_ROLE_BY_ID = "select * from role where idRole = ?";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(Config.CLASS_FOR_NAME);
            connection = DriverManager.getConnection(
                    Config.MYSQL,
                    Config.USERNAME,
                    Config.PASSWORD);
            System.out.println("ket noi thanh cong");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Ket noi khong thanh cong");
        }
        return connection;
=======
import dao.IDao;
import model.Role;

import java.util.List;

public class RoleDAO implements IDao<Role> {


    @Override
    public List<Role> findAll() {
        return null;
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

>>>>>>> d0617002eb56e2d147ace1f1032330b1c1cc0e33
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
        Connection connection = getConnection();
        Role role = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROLE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("nameRole");
                role = new Role(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public void update(int id, Role role) {

    }

    @Override
    public void remove(int id) {

    }
}
