package com.me.controller.read;

import com.me.model.entity.Employee;
import com.me.model.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/employee/show.do/*")
public class EmployeeRead extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getPathInfo() == null) {
            List<Employee> employeeList = new ArrayList<>();
            try {
                employeeList = EmployeeService.getInstance().findAll();

            } catch (Exception e) {
                e.printStackTrace();
            }
            req.setAttribute("employeeList", employeeList);
            req.getSession().setAttribute("employeeList", employeeList);
            req.getRequestDispatcher("/employee_manager_list.jsp").forward(req, resp);
        }else{
            System.out.println("hhhooooo");
            String employeeId = req.getParameter("employeeId");
            int employeeID=Integer.parseInt(employeeId);
            Employee employee = EmployeeService.getInstance().findOne(employeeID);

            req.setAttribute("employee", employee);
            System.out.println("object Employee Set shod !");
            req.getRequestDispatcher("/email/read.do/findOne").forward(req,resp);

        }
    }

}
