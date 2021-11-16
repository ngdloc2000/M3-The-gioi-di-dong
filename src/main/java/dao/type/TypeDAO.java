package dao.type;

import config.Config;
import model.Type;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypeDAO implements ITypeDAO {
    private String jdbcURL = "Config.MYSQL";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";

    private static final String INSERT_TYPE_SQL = "INSERT INTO type (name) VALUES (?,);";
    private static final String SELECT_TYPE_BY_ID = "select id,name from users where id =?";
    private static final String DELETE_TYPE_SQL = "delete from type where id = ?;";
    private static final String UPDATE_TYPE_SQL = "update type set name = ? where id = ?;";
    private static final String FIND_ALL_TYPE = "select * from type";
public TypeDAO(){

}

    @Override
    public List<Type> findAll() {
        System.out.println(INSERT_TYPE_SQL);
        Connection connection=null;
        List<Type> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbcDriver");
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

    }

    @Override
    public Type findById(int id) {
        System.out.println(SELECT_TYPE_BY_ID);
        Connection connection=null;
        List<Type> list = new ArrayList<>();
 try{
         Class.forName("com.mysql.jdbcDriver");
         connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
         PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_TYPE);
         ResultSet resultSet = preparedStatement.executeQuery();
         System.out.println(preparedStatement);


     } catch (ClassNotFoundException e) {
         e.printStackTrace();
     }catch (SQLException e) {
         e.printStackTrace();

    }
}
    @Override
    public void update(int id, Type type) {

    }

    @Override
    public void remove(int id) {

    }
}

