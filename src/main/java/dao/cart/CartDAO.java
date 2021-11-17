package dao.cart;

import config.Config;
import dao.cartDetail.CartDetailDAO;
import dao.cartDetail.ICartDetailDAO;
import model.Cart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDAO implements ICartDao {
    public static final String FIND_CART_BY_ID_ACCOUNT = "select * from cart where cart.idAccount = ?;";
    final String FIND_ALL_CART = "select * from cart;";
    final String ADD_CART = "insert into cart(idAccount, createDate, status) VALUE (?,?,?);";
    final String FIND_BY_ID = "select * from cart where idCart = ?;";
    final String FIND_BY_ID_ACCOUNT = " select * from cart where idAccount = ?";
    final String UPDATE_BY_ID = "update cart set idAccount = ?, createDate = ? , status = ?"+
            " where idCart = ? ;";
    final String DELETE_BY_ID = "delete from cart where idCart = ?";


    private ICartDetailDAO cartDetailDAO = new CartDetailDAO();

    private Connection getConnection(){
        Connection connection = null;
        if(connection==null){
            try {
                Class.forName(Config.CLASS_FOR_NAME);
                connection = DriverManager.getConnection(Config.MYSQL,Config.USERNAME,Config.PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }



    @Override
    public List<Cart> findAll() {
        List<Cart> list = new ArrayList<>();
        try {
            PreparedStatement ps = getConnection().prepareStatement(FIND_ALL_CART);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int idCart = rs.getInt("idCart");
                int idAccount = rs.getInt("idAccount");
                Date createDate = rs.getDate("createDate");
                int status =rs.getInt("status");
                list.add(new Cart(idCart,idAccount,createDate,status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void add(Cart cart) {
        try {
            PreparedStatement ps = getConnection().prepareStatement(ADD_CART);
            ps.setInt(1,cart.getIdAccount());
            ps.setDate(2, (Date) cart.getCreateDate());
            ps.setInt(3,cart.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public int addReturnIDCart(Cart cart) {
        int idCart = 0;
        try {
            Connection connection = getConnection();
            connection.setAutoCommit(false);
            PreparedStatement ps = getConnection().prepareStatement(ADD_CART,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,cart.getIdAccount());
            ps.setDate(2, (Date) cart.getCreateDate());
            ps.setInt(3,cart.getStatus());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()){
                idCart = rs.getInt(1);
            }
            if(idCart == 0){
                connection.rollback();
            }
            else {
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idCart;
    }

    @Override
    public Cart findById(int id) {
        Cart cart = null;
        try {
            PreparedStatement ps = getConnection().prepareStatement(FIND_BY_ID);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int idCart = rs.getInt(1);
                int idAccount = rs.getInt(2);
                Date createDate = rs.getDate(3);
                int status =rs.getInt(4);
                cart = new Cart(idCart,idAccount,createDate,status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cart;
    }

    @Override
    public void update(int id, Cart cart) {
        try {
            PreparedStatement ps = getConnection().prepareStatement(UPDATE_BY_ID);
            ps.setInt(1,cart.getIdAccount());
            ps.setDate(2, (Date) cart.getCreateDate());
            ps.setInt(3,cart.getStatus());
            ps.setInt(4,cart.getIdCart());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        try {
            PreparedStatement ps = getConnection().prepareStatement(DELETE_BY_ID);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cart findByIdAccount(int idAccount){
        Cart cart = null;
        try {
            PreparedStatement ps = getConnection().prepareStatement(FIND_BY_ID);
            ps.setInt(1,idAccount);
            ResultSet rs = ps.executeQuery();
            int idCart = rs.getInt("idCart");
            Date createDate = rs.getDate("createDate");
            int status =rs.getInt("status");
            cart = new Cart(idCart,idAccount,createDate,status);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cart;
    }

    @Override
    public List<Cart> findAllCartByIdAccount(int idUser) {
        List<Cart> list = new ArrayList<>();
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(FIND_CART_BY_ID_ACCOUNT)) {
            preparedStatement.setInt(1,idUser);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int idCart = rs.getInt(1);
                int idAccount = rs.getInt(2);
                Date date = rs.getDate(3);
                int status = rs.getInt(4);
                list.add(new Cart(idCart, idAccount,date,status));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    @Override
    public int findIdCartCartForIdAccount(List<Cart> list){
        int idCart = -1;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getStatus() == 0){
                idCart = list.get(i).getIdCart();
            }
        }
        return idCart;
    }
}
