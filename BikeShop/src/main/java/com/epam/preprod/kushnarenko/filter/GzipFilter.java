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

import org.apache.log4j.Logger;

import com.google.common.net.HttpHeaders;

import main.java.com.epam.preprod.kushnarenko.filter.requestWrappers.GzipResponseWrapper;

/**
 * Filter that wraps response into GzipResponseWrapper and add header to
 * response that this response is compressed by Gzip.
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public class GzipFilter implements Filter {

    private static final String GZIP_HEADER = "gzip";
    private final static Logger logger = Logger.getLogger(GzipFilter.class);

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String acceptEncoding = req.getHeader(HttpHeaders.ACCEPT_ENCODING);

        if (acceptEncoding != null && acceptEncoding.contains(GZIP_HEADER)) {
            logger.debug("Gziping");
            res.addHeader(HttpHeaders.CONTENT_ENCODING, GZIP_HEADER);
            GzipResponseWrapper gzipResponse = new GzipResponseWrapper(res);
            chain.doFilter(request, gzipResponse);
            gzipResponse.close();
        } else {
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }
}
