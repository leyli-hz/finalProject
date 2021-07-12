package com.me.controller.save;

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

@WebServlet("/employee/save.do")
public class EmployeeSave extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("controller employee at beggining");
        System.out.println(req.getQueryString());
        System.out.println(req.getServletPath());
        Employee employee = new Employee();
        employee.setFirstName(req.getParameter("employeeFname"));
        employee.setLastName(req.getParameter("employeeLname"));
        employee.setNationalCode(req.getParameter("nationalCode"));

        CategoryElement categoryElement = getCategoryElementObj(req);
        System.out.println(categoryElement.toString());
        employee.setCategoryElement(categoryElement);

        Employee manager = getManagerObj(req);

        if (manager != null) {
            System.out.println(manager.toString());
            employee.setManager(manager);
        }
        try {
            EmployeeService.getInstance().save(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("controller employee at the end");
        resp.sendRedirect("/employee/show.do");
    }

    public CategoryElement getCategoryElementObj(HttpServletRequest req) {
        CategoryElement roleObj = CategoryElementService.getInstance().findByFarsiName(req.getParameter("roleId"));
        return roleObj;
    }

    public Employee getManagerObj(HttpServletRequest req) {
        if(req.getParameter("managerId").isEmpty()){
            return null;
        }
        int managerId = Integer.parseInt(req.getParameter("managerId"));
        System.out.println("int managerId : " + managerId);
        Employee managerObj = EmployeeService.getInstance().findOne(managerId);
        return managerObj;
    }
}
