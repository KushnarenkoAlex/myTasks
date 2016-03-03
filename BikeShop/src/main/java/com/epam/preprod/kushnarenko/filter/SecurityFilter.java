package main.java.com.epam.preprod.kushnarenko.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import main.java.com.epam.preprod.kushnarenko.constants.Const;
import main.java.com.epam.preprod.kushnarenko.constants.Path;
import main.java.com.epam.preprod.kushnarenko.entity.User;
import main.java.com.epam.preprod.kushnarenko.security.ConstraintsContainer;
import main.java.com.epam.preprod.kushnarenko.security.SecurityDomParser;
import main.java.com.epam.preprod.kushnarenko.utils.FilterUtil;

/**
 * Filter for checking accessibility for user. Firstly checks if required page
 * is in list of pages with constraining. If it is, method checks if user is
 * logged in and redirects User to logging page if he isn't logged in, sends 403
 * error if access denied for this User or allows User to go farther if access
 * allowed.
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public class SecurityFilter implements Filter {

    private final static Logger logger = Logger.getLogger(SecurityFilter.class);

    private static final String SECURITY_FILE_PATH = "securityFilePath";
    private static final String URL_PAGE_REGEX = "^(.*)(/(.*))$";
    private static final String SECOND_GROUP = "$2";

    private ConstraintsContainer constraintsContainer;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (!FilterUtil.incorrectType(req)) {
            chain.doFilter(request, response);
            return;
        }

        String path = req.getRequestURI().replaceAll(URL_PAGE_REGEX, SECOND_GROUP);
        if (!constraintsContainer.containsPath(path)) {
            logger.debug("dont need permission for this page");
            chain.doFilter(request, response);
            return;
        }

        HttpSession hs = req.getSession(true);
        User user = (User) hs.getAttribute(Const.CURRENT_USER);
        logger.info(String.format("Logged user %s", user));
        if (user == null) {
            logger.debug("Forwarding to login servlet");
            req.setAttribute(Const.REQUSETED_PAGE, path);
            req.getRequestDispatcher(Path.LOG_IN).forward(request, response);
            return;
        }

        if (constraintsContainer.accessAllowed(path, user.getRole())) {
            logger.debug("access allowed");
            chain.doFilter(request, response);
            return;
        }

        logger.debug("Access denied");
        res.sendError(HttpServletResponse.SC_FORBIDDEN);

    }

    /**
     * This method initializes new ConstraintsContainer that delegates access of
     * Roles to Pages.
     * 
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String securityFilePath = filterConfig.getInitParameter(SECURITY_FILE_PATH);
        String xmlSecurityFilePath = filterConfig.getServletContext().getRealPath(securityFilePath);
        constraintsContainer = new SecurityDomParser(xmlSecurityFilePath).parse();
    }

    @Override
    public void destroy() {

    }

}
