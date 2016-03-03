package ua.nure.serdyuk.SummaryTask4.web.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.apache.log4j.Logger;

import ua.nure.serdyuk.SummaryTask4.constants.Const;
import ua.nure.serdyuk.SummaryTask4.constants.Path;
import ua.nure.serdyuk.SummaryTask4.entity.Role;
import ua.nure.serdyuk.SummaryTask4.entity.User;

public class AccessFilter implements Filter {

	private static final Logger LOG = Logger.getLogger(AccessFilter.class);

	private Map<String, List<String>> commands;

	private static final String ADMIN_KEY = "admin";

	private static final String USER_KEY = "user";

	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String command = request.getParameter("command");
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		if (command != null) {
			User currentUser = (User) httpRequest.getSession()
					.getAttribute(Const.CURRENT_USER);
			String redirect = Path.ERROR_404_VIEW;

			if (!allowed(command, currentUser)) {
				LOG.error(String.format("Access denied for command %s, user %s",
						command, (currentUser == null) ? "null"
								: currentUser.toString()));
				LOG.info("red ==> " + redirect);
				request.getRequestDispatcher(redirect).forward(request, response);
			} else {
				chain.doFilter(request, response);
			}

		} else {
			chain.doFilter(request, response);
		}
	}

	private boolean allowed(String command, User user) {

		if (commands.get(ADMIN_KEY).contains(command)
				&& (user == null || !user.getRole().equals(Role.ADMIN))) {
			return false;
		}

//		if (commands.get(USER_KEY).contains(command) && user == null) {
//			return false;
//		}

		return true;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		commands = new HashMap<>();

		List<String> list = Arrays
				.asList(fConfig.getInitParameter("admin").split("\\s+"));
		commands.put(ADMIN_KEY, list);
		LOG.info(String.format("Admin commands ==> %s", list.toString()));

		List<String> list2 = Arrays
				.asList(fConfig.getInitParameter("user").split("\\s+"));
		commands.put(USER_KEY, list2);
		LOG.info(String.format("User commands ==> %s", list2.toString()));
	}

}
