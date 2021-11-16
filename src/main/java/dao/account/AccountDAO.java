package dao.account;

import config.Config;
import dao.role.RoleDAO;
import model.Account;
import model.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements IAccount{

    public static final String FIND_ALL_ACCOUNT = "select * from account join role r on r.idRole = account.idRole";
    public static final String INSERT_ACCOUNT = "insert into account(username, password, name, idRole) value(?,?,?,?); ";
    public static final String FIND_ACCOUNT_BY_ID = "select a.idAccount, a.username,a.password,a.name,a.idRole from account a join role r on r.idRole = a.idRole where a.idAccount = ?;";
    public static final String UPDATE_ACCOUNT = "update account set username = ?, password = ?, name = ?, idRole = ? where idAccount = ?;";
    public static final String DELETE_ACCOUNT = "delete from account where idAccount = ?;";
    RoleDAO roleDAO = new RoleDAO();
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
    }
    @Override
    public List<Account> findAll() {
        List<Account> list = new ArrayList<>();
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_ACCOUNT)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int idAccount = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String name = rs.getString(4);
                int  idRole = rs.getInt(5);
                Role role = roleDAO.findById(idRole);
                list.add(new Account(idAccount,username,password,name,role));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    return list;
    }

    @Override
    public void add(Account account) {
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOUNT)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setString(3,account.getName());
            preparedStatement.setInt(4,account.getRole().getIdRole());
            int check = preparedStatement.executeUpdate();
            if(check == 0){
                connection.rollback();
            }
            else {
                connection.commit();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Account findById(int id) {
        Account account = null;
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(FIND_ACCOUNT_BY_ID)) {
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int idAccount = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String name = rs.getString(4);
                int idRole = rs.getInt(5);

                Role role = roleDAO.findById(idRole);
                account = new Account(idAccount,username,password,name,role);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return account;
    }
    @Override
    public void update(int id, Account account) {
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,account.getPassword());
            preparedStatement.setString(3,account.getName());
            preparedStatement.setInt(4,account.getRole().getIdRole());
            preparedStatement.setInt(5,id);
            int check = preparedStatement.executeUpdate();
            if(check == 0){
                connection.rollback();
            }
            else {
                connection.commit();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ACCOUNT)) {
            connection.setAutoCommit(false);
            preparedStatement.setInt(1,id);
            int check = preparedStatement.executeUpdate();
            if(check == 0){
                connection.rollback();
            }
            else {
                connection.commit();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
