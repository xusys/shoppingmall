package com.demo.servlet;

import com.demo.pojo.Cart;
import com.demo.pojo.Goods;
import com.demo.service.CartService;
import com.demo.service.GoodsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "selectcartServlet", value = "/selectcartServlet")
public class selectcartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id= request.getParameter("id");
        String operation=request.getParameter("operation");
        CartService cartService=new CartService();
        Cart cart=cartService.selectById(Integer.parseInt(id));
        request.setAttribute("cart",cart);
        System.out.println(cart);
        if(operation.equals("1"))
            request.getRequestDispatcher("/updatecart.jsp").forward(request,response);
        else if(operation.equals("2"))
            request.getRequestDispatcher("/deletecart.jsp").forward(request,response);

    }
}
