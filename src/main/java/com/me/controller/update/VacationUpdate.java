package com.me.controller.update;

import com.me.model.entity.CategoryElement;
import com.me.model.entity.Vacation;
import com.me.model.service.CategoryElementService;
import com.me.model.service.VacationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

@WebServlet("/vacation/update.do/*")
public class VacationUpdate extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<CategoryElement> newCategoryElements = new LinkedHashSet<>();

        if (req.getPathInfo().equals("/reject")) {
            System.out.println("omad to update  baraye reject!!");
            Vacation oldVacation = VacationService.getInstance().findOneByID(Integer.parseInt(req.getParameter("vacationId")));
            Vacation newVacation = new Vacation();
            newVacation.setVacationId(oldVacation.getVacationId());
            newVacation.setStartDate(oldVacation.getStartDate());
            newVacation.setEndDate(oldVacation.getEndDate());
            newVacation.setStartTime(oldVacation.getStartTime());
            newVacation.setEndTime(oldVacation.getEndTime());
            newVacation.setExpression(oldVacation.getExpression());
            newVacation.setEmployee(oldVacation.getEmployee());
            CategoryElement vacationStatCtgElm =
                    CategoryElementService.getInstance().findOneById(Integer.parseInt(req.getParameter("vacationStatId")));
            for (CategoryElement categoryElement : oldVacation.getCategoryElements()) {
                if (categoryElement.getCategory().getCategoryName().equals("vacationStatus")){
                    newCategoryElements.add(vacationStatCtgElm);
                }else {
                    newCategoryElements.add(categoryElement);
                }
            }
            newVacation.setCategoryElements(newCategoryElements);
            try {
                VacationService.getInstance().update(newVacation);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(req.getPathInfo().equals("/accept")){
            System.out.println("omad to update  baraye accept!!");
            Vacation oldVacation = VacationService.getInstance().findOneByID(Integer.parseInt(req.getParameter("vacationId")));
            Vacation newVacation = new Vacation();
            newVacation.setVacationId(oldVacation.getVacationId());
            newVacation.setStartDate(oldVacation.getStartDate());
            newVacation.setEndDate(oldVacation.getEndDate());
            newVacation.setStartTime(oldVacation.getStartTime());
            newVacation.setEndTime(oldVacation.getEndTime());
            newVacation.setExpression(oldVacation.getExpression());
            newVacation.setEmployee(oldVacation.getEmployee());
            CategoryElement vacationStatCtgElm =
                    CategoryElementService.getInstance().findOneById(Integer.parseInt(req.getParameter("vacationStatId")));
            for (CategoryElement categoryElement : oldVacation.getCategoryElements()) {
                if (categoryElement.getCategory().getCategoryName().equals("vacationStatus")){
                    newCategoryElements.add(vacationStatCtgElm);
                }else {
                    newCategoryElements.add(categoryElement);
                }
            }
            newVacation.setCategoryElements(newCategoryElements);
            try {
                VacationService.getInstance().update(newVacation);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
