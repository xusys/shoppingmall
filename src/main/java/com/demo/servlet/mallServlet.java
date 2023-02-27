package com.demo.servlet;

import com.demo.pojo.Goods;
import com.demo.service.GoodsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "mallServlet", value = "/mallServlet")
public class mallServlet extends HttpServlet {
    String name=null;
    String id=null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodsService goodsService=new GoodsService();
        List<Goods> goodsList=goodsService.showlist();
        HttpSession session=request.getSession() ;
        session.setAttribute("goodsList",goodsList);
        request.getRequestDispatcher("/mall.jsp").forward(request,response);
    }
}
