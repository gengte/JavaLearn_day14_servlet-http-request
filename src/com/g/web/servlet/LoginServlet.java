package com.g.web.servlet;

import com.g.dao.UserDao;
import com.g.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

//import org.springframework.beans.BeanUtils;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        //获取请求参数封装对象
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        System.out.println(username + "  " + password);
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);

        //使用BeanUtils工具类，简化数据封装
        Map<String, String[]> parameterMap = req.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        UserDao dao = new UserDao();
        user = dao.login(user);
        if (user == null) {
            req.getRequestDispatcher("/failServlet").forward(req, resp);
        } else {
            req.setAttribute("user", user);
            req.getRequestDispatcher("/successServlet").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
