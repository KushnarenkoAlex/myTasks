package main.java.com.epam.preprod.kushnarenko.filter.localeFilter;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interface for manager that allows to get Locale from Session or from Cookie
 * in dependence of implementation.
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public interface LocaleManager {

    /**
     * Allows to get locale from Session or Cookie.
     * 
     * @param Request
     * @return Locale or null if there is no language parameter in parameters
     */
    public Locale getLocale(HttpServletRequest req);

    /**
     * Allows to set locale to Session or Cookie parameters.
     * 
     * @param req
     * @param res
     * @param locale that we need to set.
     * @param time - lifetime of cookie
     */
    public void setLocale(HttpServletRequest req, HttpServletResponse res, Locale locale, Integer time);

}
