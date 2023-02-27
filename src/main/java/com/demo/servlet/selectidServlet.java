package com.demo.servlet;

import com.demo.pojo.Goods;
import com.demo.service.GoodsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "selectidServlet", value = "/selectidServlet")
public class selectidServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String id= request.getParameter("id");
       String operation=request.getParameter("operation");
        GoodsService goodsService=new GoodsService();
        Goods goods=goodsService.selectbyid(Integer.parseInt(id));
        request.setAttribute("goods",goods);
        System.out.println(goods);
        if(operation.equals("1"))
        request.getRequestDispatcher("/updategoods.jsp").forward(request,response);
        else if(operation.equals("2"))
            request.getRequestDispatcher("/deletegoods.jsp").forward(request,response);
        else if (operation.equals("3"))
            request.getRequestDispatcher("/addcart.jsp").forward(request,response);
    }
}
