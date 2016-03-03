package ua.nure.serdyuk.SummaryTask4.command.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.serdyuk.SummaryTask4.command.Command;
import ua.nure.serdyuk.SummaryTask4.constants.Const;
import ua.nure.serdyuk.SummaryTask4.constants.Path;
import ua.nure.serdyuk.SummaryTask4.db.service.StationService;
import ua.nure.serdyuk.SummaryTask4.entity.Station;
import ua.nure.serdyuk.SummaryTask4.validation.Validator;

public class AddStationCommand implements Command {

	private static final Logger LOG = Logger.getLogger(AddStationCommand.class);

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		String name = req.getParameter("stationName");

		LOG.debug("In add station");

		Station s = new Station();
		s.setName(name);

		List<String> errors = Validator.validate(s);
		if (!errors.isEmpty()) {
			LOG.error(String.format("Validation failed ==> %s",
					errors.toString()));
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			req.getSession().setAttribute(Const.ERRORS, errors);
			return Path.STATIONS_VIEW_COMMAND;
		}

		LOG.info(String.format("creating station ==> %s	", s.toString()));

		StationService service = (StationService) req.getServletContext()
				.getAttribute(Const.STATION_SERVICE);
		int status = service.create(s) ? HttpServletResponse.SC_OK
				: HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
		res.setStatus(status);

		return Path.STATIONS_VIEW_COMMAND;
	}

}
