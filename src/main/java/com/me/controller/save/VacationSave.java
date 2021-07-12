package com.me.controller.save;

import com.me.model.entity.CategoryElement;
import com.me.model.entity.Employee;
import com.me.model.entity.Vacation;
import com.me.model.service.CategoryElementService;
import com.me.model.service.EmployeeService;
import com.me.model.service.VacationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@WebServlet("/vacation/save.do")
public class VacationSave extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Vacation vacation = new Vacation();
        vacation.setStartDate(Date.valueOf(req.getParameter("startDate")));
        vacation.setEndDate(Date.valueOf(req.getParameter("endDate")));
        
        vacation.setStartTime(Time.valueOf(req.getParameter("startTime") + ":00"));
        vacation.setEndTime(Time.valueOf(req.getParameter("endTime") + ":00"));

        vacation.setExpression(req.getParameter("expression"));

        System.out.println(req.getParameter("employeeNationalCode"));
        Employee employee = EmployeeService.getInstance().findByNationalCode(req.getParameter("employeeNationalCode"));
        vacation.setEmployee(employee);

        String vacationTypeID = req.getParameter("vacationType");
        Set<CategoryElement> categoryElementSet = new LinkedHashSet<CategoryElement>();
        CategoryElement vacationTypeCtgElm = CategoryElementService.getInstance().findOneById(Integer.parseInt(vacationTypeID));
        categoryElementSet.add(vacationTypeCtgElm);
        String vacationStatusID = req.getParameter("vacationStatus");
        CategoryElement vacationStatusCtgElm = CategoryElementService.getInstance().findOneById(Integer.parseInt(vacationStatusID));
        categoryElementSet.add(vacationStatusCtgElm);
        vacation.setCategoryElements(categoryElementSet);

        try {
            VacationService.getInstance().save(vacation);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //req.setAttribute("vacation",vacation );
        resp.sendRedirect("/vacation/show.do");
    }


}
