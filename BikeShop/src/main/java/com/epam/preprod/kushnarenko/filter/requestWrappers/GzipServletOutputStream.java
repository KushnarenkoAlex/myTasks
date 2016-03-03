package main.java.com.epam.preprod.kushnarenko.filter.requestWrappers;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;

/**
 * Redefining for ServletOutputStream. Using GZIPOutputStream allows to compress
 * data written to GZipServletOutputStream.
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public class GzipServletOutputStream extends ServletOutputStream {

    private GZIPOutputStream gzip = null;

    public GzipServletOutputStream(OutputStream os) throws IOException {
        super();
        gzip = new GZIPOutputStream(os);
    }

    @Override
    public void close() throws IOException {
        this.gzip.close();
    }

    @Override
    public void flush() throws IOException {
        this.gzip.flush();
    }

    @Override
    public void write(byte b[]) throws IOException {
        this.gzip.write(b);
    }

    @Override
    public void write(byte b[], int off, int len) throws IOException {
        this.gzip.write(b, off, len);
    }

    @Override
    public void write(int b) throws IOException {
        this.gzip.write(b);
    }

}
