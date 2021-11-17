package dao.shop;

import config.Config;
import dao.account.AccountDAO;
import dao.account.IAccount;
import model.Account;
import model.Role;
import model.Shop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShopDAO implements IShopDAO{

    public static final String FIND_ALL_SHOP = "select * from shop;";
    public static final String INSERT_SHOP = "insert into shop(nameShop, idAccount) value (?,?);";
    public static final String FIND_SHOP_BY_ID = "select * from shop where shop.idShop = ?;";
    public static final String UPDATE_SHOP = "update shop set nameShop = ?,idAccount = ? where idShop = ?;";
    public static final String DELETE_SHOP = "delete from shop where idShop = ?;";
    public static final String FIND_ALL_SHOP_BY_USER_ID = "select * from shop where shop.idAccount = ?";
    IAccount accountDAO = new AccountDAO();
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
    public List<Shop> findAll() {
        List<Shop> list = new ArrayList<>();
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SHOP)) {
            ResultSet rs =  preparedStatement.executeQuery();
            while (rs.next()){
                int idShop = rs.getInt(1);
                String nameShop = rs.getString(2);
                int idAccount = rs.getInt(3);
                Account account = accountDAO.findById(idAccount);
                list.add(new Shop(idShop,nameShop,account));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
//    insert into shop(nameShop, idAccount) value (?,?);
    @Override
    public void add(Shop shop) {
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SHOP))
        {
            preparedStatement.setString(1,shop.getNameShop());
            preparedStatement.setInt(2,shop.getAccount().getIdUser());
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
    public Shop findById(int id) {
        Shop shop = null;
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(FIND_SHOP_BY_ID)) {
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int idShop = rs.getInt(1);
                String nameShop = rs.getString(2);
                int idAccount = rs.getInt(3);
                Account account = accountDAO.findById(idAccount);
                shop = new Shop(idShop,nameShop,account);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return shop;
    }

    @Override
    public void update(int id, Shop shop) {
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SHOP)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1,shop.getNameShop());
            preparedStatement.setInt(2,shop.getAccount().getIdUser());
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
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SHOP)) {
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

    @Override
    public List<Shop> findAllShopByIdUser(int idUser) {
        List<Shop> list = new ArrayList<>();
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SHOP_BY_USER_ID)) {
            preparedStatement.setInt(1, idUser);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int idShop = rs.getInt(1);
                String nameShop = rs.getString(2);
                int idAccount = rs.getInt(3);
                Account account = accountDAO.findById(idAccount);
                list.add(new Shop(idShop,nameShop,account));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
