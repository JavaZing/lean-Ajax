package com.kaishengit.web;

import sun.nio.cs.ext.ISO_8859_8;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ZhangSer on 2016/3/29.
 */
@WebServlet("/home.do")
public class HomeServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String msg = req.getParameter("msg");

        msg = new String(msg.getBytes("ISO8859-1"),"UTF-8");

        System.out.println("hello Ajax"+msg);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        PrintWriter out = resp.getWriter();
        if("tom".equals(username)){
            out.print("0");
           // System.out.println("账号占用" );
        }else {
            out.print("1");
           //System.out.println("没有占用");
        }
        out.flush();
        out.close();
    }
}
