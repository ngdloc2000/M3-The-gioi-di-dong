package dao.cartDetail;

import config.Config;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CartDetailDAO implements ICartDetailDAO {


    private static final String SELECT_CartDetailDao_BY_ID = "select idCart,idProduct,number from cartdetail where idCart = ? and idProduct?;";
    private static final String INSERT_NEW_CartDetailDao = "insert into cartdetail(idCart,idProduct,number) VALUE (?,?,?);";
    private static final String DELETE_CartDetailDao_SQL = "delete from cartdetail where idCart = ? and idProduct?;";
    private static final String UPDATE_CartDetailDao_SQL = "update cartdetail set number = ? where idCart = ? and idProduct?;";
    private static final String FIND_ALL_CartDetailDao = "select * from cartdetail";
    static final String FIND_ALL_CARTDetail_BY_IDCART = "select * from cartdetail where idCart = ?;";
    static String FIND_ALL_CARTDETAIL_BY_IDPRODUCT = "select * from cartdetail where idProduct = ?;";


    @Override
    public List<CartDetail> findAll() {
        List<CartDetail> list;
        System.out.println(FIND_ALL_CartDetailDao);
        Connection connection = null;
        list = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(Config.MYSQL, Config.USERNAME, Config.PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_CartDetailDao);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(preparedStatement);
            while (resultSet.next()) {
                int idCart = resultSet.getInt("idCart");
                int idProduct = resultSet.getInt("idProduct");
                int number = resultSet.getInt("number");
                CartDetail cartDetail = new CartDetail(idCart, idProduct, number);

                list.add(cartDetail);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;

    }


    @Override
    public void add(CartDetail cartDetail) {
        Connection connection = null;
        try {
            Class.forName(Config.CLASS_FOR_NAME);
            connection = DriverManager.getConnection(Config.MYSQL, Config.USERNAME, Config.PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_CartDetailDao);
            preparedStatement.setInt(1, cartDetail.getIdCart());
            preparedStatement.setInt(2, cartDetail.getIdProduct());
            preparedStatement.setInt(3, cartDetail.getNumber());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CartDetail findById(int id) {
        return null;
    }

    @Override
    public void update(int id, CartDetail cartDetail) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Config.MYSQL, Config.USERNAME, Config.PASSWORD);
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement("update cartdetail set cartdetail.number = ? where cartdetail.idCart = ? and cartdetail.idProduct = ?;");
            ps.setInt(1,id);
            ps.setInt(2,cartDetail.getIdCart());
            ps.setInt(3,cartDetail.getIdProduct());
            int check = ps.executeUpdate();
            if(check == 0){
                connection.rollback();
            }
            else {
                connection.commit();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {

    }

    public List<CartDetail> findAllCartDetailByIdCart(int idCart) {
        List<CartDetail> cartDetailList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Config.MYSQL, Config.USERNAME, Config.PASSWORD);
            PreparedStatement ps = connection.prepareStatement(FIND_ALL_CARTDetail_BY_IDCART);
            ps.setInt(1, idCart);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idProduct = rs.getInt("idProduct");
                int number = rs.getInt("number");
                cartDetailList.add(new CartDetail(idCart, idProduct, number));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return cartDetailList;
    }

    public List<CartDetail> findAllCartDetailByIdProduct(int idProduct) {
        List<CartDetail> cartDetailList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Config.MYSQL, Config.USERNAME, Config.PASSWORD);
            PreparedStatement ps = connection.prepareStatement(FIND_ALL_CARTDETAIL_BY_IDPRODUCT);
            ps.setInt(1, idProduct);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idCart = rs.getInt("idCart");
                int number = rs.getInt("number");
                cartDetailList.add(new CartDetail(idCart, idProduct, number));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return cartDetailList;
    }
    @Override
    public CartDetail findCartDetailForIdProductAndIdCart(int idProduct, int idCart) {
        CartDetail cartDetail = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Config.MYSQL, Config.USERNAME, Config.PASSWORD);
            PreparedStatement ps = connection.prepareStatement("select * from cartdetail join cart c on c.idCart = cartdetail.idCart where status = 0 and c.idCart = ? and cartdetail.idProduct = ?;");
            ps.setInt(1, idProduct);
            ps.setInt(2, idCart);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idCart1 = rs.getInt(1);
                int idProduct1 = rs.getInt(2);
                int number = rs.getInt(3);
                cartDetail = new CartDetail(idCart1, idProduct1, number);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return cartDetail;
    }
    @Override
    public List<ShowCart> showCartByidCart(int idCart){
        List<ShowCart> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Config.MYSQL, Config.USERNAME, Config.PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from cartdetail join product p on cartdetail.idProduct = p.idProduct join cart c on c.idCart = cartdetail.idCart where status = 0 and c.idCart = ?;");
            preparedStatement.setInt(1,idCart);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String nameProduct = rs.getString(5);
                int number = rs.getInt(3);
                int price = rs.getInt(6);
                list.add(new ShowCart(nameProduct,number,price));
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

