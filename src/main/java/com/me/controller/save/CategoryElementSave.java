package com.me.controller.save;

import com.me.model.entity.Category;
import com.me.model.entity.CategoryElement;
import com.me.model.service.CategoryElementService;
import com.me.model.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/categoryElement/save.do")
public class CategoryElementSave extends HttpServlet {
  static   CategoryElement categoryElement = new CategoryElement();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        categoryElement.setFarsiName(req.getParameter("farsiName"));
        try {
            CategoryElementService.getInstance().save(categoryElement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Category> roleType = CategoryService.getInstance().findByName("roleType");
        List<CategoryElement> roleTypeCtgElm = CategoryElementService.getInstance().findByCategory(roleType.get(0));

        req.getSession().setAttribute("roleTypeCtgElm", roleTypeCtgElm);

        List<Category> vacationTypes = CategoryService.getInstance().findByName("vacationType");
        List<CategoryElement> vacationTypeCtgElm = CategoryElementService.getInstance().findByCategory(vacationTypes.get(0));

        req.getSession().setAttribute("vacationTypeCtgElm",vacationTypeCtgElm);
        System.out.println("vacationTypeCtgElm set shod");

        List<Category> vacationStatus = CategoryService.getInstance().findByName("vacationStatus");
        List<CategoryElement> vacationStatusCtgElms = CategoryElementService.getInstance().findByCategory(vacationStatus.get(0));

        req.getSession().setAttribute("vacationStatusCtgElms",vacationStatusCtgElms);

    }

    public CategoryElement setCategoryOfCatgElm(Category category){
        categoryElement.setCategory(category);
        System.out.println("category dar category element save shod!");
        return categoryElement;
    }
}
