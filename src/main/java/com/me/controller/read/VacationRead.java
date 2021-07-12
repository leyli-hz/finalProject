package com.me.controller.read;

import com.me.model.entity.Vacation;
import com.me.model.service.VacationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/vacation/show.do/*")
public class VacationRead extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Vacation> vacationList = new ArrayList<>();
        System.out.println(req.getPathInfo());
        if (req.getPathInfo() == null) {
            System.out.println("omad to if");
            try {
                vacationList = VacationService.getInstance().findAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
            req.getSession().setAttribute("vacationList", vacationList);
            req.getRequestDispatcher("/vacation_list.jsp").forward(req, resp);
        } else {
            System.out.println("omad to else");
            List<Vacation> vacations = VacationService.getInstance().vacationJoinEmployee(Integer.parseInt(req.getParameter("managerId")));
            System.out.println("list hasel join ro greft");
            req.getSession().setAttribute("vacations", vacations);
            resp.sendRedirect("/vacation_handler.jsp");
        }
    }
}
