package com.g.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求行数据
        //获取请求方式
        System.out.println(req.getMethod());
        //获取虚拟目录
        System.out.println(req.getContextPath());
        //获取Servlet路径
        System.out.println(req.getServletPath());
        //获取请求参数
        System.out.println(req.getQueryString());
        //获取请求URI
        System.out.println(req.getRequestURI());
        //获取请求URL
        System.out.println(req.getRequestURL());
        //获取协议及版本
        System.out.println(req.getProtocol());
        //获取客户机IP
        System.out.println(req.getRemoteAddr());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
