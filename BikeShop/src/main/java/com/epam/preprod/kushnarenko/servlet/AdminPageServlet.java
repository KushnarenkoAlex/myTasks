package main.java.com.epam.preprod.kushnarenko.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import main.java.com.epam.preprod.kushnarenko.constants.Path;

@WebServlet("/admin")
@MultipartConfig
public class AdminPageServlet extends HttpServlet {

    private static final long serialVersionUID = -6469185768904751455L;

    private final static Logger logger = Logger.getLogger(AdminPageServlet.class);

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = Path.ADMIN_VIEW;
        logger.info("Forwarding to Admin View");
        request.getRequestDispatcher(forward).forward(request, response);
    }
}