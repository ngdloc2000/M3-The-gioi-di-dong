package dao.account;

import model.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements IAccount{

    public static final String FIND_ALL_ACCOUNT = "select * from account join role r on r.idRole = account.idRole";


    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/casestudym3",
                    "root",
                    "3008");
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

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    return null;
    }




    @Override
    public void add(Account account) {

    }

    @Override
    public Account findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Account account) {

    }

    @Override
    public void remove(int id) {

    }
}
