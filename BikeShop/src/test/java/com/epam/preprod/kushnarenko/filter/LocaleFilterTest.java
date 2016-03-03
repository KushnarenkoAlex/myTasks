package test.java.com.epam.preprod.kushnarenko.filter;

import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Vector;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import main.java.com.epam.preprod.kushnarenko.constants.Const;
import main.java.com.epam.preprod.kushnarenko.filter.LocaleFilter;
import main.java.com.epam.preprod.kushnarenko.filter.localeFilter.LocaleManager;
import main.java.com.epam.preprod.kushnarenko.filter.localeFilter.SessionLocaleManager;
import main.java.com.epam.preprod.kushnarenko.utils.FilterUtil;

public class LocaleFilterTest {

    LocaleFilter filter = PowerMockito.spy(new LocaleFilter());

    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession httpSession;
    HttpSession httpSession2;
    FilterChain filterChain;
    FilterConfig filterConfig;
    ServletContext servletContext;

    LocaleManager getLocale = new SessionLocaleManager();

    @Before
    public void init() throws ServletException {
        PowerMockito.mock(FilterUtil.class);
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        httpSession = mock(HttpSession.class);
        httpSession2 = mock(HttpSession.class);
        filterChain = mock(FilterChain.class);
        servletContext = mock(ServletContext.class);
        filterConfig = Mockito.mock(FilterConfig.class);
        filter = new LocaleFilter();
        when(request.getServletContext()).thenReturn(servletContext);
        when(request.getServletPath()).thenReturn("path");
        when(request.getSession()).thenReturn(httpSession);
        when(filterConfig.getInitParameter("languages")).thenReturn("ru,en,be");
        when(filterConfig.getInitParameter("time")).thenReturn("1000");
        when(filterConfig.getInitParameter("type")).thenReturn("session");
        when(filterConfig.getInitParameter("defaultlang")).thenReturn("en");
        filter.init(filterConfig);
    }

    @Test
    public void testDoFilter() throws IOException, ServletException {
        when(request.getParameter(Const.REQUEST_PARAMETER_LANGUAGE)).thenReturn("ru");
        filter.doFilter(request, response, filterChain);
        System.out.println(request.getParameter("lang"));
    }

    @Test
    public void testDoFilterFromSession() throws IOException, ServletException {
        when(request.getSession(true)).thenReturn(httpSession2);
        when(request.getParameter(Const.REQUEST_PARAMETER_LANGUAGE)).thenReturn("fa");
        Enumeration<Locale> locales = new Vector().elements();
        when(request.getLocales()).thenReturn(locales);
        filter.doFilter(request, response, filterChain);
        System.out.println(request.getParameter("lang"));
    }

}
