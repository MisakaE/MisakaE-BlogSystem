package com.misakaE.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.misakaE.blog.util.DBUtil;
import com.misakaE.blog.po.User;
//这个表用来针对用户表的基本操作
public class UserDao {
    //根据用户名来查找用户信息(在登录逻辑中使用)
    public User selectByName(String username) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            String sql = "select * from userdate where username=?";
            //System.out.println(sql);
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            resultSet = statement.executeQuery();
            //使用unique约束
            if(resultSet.next()) {
                User user=new User();
                user.setuid(resultSet.getInt("uid"));
                user.setUsername(resultSet.getString("username"));
                user.setUserpwd(resultSet.getString("password"));
                user.setNick(resultSet.getString("nick"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(resultSet, statement, connection);
        }
        return null;
    }
}

