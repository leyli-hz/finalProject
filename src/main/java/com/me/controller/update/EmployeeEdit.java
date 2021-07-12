package com.me.controller.update;

import com.me.model.entity.Employee;
import com.me.model.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employee/edit.do")
public class EmployeeEdit extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        System.out.println(action);
        switch (action) {
            case "/update.do":
                System.out.println("update koon");
                break;
            default:
                String employeeIdParameter = req.getParameter("employeeId");
                if (!employeeIdParameter.isEmpty()) {
                    int employeeId = Integer.parseInt(employeeIdParameter);
                    System.out.println(employeeId);
                    Employee employee = EmployeeService.getInstance().findOne(employeeId);
                    System.out.println(employee.toString());
                    req.setAttribute("employee", employee);
                    System.out.println("attribute employee set shod!");

                    req.getRequestDispatcher("../update_employee_form.jsp").forward(req, resp);
                }
                break;
        }

    }
}
