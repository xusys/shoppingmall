package com.demo.servlet;

import com.demo.pojo.Cart;
import com.demo.service.CartService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "historyServlet", value = "/historyServlet")
public class historyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operation = request.getParameter("operation");

        CartService cartService = new CartService();
        if (operation.equals("1")) {
            List<Cart> carthistory = cartService.showhistory();
            HttpSession session = request.getSession();
            session.setAttribute("carthistory", carthistory);
            System.out.println(carthistory);
            request.getRequestDispatcher("/history.jsp").forward(request, response);
        }
        if (operation.equals("2"))
        {
            String usersid = request.getParameter("usersid");
            List<Cart> carthistory = cartService.showuserhistory(Integer.parseInt(usersid));
            HttpSession session = request.getSession();
            session.setAttribute("carthistory", carthistory);
            System.out.println(carthistory);
            request.getRequestDispatcher("/historyusers.jsp").forward(request, response);
        }
        if (operation.equals("3"))
        {

            List<Cart>  carthistory = cartService.showgoodhistory();
            HttpSession session = request.getSession();
            session.setAttribute("carthistory", carthistory);

            request.getRequestDispatcher("/historygoods.jsp").forward(request, response);
        }
    }
}
