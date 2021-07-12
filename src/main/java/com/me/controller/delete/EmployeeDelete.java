package com.me.controller.delete;

import com.me.model.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employee/delete.do")
public class EmployeeDelete extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("delete");
        int employeeId = Integer.parseInt(req.getParameter("employeeId"));
        System.out.println(req.getParameter("employeeId"));
        System.out.println(employeeId);
        try {
            EmployeeService.getInstance().remove(employeeId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("remove shod!!");
        resp.sendRedirect("../employee/show.do");
    }
}
