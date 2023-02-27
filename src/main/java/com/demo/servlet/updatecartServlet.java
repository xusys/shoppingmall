package com.demo.servlet;

import com.demo.service.CartService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "updatecartServlet", value = "/updatecartServlet")
public class updatecartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Id=request.getParameter("id");
        String Quantity=request.getParameter("quantity");
        int quantity=Integer.parseInt(Quantity);
        int id=Integer.parseInt(Id);
        CartService cartService=new CartService();
        cartService.update(id,quantity);
        request.getRequestDispatcher("/cartServlet").forward(request,response);
    }
}
