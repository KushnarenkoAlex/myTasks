package main.java.com.epam.preprod.kushnarenko.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import main.java.com.epam.preprod.kushnarenko.constants.Const;
import main.java.com.epam.preprod.kushnarenko.constants.Path;
import main.java.com.epam.preprod.kushnarenko.entity.Order;
import main.java.com.epam.preprod.kushnarenko.service.OrderService;

/**
 * Servlet implementation class ConfirmationServlet
 */
public class ConfirmationServlet extends HttpServlet {

    private static final long serialVersionUID = -4831100426703572333L;

    private final static Logger logger = Logger.getLogger(ConfirmationServlet.class);

    OrderService orderService;

    @Override
    public void init(ServletConfig sc) throws ServletException {
        orderService = (OrderService) sc.getServletContext().getAttribute(Const.ORDER_SERVICE);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = Path.SUCCESS;
        HttpSession hs = request.getSession(true);
        Order order = (Order) hs.getAttribute("order");
        if (order != null) {
            logger.debug(String.format("Order = %s", order));
            orderService.create(order);
            logger.info("Order was confirmed and added to database");
        }
        request.getRequestDispatcher(forward).forward(request, response);
    }

}
