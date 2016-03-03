package ua.nure.serdyuk.SummaryTask4.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.serdyuk.SummaryTask4.command.container.CommandContainer;

@WebServlet("/controller")
public class Controller extends HttpServlet {

	private static final Logger LOG = Logger.getLogger(Controller.class);

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		process(req, resp, "get");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		process(req, resp, "post");
	}

	private void process(HttpServletRequest req, HttpServletResponse resp, String method)
			throws IOException, ServletException {
		String command = req.getParameter("command");

		LOG.debug("Executing command " + command);
		String path = CommandContainer.get(command).execute(req, resp);
		//resp.sendRedirect("http://google.com");
		
		if (method.equals("post")) {
			LOG.debug("Redirecting to " + path);
			resp.sendRedirect(req.getContextPath() + path);
		} else {
			LOG.debug("Forward to " + path);
			req.getRequestDispatcher(path).forward(req, resp);
		}
	}
}
