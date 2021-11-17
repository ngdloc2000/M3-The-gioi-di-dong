package dao.cartDetail;

import config.Config;
import model.Cart;
import model.CartDetail;
import model.Type;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDetailDAO implements ICartDetailDAO {


    private static final String SELECT_CartDetailDao_BY_ID = "select idCart,idProduct,number from cartdetail where idCart = ? and idProduct?;";
    private static final String INSERT_NEW_CartDetailDao = "insert into cartdetail(idCart,idProduct,number) VALUE (?,?,?);";
    private static final String DELETE_CartDetailDao_SQL = "delete from cartdetail where idCart = ? and idProduct?;";
    private static final String UPDATE_CartDetailDao_SQL = "update cartdetail set number = ? where idCart = ? and idProduct?;";
    private static final String FIND_ALL_CartDetailDao = "select * from cartdetail";

    @Override
    public List<CartDetail> findAll() {
        List<CartDetail> list;
        System.out.println(FIND_ALL_CartDetailDao);
        Connection connection=null;
        list = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(Config.MYSQL,Config.USERNAME,Config.PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_CartDetailDao);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(preparedStatement);
            while(resultSet.next()){
                int idCart = resultSet.getInt("idCart");
                int idProduct = resultSet.getInt("idProduct");
                int number =resultSet.getInt("number");
                CartDetail cartDetail = new CartDetail(idCart,idProduct,number);

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
        Connection connection=null;
        try{
            Class.forName(Config.CLASS_FOR_NAME);
            connection = DriverManager.getConnection(Config.MYSQL,Config.USERNAME,Config.PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_CartDetailDao);
            preparedStatement.setInt(1,cartDetail.getIdCart());
            preparedStatement.setInt(2,cartDetail.getIdProduct());
            preparedStatement.setInt(3,cartDetail.getNumber());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CartDetail findById(int id) {
        return null;
    }

    @Override
    public void update(int id, CartDetail cartDetail) {

    }

    @Override
    public void remove(int id) {

    }
}
