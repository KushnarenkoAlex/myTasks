package main.java.com.epam.preprod.kushnarenko.filter.localeFilter;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.com.epam.preprod.kushnarenko.constants.Const;

public class SessionLocaleManager implements LocaleManager {

    @Override
    public Locale getLocale(HttpServletRequest req) {
        HttpSession hs = req.getSession(true);
        String lang = (String) hs.getAttribute(Const.REQUEST_PARAMETER_LANGUAGE);
        if (lang == null) {
            return null;
        }
        return new Locale(lang);
    }

    @Override
    public void setLocale(HttpServletRequest req, HttpServletResponse res, Locale locale, Integer time) {
        HttpSession hs = req.getSession();
        hs.setAttribute(Const.REQUEST_PARAMETER_LANGUAGE, locale.getLanguage());
    }

}
