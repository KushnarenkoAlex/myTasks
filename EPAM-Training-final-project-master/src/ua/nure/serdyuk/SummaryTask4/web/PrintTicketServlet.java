package ua.nure.serdyuk.SummaryTask4.web;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.serdyuk.SummaryTask4.constants.Const;
import ua.nure.serdyuk.SummaryTask4.constants.Path;
import ua.nure.serdyuk.SummaryTask4.entity.bean.TicketOrderBean;
import ua.nure.serdyuk.SummaryTask4.util.ETicket;

@WebServlet("/print")
public class PrintTicketServlet extends HttpServlet {

	private static final long serialVersionUID = -7524283826508142297L;

	private static final Logger LOG = Logger
			.getLogger(PrintTicketServlet.class);

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		TicketOrderBean bean = (TicketOrderBean) req.getSession()
				.getAttribute(Const.TICKET_ORDER_BEAN);
		String path = req.getServletContext()
				.getRealPath(System.getProperty("file.separator"));
		LOG.debug(path);
		ByteArrayOutputStream baos = new ETicket(bean)
				.createDocument(path + Path.ETICKET_NAME);

		resp.setContentType("application/pdf");
		resp.addHeader("Content-Disposition",
				String.format("attachment; filename=%s", Path.ETICKET_NAME));
		resp.setContentLength(baos.size());

		ServletOutputStream os = resp.getOutputStream();
		baos.writeTo(os);
		os.flush();
		os.close();

		baos.close();
	}

}
