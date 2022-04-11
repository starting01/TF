package servletProject.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author yqf
 * @create 2022-03-30-22:52
 */
public class DbUtils {
    //创建连接池
    private static DruidDataSource ds;
    //控制事务
    private static final ThreadLocal<Connection> THREAD_LOCAL = new ThreadLocal<>();

    static {
        Properties properties = new Properties();
        InputStream inputStream = DbUtils.class.getClassLoader().getResourceAsStream("db.properties");
        System.out.println("inputStream:"+inputStream);
        try {
            properties.load(inputStream);
            System.out.println("properties:"+properties);
            ds = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection = THREAD_LOCAL.get();
        if(connection == null){
            try {
                System.out.println("ds："+ds);
                System.out.println("ds.connection："+ds.getConnection());
                connection = ds.getConnection();
                System.out.println("DruidDataSource："+connection);
                THREAD_LOCAL.set(connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }

    public static void  begin(){
        Connection connection = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void commit(){
        Connection connection = null;
        connection = getConnection();
        try {
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            closeAll(connection,null,null);
        }
    }

    public static void rollBack(){
        Connection connection = null;
        connection = getConnection();
        try {
            connection.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            closeAll(connection,null,null);
        }
    }

    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet){
        try{
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
                THREAD_LOCAL.remove();
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

    }
}
