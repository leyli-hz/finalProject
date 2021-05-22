package com.me.controller;

import com.me.model.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/category/save.do")
public class CategorySave extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("at beggining of service");
        CategoryService.getInstance().save();
        System.out.println("at middle of service");
        req.getRequestDispatcher("/car/save.do").forward(req,resp);
    }
}
