package dao.cart;

import config.Config;
import dao.cartDetail.CartDetailDAO;
import dao.cartDetail.ICartDetailDAO;
import model.Cart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDAO implements ICartDao {
    final String FIND_ALL_CART = "select * from cart;";
    final String ADD_CART = "insert into cart value(?,?,?,?);";
    final String FIND_BY_ID = "select * from cart where idCart = ?;";
    final String FIND_BY_ID_ACCOUNT = " select * from cart where idAccount = ?";
    final String UPDATE_BY_ID = "update cart set idAccount = ?, createDate = ? , status = ?"+
            " where idCart = ? ;";
    final String DELETE_BY_ID = "delete from cart where idCart = ?";


    private ICartDetailDAO cartDetailDAO = new CartDetailDAO();
    private Connection connection = null;
    private Connection getConnection(){
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
            int idAccount = rs.getInt(2);
            int idCart = rs.getInt(1);
            Date createDate = rs.getDate(3);
            int status =rs.getInt(4);
            list.add(new Cart(idCart,idAccount,createDate,status));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void add(Cart cart) {
        try {
            PreparedStatement ps = getConnection().prepareStatement(ADD_CART);
            ps.setInt(1,cart.getIdCart());
            ps.setInt(2,cart.getIdAccount());
            ps.setDate(3, (Date) cart.getCreateDate());
            ps.setInt(4,cart.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cart findById(int id) {
        Cart cart = null;
        try {
            PreparedStatement ps = getConnection().prepareStatement(FIND_BY_ID);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            int idCart = rs.getInt("idCart");
            int idAccount = rs.getInt("idAccount");
            Date createDate = rs.getDate("createDate");
            int status =rs.getInt("status");
            cart = new Cart(idCart,idAccount,createDate,status);
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
}
