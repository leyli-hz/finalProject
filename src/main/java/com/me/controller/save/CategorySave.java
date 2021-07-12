package com.me.controller.save;

import com.me.model.entity.Category;
import com.me.model.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category/save.do")
public class CategorySave extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer categoryNumber = checkCategoryName(req);
        System.out.println(categoryNumber);
        if (categoryNumber == 0) {
            Category category = new Category();
            category.setCategoryName(req.getParameter("roleType"));
            CategoryService.getInstance().save(category);
            CategoryElementSave categoryElementSave = new CategoryElementSave();
            categoryElementSave.setCategoryOfCatgElm(category);
        }
    }

    public Integer checkCategoryName(HttpServletRequest request) {
        String categoryName = request.getParameter("roleType");
        List<Category> categoryList = CategoryService.getInstance().findByName(categoryName);
        int listSize = categoryList.size();
        return listSize;
    }
}
