package test.java.com.epam.preprod.kushnarenko.servlet;

import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.when;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import main.java.com.epam.preprod.kushnarenko.captcha.CaptchasTypesContainer;
import main.java.com.epam.preprod.kushnarenko.constants.Path;
import main.java.com.epam.preprod.kushnarenko.entity.User;
import main.java.com.epam.preprod.kushnarenko.service.UserService;
import main.java.com.epam.preprod.kushnarenko.servlet.RegistrationServlet;

public class RegistrationServletTest {

    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession httpSession;
    HttpSession httpSession2;
    ServletContext servletContext;
    ServletConfig servletConfig;
    RequestDispatcher rd;
    Part part;
    UserService us;

    @Before
    public void init() {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        httpSession = mock(HttpSession.class);
        httpSession2 = mock(HttpSession.class);
        servletContext = mock(ServletContext.class);
        servletConfig = mock(ServletConfig.class);
        rd = mock(RequestDispatcher.class);
        part = mock(Part.class);
        us = mock(UserService.class);
    }

    @Test
    public void test() throws ServletException, IOException {
        when(request.getParameter("firstName")).thenReturn("alex");
        when(request.getParameter("lastName")).thenReturn("kush");
        when(request.getParameter("password")).thenReturn("pass");
        when(request.getParameter("password2")).thenReturn("pass");
        when(request.getParameter("email")).thenReturn("alex@gmail.com");
        when(request.getParameter("phoneNumber")).thenReturn("066 666 66 66");
        when(request.getParameter("spam")).thenReturn("spam");
        when(request.getParameter("captchaValue")).thenReturn("1");
        when(httpSession.getAttribute("captcha")).thenReturn("1");
        when(request.getSession()).thenReturn(httpSession);
        when(request.getRequestDispatcher(Path.MAIN)).thenReturn(rd);
        when(part.getHeader("content-disposition")).thenReturn("filename=\"\"");
        when(request.getPart("image")).thenReturn(part);
        String captchaType = "captchaType";
        String session = "session";
        RegistrationServlet rs = spy(new RegistrationServlet());
        when(servletContext.getInitParameter(captchaType)).thenReturn(session);

        when(request.getServletContext()).thenReturn(servletContext);
        when(us.exists(Mockito.any(User.class))).thenReturn(false);
        when(servletConfig.getServletContext()).thenReturn(servletContext);
        when(servletConfig.getServletContext().getAttribute("manager"))
                .thenReturn(CaptchasTypesContainer.getCaptchaGenerator("session"));
        when(servletConfig.getServletContext().getAttribute("userService")).thenReturn(us);
        rs.init(servletConfig);
        System.out.println(rs.setImage(request, ""));
        // when(rs.setImage(request, ""));
        rs.doPost(request, response);
    }

}
