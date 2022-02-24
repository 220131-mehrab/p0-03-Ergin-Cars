package com.revature.cars;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CarController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String car = req.getParameter("car");
        String result = CarsAppContext.getCarService().searchByName(car);
        resp.getWriter().println(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int mpg = Integer.parseInt(req.getParameter("mpg"));
        String car = req.getParameter("car");
        CarsAppContext.getCarService().saveCar(new BrandName(car,mpg));
    }
}
