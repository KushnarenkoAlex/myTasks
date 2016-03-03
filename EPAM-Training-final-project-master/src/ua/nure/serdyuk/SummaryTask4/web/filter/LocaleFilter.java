package ua.nure.serdyuk.SummaryTask4.web.filter;

import java.io.IOException;
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
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.omg.CORBA.PRIVATE_MEMBER;

import ua.nure.serdyuk.SummaryTask4.constants.Const;

/**
 * This filter is used to determine initial locale value, and furthermore to
 * change locale settings by client.
 * 
 * @author Daria Serdiuk
 *
 */
public class LocaleFilter implements Filter {

	private static final Logger LOG = Logger.getLogger(LocaleFilter.class);

	private Locale defaultLocale;

	public void init(FilterConfig fConfig) throws ServletException {
		String localeStr = fConfig.getInitParameter(Const.DEFAULT_LOCALE);

		defaultLocale = new Locale(localeStr);
		LOG.info(
				String.format("LocaleFilter initialized, default locale ==> %s",
						defaultLocale));
	}

	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		List<Locale> avLocales = (List<Locale>) request.getServletContext()
				.getAttribute(Const.LOCALE_LIST_LOCALE);
		String param = request.getParameter(Const.NEW_LOCALE);

		Locale newLocale = null;

		if (param != null) {
			newLocale = new Locale(param);
			LOG.debug("locale from req ==> " + newLocale);
		}

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		Locale curLocale = (Locale) session
				.getAttribute(Const.CURRENT_LOCALE_LOCALE);

		LOG.debug(String.format("Current locale in session ==> %s",
				String.valueOf(curLocale)));

		if (newLocale != null && avLocales.contains(newLocale)) {
			LOG.debug(
					String.format("Locale is set by client ==> %s", newLocale));
		} else if (curLocale == null) {
			// locale is set the first time
			Enumeration<Locale> reqLocales = req.getLocales();
			while (reqLocales.hasMoreElements()) {
				Locale loc = new Locale(reqLocales.nextElement().getLanguage());
				if (avLocales.contains(loc)) {
					newLocale = loc;
					LOG.debug(String.format("Locale is set from request ==> %s",
							loc));
					break;
				}
			}
			if (newLocale == null) {
				newLocale = defaultLocale;
				LOG.debug("Locale is set to default");
			}
		} else {
			newLocale = null;
		}
		if (newLocale != null) {
			session.setAttribute(Const.CURRENT_LOCALE_LOCALE, newLocale);
			LOG.info(String.format("Locale was set to %s", newLocale));
		}

		LOG.info(String.format("Current locale ==> %s",
				session.getAttribute(Const.CURRENT_LOCALE_LOCALE)));

		chain.doFilter(request, response);
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}
}
