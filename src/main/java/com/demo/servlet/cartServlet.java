package com.demo.servlet;

import com.demo.pojo.Cart;
import com.demo.pojo.Goods;
import com.demo.pojo.Users;
import com.demo.service.CartService;
import com.demo.service.GoodsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "cartServlet", value = "/cartServlet")
public class cartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CartService cartService=new CartService();
        HttpSession session=request.getSession() ;
        Users users=(Users) session.getAttribute("user");
        System.out.println(users.getId());
        List<Cart> cartList=cartService.showlist(users.getId());

        session.setAttribute("cartList",cartList);
        double totalprice=0;
        for(int i=0;i<cartList.size();i++)
        {
            totalprice=totalprice+cartList.get(i).getPrice()*cartList.get(i).getQuantity();
            System.out.println(cartList.get(i));
        }
        session.setAttribute("totalprice",totalprice);
        request.getRequestDispatcher("/cart.jsp").forward(request,response);
    }
}
