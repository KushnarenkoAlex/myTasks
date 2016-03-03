package main.java.com.epam.preprod.kushnarenko.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import main.java.com.epam.preprod.kushnarenko.constants.Const;
import main.java.com.epam.preprod.kushnarenko.filter.localeFilter.LocaleManager;
import main.java.com.epam.preprod.kushnarenko.filter.localeFilter.GetLocaleManagerContainer;
import main.java.com.epam.preprod.kushnarenko.filter.requestWrappers.LocaleRequestWrapper;
import main.java.com.epam.preprod.kushnarenko.utils.FilterUtil;

/**
 * LocaleFilter is a filter for setting right Locale to Session or Cookie
 * parameters. Has several stages of looking right locale. Firstly checks if
 * required locale is in request parameters. Secondly gets Locale from Cookie or
 * Session in dependence of type of getting locale. Thirdly gets preferred
 * languages from browser and checks if there is supported language to set
 * locale. Lastly sets default locale if previous stages haven't worked.
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public class LocaleFilter implements Filter {

    public static final String SUPPORTED_LANGUAGES = "languages";
    public static final String DEFAULT_LANGUAGE = "defaultlang";
    public static final String LIFE_TIME_OF_COOKIE = "time";
    public static final String GETTING_LOCALE_TYPE = "type";

    private final static Logger logger = Logger.getLogger(LocaleFilter.class);

    private List<String> languages = new ArrayList<>();
    private Integer lifeTimeOfCookie;
    private LocaleManager localeStrategy;
    private String defaultLocale;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        request.getServletContext().setAttribute(SUPPORTED_LANGUAGES, languages);
        if (FilterUtil.incorrectType(req)) {
            Locale locale = null;
            logger.debug("LocaleFilterdoFilter" + req.getServletPath());

            HttpServletResponse res = (HttpServletResponse) response;
            String localeName = req.getParameter(Const.REQUEST_PARAMETER_LANGUAGE);
            logger.info(String.format("Locale Name from request %s", localeName));
            logger.debug(String.format("Lanquages contains request lang = %s", localeName));
            if (localeName != null && languages.contains(localeName)) {
                locale = new Locale(localeName);
                logger.debug(String.format("Locale from request %s", locale.getDisplayName()));
            }
            if (locale == null) {
                logger.debug(localeStrategy);
                locale = localeStrategy.getLocale(req);
            }
            if (locale == null) {
                logger.debug("findFirstAppropriateLocale");
                Enumeration<Locale> locales = req.getLocales();
                while (locales.hasMoreElements()) {
                    Locale lang = locales.nextElement();
                    if (languages.contains(lang.getLanguage())) {
                        locale = lang;
                        break;
                    }
                }
            }
            if (locale == null) {
                locale = new Locale(defaultLocale);
            }
            logger.debug(String.format("Current locale %s", locale.getLanguage()));
            localeStrategy.setLocale(req, res, locale, lifeTimeOfCookie);
            LocaleRequestWrapper localeRequestWrapper = new LocaleRequestWrapper(req, locale);
            chain.doFilter(localeRequestWrapper, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String initLocales = filterConfig.getInitParameter(SUPPORTED_LANGUAGES);

        for (String locale : initLocales.split(",")) {
            languages.add(locale);
        }

        lifeTimeOfCookie = Integer.parseInt(filterConfig.getInitParameter(LIFE_TIME_OF_COOKIE));

        String type = filterConfig.getInitParameter(GETTING_LOCALE_TYPE);
        localeStrategy = GetLocaleManagerContainer.getStrategy(type);
        logger.debug(String.format("Type of findig locale - %s", type));

        defaultLocale = filterConfig.getInitParameter(DEFAULT_LANGUAGE);

    }

    @Override
    public void destroy() {
    }

}
