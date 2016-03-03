package main.java.com.epam.preprod.kushnarenko.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import main.java.com.epam.preprod.kushnarenko.constants.Const;
import main.java.com.epam.preprod.kushnarenko.constants.Path;

@MultipartConfig
public class LogoutServlet extends HttpServlet {

    private static final long serialVersionUID = -6469185768904751455L;

    private final static Logger logger = Logger.getLogger(LogoutServlet.class);

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = Path.LOGIN_SERVLET;
        HttpSession hs = request.getSession();
        hs.setAttribute(Const.CURRENT_USER, null);
        logger.info("User was logged out");
        response.sendRedirect(forward);
    }
}