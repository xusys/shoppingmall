package com.demo.servlet;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class loginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        //判断访问资源路径是否和登录注册相关
        String[] urls = {"/login.html","/loginservlet","/register.html","/registerServlet"};
        // 获取当前访问的资源路径
        String url = req.getRequestURL().toString();

        //循环判断
        for (String u : urls) {
            if(url.contains(u)){
                //找到了
                //放行
                chain.doFilter(request, response);
                //break;
                return;
            }
        }


        //1. 判断session中是否有user
        HttpSession session = req.getSession();
        Object users = session.getAttribute("user");

        //2. 判断user是否为null
        if(users != null){
            // 登录过了
            //放行
            chain.doFilter(request, response);
        }else {
            // 没有登陆，存储提示信息，跳转到登录页面

            req.setAttribute("login_msg","您尚未登陆！");
            req.getRequestDispatcher("/login.html").forward(req,response);
        }

    }
}
