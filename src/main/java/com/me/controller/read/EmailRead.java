package com.me.controller.read;

import com.me.model.entity.Email;
import com.me.model.entity.Employee;
import com.me.model.service.EmailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/email/read.do/*")
public class EmailRead extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getServletPath());
        System.out.println(req.getPathInfo());
        if (req.getPathInfo() == null) {
            List<Email> emailList = new ArrayList<>();
            try {
                emailList = EmailService.getInstance().findAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
            req.setAttribute("emailList", emailList);
            req.getRequestDispatcher("/email_list.jsp").forward(req, resp);

        } else {

            Employee employee = (Employee) req.getAttribute("employee");
            System.out.println(employee.toString());

            List<Email> list = EmailService.getInstance().joinEmail_EmailReceiver(employee.getEmployeeId());

            req.getSession().setAttribute("emailList", list);
            resp.sendRedirect("/email_list.jsp");
        }


    }
}
