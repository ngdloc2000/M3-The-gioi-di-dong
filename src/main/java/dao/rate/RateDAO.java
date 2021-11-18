package dao.rate;

import config.Config;
import model.Rate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RateDAO implements IRateDAO{
    final String FIND_ALL_RATE_BY_ID_PRODUCT ="select * from rate where idProduct = ?";
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
            PreparedStatement ps = connection.prepareStatement(FIND_ALL_RATE_BY_ID_PRODUCT);
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
}
