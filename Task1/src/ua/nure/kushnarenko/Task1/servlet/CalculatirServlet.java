package ua.nure.kushnarenko.Task1.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.nure.kushnarenko.Task1.command.CalculatorCommand;
import ua.nure.kushnarenko.Task1.command.CommandContainer;

@WebServlet({ "/calculate" })
public class CalculatirServlet extends HttpServlet {

    private static final long serialVersionUID = 7382030908618723783L;

    private static final String resultPage = "WEB-INF/jsp/result.jsp";
    private static final String calcPageServ = "/Task1/calculate";
    private static final String calcPage = "/WEB-INF/jsp/calc.jsp";
    private static final String xValue = "x";
    private static final String yValue = "y";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String forward = calcPage;
        HttpSession hs = req.getSession(true);
        if (hs.getAttribute("wasPost") != null) {
            boolean wasPost = (boolean) hs.getAttribute("wasPost");
            if (!wasPost) {
                hs.setAttribute("errors", null);
            }
            hs.setAttribute("wasPost", false);
        }
        req.getRequestDispatcher(forward).forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = calcPageServ;
        HashMap<String, String> errors = new HashMap<>();

        Double x = null;
        try {
            x = Double.parseDouble(request.getParameter(xValue));
        } catch (Exception e) {
            errors.put("xIncorrect", "Incorrect value");
        }

        Double y = null;
        try {
            y = Double.parseDouble(request.getParameter(yValue));
            if (y == 0.0) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            errors.put("yIncorrect", "Incorrect value");
        }

        Double result = null;
        try {
            CalculatorCommand cc = CommandContainer.get(request.getParameter("action"));
            result = cc.execute(x, y);
        } catch (Exception e) {
            e.printStackTrace();
            errors.put("actionIncorrect", "Incorrect Action");
        }

        HttpSession hs = request.getSession(true);
        hs.setAttribute("wasPost", true);
        if (errors.size() > 0) {
            hs.setAttribute("errors", errors);
            response.sendRedirect(forward);
        } else {
            request.setAttribute("result", result);
            request.getRequestDispatcher(resultPage).forward(request, response);
        }

    }

}
