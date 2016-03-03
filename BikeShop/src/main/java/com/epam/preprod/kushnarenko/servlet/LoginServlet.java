package main.java.com.epam.preprod.kushnarenko.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import main.java.com.epam.preprod.kushnarenko.constants.Const;
import main.java.com.epam.preprod.kushnarenko.constants.Path;
import main.java.com.epam.preprod.kushnarenko.entity.User;
import main.java.com.epam.preprod.kushnarenko.exception.UserIsBlockedException;
import main.java.com.epam.preprod.kushnarenko.service.UserService;

@MultipartConfig
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = -6469185768904751455L;

    private final static Logger logger = Logger.getLogger(LoginServlet.class);

    private UserService userService;

    private Integer maxTriesCount;

    @Override
    public void init(ServletConfig sc) throws ServletException {
        userService = (UserService) sc.getServletContext().getAttribute("userService");
        maxTriesCount = (Integer) sc.getServletContext().getAttribute("maxTriesCount");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession hs = request.getSession();
        String forward = Path.LOG_IN;
        if (hs != null) {
            if (hs.getAttribute("wasPost") != null) {
                boolean wasPost = (boolean) hs.getAttribute("wasPost");
                if (!wasPost) {
                    hs.setAttribute("error", null);
                }
                hs.setAttribute("wasPost", false);
            }
        }
        request.getRequestDispatcher(forward).forward(request, resp);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = Path.LOGIN_SERVLET;
        String email = request.getParameter(Const.EMAIL);
        String password = request.getParameter(Const.PASSWORD);
        User u = userService.login(email, password);
        HttpSession hs = request.getSession();
        if (u == null) {
            hs.setAttribute(Const.INCORRECT_LOGIN_DATA, Const.INCORRECT_LOGIN_DATA);
            logger.error("Error with logining");
        } else {
            if (u.isBlocked(maxTriesCount)) {
                throw new UserIsBlockedException();
            }
            hs = request.getSession();
            hs.setAttribute(Const.CURRENT_USER, u);
            logger.info(String.format("User %s logged in", u));

        }
        String requestedPage = request.getParameter(Const.REQUSETED_PAGE);
        logger.info("Getting previously requested page from hidden input");
        if (!requestedPage.isEmpty()) {
            forward = Path.APPLICATION_ROOT_PATH + requestedPage;
        }
        hs.setAttribute("wasPost", true);
        response.sendRedirect(forward);
    }
}