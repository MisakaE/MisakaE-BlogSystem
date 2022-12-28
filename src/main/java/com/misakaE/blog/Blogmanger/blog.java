package com.misakaE.blog.Blogmanger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.misakaE.blog.dao.BlogDao;
import com.misakaE.blog.po.Blog;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.time.*;
import java.util.Timer;

import static java.time.LocalTime.now;

@WebServlet("/blog")
public class blog extends HttpServlet {
    private ObjectMapper objectMapper=new ObjectMapper();
    //建立列表json
    //博客详情
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断是否有bid参数
        BlogDao blogDao=new BlogDao();
        List<Blog> blogs=blogDao.selectAll();
        String rbid=req.getParameter("bid");
        if(rbid!=null) {
            //存在参数，获取博客详情
            int bid=Integer.parseInt(rbid);
            Blog blog=blogDao.selectOne(bid);
            String respJson=objectMapper.writeValueAsString(blog);
            resp.setContentType("application/json;charset=utf8");
            resp.getWriter().write(respJson);
        }
        else {//从数据库中查询到博客列表，转成JSON格式，然后直接返回即可//把blogs对象转成JSON格式
            String respJson = objectMapper.writeValueAsString(blogs);
            resp.setContentType("application/json;charset=utf8");
            resp.getWriter().write(respJson);
        }
    }
    //新建博客
    @Override   
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{

        req.setCharacterEncoding("utf8");//编码
        String title=req.getParameter("title");
        String body=req.getParameter("body");
        if(title==null||body==null||"".equals(body)){
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("提交博客失败！缺少必要的参数！");
            return;
        }
        Blog blog=new Blog();
        blog.setTitle(title);
        blog.setBody(body);
        int Hash=body.hashCode();
        blog.setBid(Hash);
        BlogDao blogDao=new BlogDao();
        blogDao.insert(blog);
        //重定向到博客列表页
        resp.sendRedirect("blog_list.jsp");
    }


}
