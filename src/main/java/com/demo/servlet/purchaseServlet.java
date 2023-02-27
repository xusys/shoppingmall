package com.demo.servlet;

import com.demo.pojo.Cart;
import com.demo.service.CartService;
import com.demo.service.GoodsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "purchaseServlet", value = "/purchaseServlet")
public class purchaseServlet extends HttpServlet {
    String operation=null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          operation=request.getParameter("operation");
        System.out.println("结算中");
          HttpSession session=request.getSession();
//          if(operation==null)
//          {
//              request.getRequestDispatcher("/mall.jsp").forward(request,response);
//          }
         CartService cartService=new CartService();
          List<Cart> cartList=(List<Cart>) session.getAttribute("cartList");

          for (int i=0;i<cartList.size();i++)
          {
              cartService.purchase(cartList.get(i));
          }
//       request.getRequestDispatcher("test.html").forward(request,response);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer=response.getWriter();
        writer.write("<h1>购买成功<h1><br>");
        writer.write("  <a href=\"mall.jsp\">返回商城首页</a> </p>");

    }
}
