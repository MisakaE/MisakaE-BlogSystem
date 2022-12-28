package com.misakaE.blog.Blogmanger;

import com.misakaE.blog.dao.BlogDao;
import com.misakaE.blog.po.Blog;
import com.misakaE.blog.po.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/blogdelete")
public class blogDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //检查当前用户是否登录
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("当前尚未登录，不能删除！");
            return;
        }
        User user = (User) session.getAttribute("Login");
        if (user == null) {
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("当2前尚未登录，不能删除！");
            return;
        }

        //获取到参数中的bid
        String bid = req.getParameter("bid");
        if (bid == null || "".equals(bid)) {
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("当前bid参数不对！");
            return;
        }

        //3.获取要删除的博客信息
        BlogDao blogDao = new BlogDao();
        Blog blog = blogDao.selectOne(Integer.parseInt(bid));
        if (blog == null) {
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("当前要删除的博客不存在！");
            return;
        }

        //再次校验，当前的用户是否是博客的作者
        if (user.getUid() != blog.getUuid() && user.getUid() != 1) {
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("没有此博客的删除权限");
            return;
        }

        //确认无误，开始删除
        blogDao.delete(Integer.parseInt(bid));

        //重定向到博客列表
        resp.sendRedirect("blog_list.jsp");
    }
}
