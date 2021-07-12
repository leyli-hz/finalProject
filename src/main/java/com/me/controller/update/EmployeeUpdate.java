package com.me.controller.update;

import com.me.model.entity.CategoryElement;
import com.me.model.entity.Employee;
import com.me.model.service.CategoryElementService;
import com.me.model.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employee/update.do")
public class EmployeeUpdate extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hooooo");
        Employee employee = new Employee();
        System.out.println(req.getParameter("employeeId"));
        employee.setEmployeeId(Integer.parseInt(req.getParameter("employeeId")));
        employee.setFirstName(req.getParameter("employeeFname"));
        employee.setLastName(req.getParameter("employeeLname"));
        employee.setNationalCode(req.getParameter("nationalCode"));
        System.out.println("3 taye aval set shod baraye Update !");

        CategoryElement elementObj = getCategoryElementObj(req);
        employee.setCategoryElement(elementObj);
        System.out.println("category element set shod baraye update!!");

        Employee managerObj = getManagerObj(req);
        employee.setManager(managerObj);
        System.out.println("manager set shod baraye update !");
        System.out.println(employee.toString());
        try {
            EmployeeService.getInstance().update(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("update anjam shod");
        resp.sendRedirect("../employee/show.do");
    }


    public CategoryElement getCategoryElementObj(HttpServletRequest req) {
        CategoryElement roleObj = CategoryElementService.getInstance().findByFarsiName(req.getParameter("roleId"));
        return roleObj;
    }

    public Employee getManagerObj(HttpServletRequest req) {
        if (req.getParameter("managerId").isEmpty()) {
            return null;
        }
        int managerId = Integer.parseInt(req.getParameter("managerId"));
        System.out.println("int managerId : " + managerId);
        Employee managerObj = EmployeeService.getInstance().findOne(managerId);
        return managerObj;
    }
}