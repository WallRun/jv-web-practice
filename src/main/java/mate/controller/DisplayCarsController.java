package mate.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.lib.Injector;
import mate.model.Car;
import mate.service.CarService;

public class DisplayCarsController extends HttpServlet {
    private static final Injector INJECTOR = Injector.getInstance("mate");

    private final CarService carService;

    public DisplayCarsController() {
        carService = (CarService) INJECTOR.getInstance(CarService.class);
    }
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Car> cars = carService.getAll();
        req.setAttribute("cars", cars);
        req.getRequestDispatcher("/WEB-INF/view/display_cars.jsp").forward(req, resp);
    }
}
