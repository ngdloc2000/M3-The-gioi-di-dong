package dao.type;
import Config.Config;
import model.Type;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypeDAO implements ITypeDAO {
    private List<Type> list;
    private String jdbcURL = "jdbc:mysql://localhost:3306/casestudym3";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";

    private static final String SELECT_TYPE_BY_ID = "select idType,nameType from type where idType =?;";
    private static final String INSERT_NEW_TYPE = "insert into type(nameType) VALUE (?);";
    private static final String DELETE_TYPE_SQL = "delete from type where idType = ?;";
    private static final String UPDATE_TYPE_SQL = "update type set nameType = ? where idType = ?;";
    private static final String FIND_ALL_TYPE = "select * from type";
public TypeDAO(){

}
        @Override
    public List<Type> findAll() {
        System.out.println(FIND_ALL_TYPE);
        Connection connection=null;
        list = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(preparedStatement);
            while(resultSet.next()){
                int idType = resultSet.getInt("idType");
                String name =resultSet.getString("nameType");
                Type type = new Type(idType,name);

                list.add(type);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
return list;
    }

    @Override
    public void add(Type type) {
        Connection connection=null;
        try{
            Class.forName(Config.CLASS_FOR_NAME);
            connection = DriverManager.getConnection(Config.MYSQL,Config.USERNAME,Config.PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_TYPE);
            preparedStatement.setString(1, type.getName());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Type findById(int id) {
        System.out.println(SELECT_TYPE_BY_ID);
        Connection connection=null;
        Type type  = null;
 try{
         Class.forName("com.mysql.jdbc.Driver");
         connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
         PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TYPE_BY_ID);
         preparedStatement.setInt(1, id);
         ResultSet resultSet = preparedStatement.executeQuery();
         System.out.println(preparedStatement);
         if (resultSet.next()){
             String nameType = resultSet.getString(2);
             type = new Type(id, nameType);
         }

     } catch (ClassNotFoundException e) {
         e.printStackTrace();
     }catch (SQLException e) {
         e.printStackTrace();
    }
    return type;
}
    @Override
    public void update(int id, Type type) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TYPE_SQL);
            preparedStatement.setString(1, type.getName());
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TYPE_SQL);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

