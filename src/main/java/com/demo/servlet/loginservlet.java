package com.demo.servlet;

import com.demo.mapper.GoodsMapper;
import com.demo.mapper.UsersMapper;
import com.demo.pojo.Goods;
import com.demo.pojo.Users;
import com.demo.service.UserService;
import com.demo.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "loginservlet", value = "/loginservlet")
public class loginservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        UsersMapper usersMapper =sqlSession.getMapper(UsersMapper.class);
//        List<Users> users= usersMapper.selectByCondition(username,password);
        UserService userService=new UserService();
        Users users=userService.Login(username,password);
        System.out.println(users);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer=response.getWriter();
        if(users!=null)
        {
            writer.write("login success");
            HttpSession session=request.getSession() ;
            session.setAttribute("user",users);
            request.getRequestDispatcher("/mallServlet").forward(request,response);
        }
        else
        {
            writer.write("login failed");
            writer.write(" <p>back to  <a href=\"login.html\">Login</a> now!</p>");
        }
    }
}
