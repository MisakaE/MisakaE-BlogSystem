package com.misakaE.blog.util;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
    private static Properties properties = new Properties();
    static {
        try {
            //加载配置文件
            InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
            properties.load(in);
            Class.forName(properties.getProperty("jdbcName"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    //获取数据库链接
    public static Connection getConnection(){
        Connection connection = null;
        try{
            String dbUrl = properties.getProperty("dbUrl");
            String dbName = properties.getProperty("dbName");
            String dbPwd = properties.getProperty("dbPwd");
            connection = DriverManager.getConnection(dbUrl,dbName,dbPwd);

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return connection;
    }


    //关闭资源
    public static void close(ResultSet resultSet,
                             PreparedStatement preparedStatement,
                             Connection connection){
        try{
            if(resultSet != null){
                resultSet.close();
            }
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
