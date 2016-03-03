package main.java.com.epam.preprod.kushnarenko.filter.requestWrappers;

import java.util.Enumeration;
import java.util.Locale;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Wrapper for request that redefines getLocale and getLocales(required by
 * task).
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public class LocaleRequestWrapper extends HttpServletRequestWrapper {

    private Locale locale;

    public LocaleRequestWrapper(HttpServletRequest request, Locale locale) {
        super(request);
        this.locale = locale;
    }

    /**
     * Returns current locale.
     */
    @Override
    public Locale getLocale() {
        return locale;
    }

    /**
     * Returns Enumeration containing only current locale.
     */
    @Override
    public Enumeration<Locale> getLocales() {
        Vector<Locale> locales = new Vector<>();
        locales.addElement(locale);
        return locales.elements();
    }

}
