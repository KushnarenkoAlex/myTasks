package ua.nure.serdyuk.SummaryTask4.web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.serdyuk.SummaryTask4.constants.Const;

public class CleanSessionFilter implements Filter {

	private static final Logger LOG = Logger
			.getLogger(CleanSessionFilter.class);
	
	private static final List<String> ESSENTIAL_ATTR;
	
	static{
		ESSENTIAL_ATTR = new ArrayList<>();
		ESSENTIAL_ATTR.add(Const.CURRENT_LOCALE_LOCALE);
		ESSENTIAL_ATTR.add(Const.CURRENT_USER);
		ESSENTIAL_ATTR.add("javax.servlet.jsp.jstl.fmt.request.charset");
	}

	private List<String> commands;

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String command = request.getParameter("command");

		if (commands.contains(command)) {
			HttpSession session = ((HttpServletRequest) request).getSession();

			Enumeration<String> atts = session.getAttributeNames();
			while (atts.hasMoreElements()) {
				String param = atts.nextElement();
				if (!ESSENTIAL_ATTR.contains(param)) {
					session.setAttribute(param, null);
					LOG.debug(String.format("%s is set to null", param));
				}
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		String[] commandsStr = fConfig.getInitParameter("commands")
				.split("\\s+");
		commands = Arrays.asList(commandsStr);

		LOG.info(String.format("Session will be cleaned for %s ", commands));
	}

}
