package com.demo.servlet;

import com.demo.mapper.UsersMapper;
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

@WebServlet(name = "registerServlet", value = "/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
//        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
//        int id = 0;
//        try {
//            id = usersMapper.add(username, password, email);
//        }catch (Exception e2) {
//            e2.printStackTrace();
//        }
//
//        sqlSession.close();
        UserService userService=new UserService();
        Users users=userService.Register(username,password,email);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer=response.getWriter();
        System.out.println(users);
        if(users!=null)
        {
            writer.write("register success");
            writer.write(" <p>back to  <a href=\"login.html\">Login</a> now!</p>");
        }
        else
        {
            writer.write("register failed");
            writer.write(" <p>back to  <a href=\"register.html\">Register</a> now!</p>");
            writer.write(" <p>back to  <a href=\"login.html\">Login</a> now!</p>");
        }

    }
}
