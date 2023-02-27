package com.demo.servlet;

import com.demo.pojo.Goods;
import com.demo.service.GoodsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "addgoodsServlet", value = "/addgoodsServlet")
public class addgoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String Price = request.getParameter("price");
        double price=Double.valueOf(Price);
        String description = request.getParameter("description");
        GoodsService goodsService=new GoodsService();
        int flag=goodsService.add(name,price,description);
        if(flag==1)
        {
            request.getRequestDispatcher("/mall.jsp").forward(request,response);}
        else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer=response.getWriter();
            writer.write("add failed");
            writer.write(" <p>back to  <a href=\"mall.jsp\">mall</a> now!</p>");
        }
    }
}
