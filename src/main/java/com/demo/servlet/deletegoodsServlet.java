package com.demo.servlet;

import com.demo.pojo.Goods;
import com.demo.service.GoodsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "deletegoodsServlet", value = "/deletegoodsServlet")
public class deletegoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        Goods goods=new Goods();
        goods.setId(Integer.parseInt(id));
        GoodsService goodsService=new GoodsService();
        int flag=goodsService.delete(goods);
        if(flag==1)
        {
        request.getRequestDispatcher("/mallServlet").forward(request,response);}
        else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer=response.getWriter();
            writer.write("login failed");
            writer.write(" <p>back to  <a href=\"login.html\">Login</a> now!</p>");
        }
    }
}
