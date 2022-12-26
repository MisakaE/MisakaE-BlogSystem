package com.misakaE.blog.Usermanger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.misakaE.blog.dao.UserDao;
import com.misakaE.blog.po.User;

@WebServlet("/login")
public class Login extends HttpServlet {
    private ObjectMapper objectMapper=new ObjectMapper();
    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //获取请求参数
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        System.out.println("Username="+username+",Password="+password);
        if(username==null||"".equals(username)||password==null||"".equals(password)) {
            // 请求的内容缺失
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("当前的用户名或密码为空!");
            return;
        }
        //和数据库中的内容进行比较
        UserDao userDao=new UserDao();
        User user=userDao.selectByName(username);
        if(user==null||!user.getPassword().equals(password)) {
            //用户没有查到或者密码不匹配，登录失败！
            //System.out.println(user +"   "+userDao);
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("用户名或密码错误!");
            return;
        }
        //如果比较通过，就创建会话
        HttpSession session=req.getSession(true);
        //把刚才的用户信息，存储到会话中
        session.setAttribute("Login",user);
        req.getSession();
        //返回一个重定向报文，跳转到博客列表页
        resp.sendRedirect("blog_list.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("application/json;charset=utf8");
        HttpSession session=req.getSession(false);
        if(session==null) {
            //检测下会话是否存在，不存在说明未登录
            User user=new User();
            user.setuid(-1);
            resp.getWriter().write(objectMapper.writeValueAsString(user));
            return;
        }
        User user=(User) session.getAttribute("Login");
        if(user==null) {
            //虽然会话存在，但是会话里没有user对象，也视为未登录
            user=new User();
            user.setuid(-1);
            resp.getWriter().write(objectMapper.writeValueAsString(user));
            return;
        }
        //user.setuid(1);
        //不把密码返回给前端
        user.setUserpwd("");
        resp.getWriter().write(objectMapper.writeValueAsString(user));
    }
}
