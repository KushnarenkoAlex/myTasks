package main.java.com.epam.preprod.kushnarenko.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.google.common.net.HttpHeaders;

/**
 * Filter that turns off caching in response.
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public class TurnOffCacheFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        res.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
        res.setDateHeader(HttpHeaders.EXPIRES, 0);
        res.setHeader(HttpHeaders.PRAGMA, "No-cache");
        chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

}
