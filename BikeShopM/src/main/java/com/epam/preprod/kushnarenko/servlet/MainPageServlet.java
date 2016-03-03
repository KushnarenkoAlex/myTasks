package main.java.com.epam.preprod.kushnarenko.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.epam.preprod.kushnarenko.constants.Path;

@WebServlet("/main")
public class MainPageServlet extends HttpServlet {

    private static final long serialVersionUID = 103189491341429198L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher(Path.MAIN).forward(request, response);
    }

}
