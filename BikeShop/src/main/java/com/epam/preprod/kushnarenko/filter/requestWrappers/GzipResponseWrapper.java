package main.java.com.epam.preprod.kushnarenko.filter.requestWrappers;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * Wrapper for request(required by task).
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public class GzipResponseWrapper extends HttpServletResponseWrapper implements Closeable{

    private PrintWriter pw;
    private GzipServletOutputStream gzip;

    public GzipResponseWrapper(HttpServletResponse res) {
        super(res);
    }

    @Override
    public void close() throws IOException {
        if (this.gzip != null) {
            this.gzip.close();
        }
        if (this.pw != null) {
            this.pw.close();
        }
    }

    @Override
    public void flushBuffer() throws IOException {
        if (pw != null) {
            pw.flush();
        }
        if (gzip != null) {
            gzip.flush();
        }
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        if (gzip == null) {
            this.gzip = new GzipServletOutputStream(getResponse().getOutputStream());
        }
        return gzip;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        if (this.pw == null) {
            this.gzip = new GzipServletOutputStream(getResponse().getOutputStream());
            this.pw = new PrintWriter(new OutputStreamWriter(this.gzip, getResponse().getCharacterEncoding()));
        }
        return this.pw;
    }

}
