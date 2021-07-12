package com.me.controller.save;

import com.me.model.entity.Car;
import com.me.model.service.CarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/car/save.do")
public class CarSave extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("car servlet at the beginning");
        try {
            Car car = new Car();
            car.setId(Integer.parseInt(req.getParameter("id")));
            car.setModel(req.getParameter("model"));

            CarServiceImpl.getInstance().save(car);

          System.out.println("car servlet at the end");
            //resp.sendRedirect("/person/findAll.do");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}


