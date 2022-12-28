package com.misakaE.blog.dao;

import com.misakaE.blog.po.Blog;
import com.misakaE.blog.util.DBUtil;
import com.misakaE.blog.dao.ValueDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BlogDao {
    //插入一篇文章
    public void insert(Blog blog){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.getConnection();
            String sql="insert into blogdate values(?,?,?)";
            statement=connection.prepareStatement(sql);

            statement.setString(1, blog.getTitle());
            statement.setInt(2, blog.getBid());
            statement.setString(3, blog.getBody());
            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(null, statement, connection);
        }

    }
    //获取到博客列表中的所有博客的信息
    public List<Blog> selectAll() {
        List<Blog> blogs=new ArrayList<>();
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try {
            connection=DBUtil.getConnection();
            String sql="select * from blogdate order by bid desc";
            statement= connection.prepareStatement(sql);
            resultSet=statement.executeQuery();
            while (resultSet.next()) {
                Blog blog=new Blog();
                blog.setBid(resultSet.getInt("bid"));
                blog.setTitle(resultSet.getString("title"));//摘要
                String body=resultSet.getString("body");
                if(body.length()>50) {
                    body = body.substring(0,50)+"...";
                }

                blog.setBody(body);
                blogs.add(blog);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(resultSet,statement,connection);
        }
        return blogs;
    }
    //根据bid获取博客详情
    public Blog selectOne(int bid) {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try {
            connection=DBUtil.getConnection();
            String sql="select * from blogdate where bid=?";
            statement=connection.prepareStatement(sql);
            statement.setInt(1,bid);
            resultSet=statement.executeQuery();
            //此处我们是使用 主键 来作为查询条件的，查询结果要么是1，要么是0
            if(resultSet.next()) {
                Blog blog=new Blog();
                blog.setBid(resultSet.getInt("bid"));
                blog.setTitle(resultSet.getString("title"));
                blog.setBody(resultSet.getString("body"));
                return blog;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(resultSet,statement,connection);
        }
        return null;
    }
    //删除博客
    public void delete(int bid){
        Connection connection=null;
        PreparedStatement statement=null;
        try {
            connection=DBUtil.getConnection();
            String sql="delete from blogdate where bid=?";
            statement=connection.prepareStatement(sql);
            statement.setInt(1,bid);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null,statement,connection);
        }
    }

    }

