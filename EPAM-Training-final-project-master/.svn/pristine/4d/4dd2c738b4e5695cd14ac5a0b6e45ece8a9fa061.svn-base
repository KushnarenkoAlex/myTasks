package ua.nure.serdyuk.SummaryTask4.command.ajax;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.serdyuk.SummaryTask4.command.Command;
import ua.nure.serdyuk.SummaryTask4.constants.Const;
import ua.nure.serdyuk.SummaryTask4.db.service.StationService;
import ua.nure.serdyuk.SummaryTask4.entity.Station;
import ua.nure.serdyuk.SummaryTask4.validation.Validator;

public class UpdateStationCommand implements Command {

	private static final Logger LOG = Logger
			.getLogger(UpdateStationCommand.class);

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		String key = req.getParameter("pk");
		String value = req.getParameter("value");

		long id = Long.valueOf(key);

		Station s = new Station();
		s.setId(id);
		s.setName(value);

		List<String> errors = Validator.validate(s);
		if (!errors.isEmpty()) {
			LOG.error(String.format("Validation failed ==> %s",
					errors.toString()));
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return errors.get(0);
		}

		LOG.info(String.format("updating station ==> %s	", s.toString()));

		StationService service = (StationService) req.getServletContext()
				.getAttribute(Const.STATION_SERVICE);
		int status = service.update(s) ? HttpServletResponse.SC_OK
				: HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
		res.setStatus(status);

		return "message.try_again";
	}

}
