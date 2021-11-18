package dao.rate;

import config.Config;
import model.Rate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RateDAO implements IRateDAO{
    final String FIND_ALL_RATE_BY_ID_PRODUCT ="select * from rate where idProduct = ?";
    final String FIND_ALL_RATE_BY_ID_ACCOUNT ="select * from rate where idAccount = ?";
    final String FIND_AVG_RATE_BY_ID_PRODUCT = "select avg(rate) from rate group by idProduct having idProduct = ?;";
    final String ADD_RATE = "insert into rate (idAccount, idProduct, comment, rate) VALUE (?,?,?,?)";

    private Connection getConnection(){
    Connection connection = null ;
            try {
                Class.forName(Config.CLASS_FOR_NAME);
                connection = DriverManager.getConnection(Config.MYSQL,Config.USERNAME,Config.PASSWORD);

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        return connection;
    }

    @Override
    public List<Rate> findAll() {
        return null;
    }

    @Override
    public void add(Rate rate) {
        try {
            PreparedStatement ps = getConnection().prepareStatement(ADD_RATE);
            ps.setInt(1,rate.getAccount().getIdUser());
            ps.setInt(2, rate.getProduct().getIdProduct());
            ps.setString(3, rate.getComment());
            ps.setInt(4,rate.getRate());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Rate findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Rate rate) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Rate> findAllRateByIdProduct(int idProduct) {
        List<Rate> rateList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(FIND_ALL_RATE_BY_ID_PRODUCT);
            ps.setInt(1,idProduct);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int idRate = rs.getInt(1);
                int idAccount = rs.getInt(2);
                String comment = rs.getString(4);
                int rate = rs.getInt(5);
                Rate rate1 = new Rate(idRate,idAccount,idProduct,comment,rate);
                rateList.add(rate1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rateList;
    }

    @Override
    public List<Rate> findAllRateByIdAccount(int idAccount) {
        List<Rate> rateList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(FIND_ALL_RATE_BY_ID_ACCOUNT);
            ps.setInt(1,idAccount);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int idRate = rs.getInt(1);
                int idProduct = rs.getInt(3);
                String comment = rs.getString(4);
                int rate = rs.getInt(5);
                Rate rate1 = new Rate(idRate,idAccount,idProduct,comment,rate);
                rateList.add(rate1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rateList;
    }

    @Override
    public int findAVGRateByIdProduct(int idProduct) {
        Connection connection = getConnection();
        int avgRate =0;
        try {
            PreparedStatement ps = connection.prepareStatement(FIND_AVG_RATE_BY_ID_PRODUCT);
            ps.setInt(1,idProduct);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                avgRate = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return avgRate;
    }
}
