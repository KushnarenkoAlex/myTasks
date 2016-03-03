package main.java.com.epam.preprod.kushnarenko.filter.localeFilter;

import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import main.java.com.epam.preprod.kushnarenko.constants.Const;

public class CookieLocaleManager implements LocaleManager {

    private final static Logger logger = Logger.getLogger(CookieLocaleManager.class);

    @Override
    public Locale getLocale(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        String lang = null;
        for (Cookie c : cookies) {
            if (c.getName().equals(Const.REQUEST_PARAMETER_LANGUAGE)) {
                lang = c.getValue();
                return new Locale(lang);
            }
        }
        return null;
    }

    @Override
    public void setLocale(HttpServletRequest req, HttpServletResponse res, Locale locale, Integer time) {
        Cookie cookie = new Cookie(Const.REQUEST_PARAMETER_LANGUAGE, locale.getLanguage());
        logger.info(String.format("Cookie lang = %s", cookie));
        cookie.setMaxAge(time);
        res.addCookie(cookie);
    }

}
