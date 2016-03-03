package ua.nure.serdyuk.SummaryTask4.command.admin;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.serdyuk.SummaryTask4.command.Command;
import ua.nure.serdyuk.SummaryTask4.constants.Const;
import ua.nure.serdyuk.SummaryTask4.constants.Path;
import ua.nure.serdyuk.SummaryTask4.db.service.CarriageService;
import ua.nure.serdyuk.SummaryTask4.entity.Carriage;

public class AddCarriagesCommand implements Command {

	private static final Logger LOG = Logger
			.getLogger(AddCarriagesCommand.class);

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		int trainId = (int) req.getSession().getAttribute(Const.TRAIN_ID);
		
		List<Carriage> carriages = extractCarriages(req, trainId);
		LOG.info(String.format("Carriages found ==> %s", carriages.toString()));

		CarriageService service = (CarriageService) req.getServletContext()
				.getAttribute(Const.CARRIAGE_SERVICE);
		if (service.createAll(carriages)) {
			LOG.info("Carriages created successfully.");
		} else {
			LOG.error("Failed to create carriages");
		}

		return Path.CARRIAGES_VIEW_COMMAND;
	}

	private List<Carriage> extractCarriages(HttpServletRequest req, int trainId) {
		String[] carTags = req.getParameterValues("carTag");
		String[] types = req.getParameterValues("carTypeSelect");
		String[] prices = req.getParameterValues("carPrice");
		List<Carriage> carriages = new ArrayList<>();

		Carriage c;
		for (int i = 0; i < carTags.length; i++) {
			c = new Carriage();
			c.setTag(carTags[i]);
			c.setTrainId(trainId);

			int typeId = Integer.valueOf(types[i]);
			c.setCarTypeId(typeId);

			BigDecimal price = BigDecimal.valueOf(Double.valueOf(prices[i]));
			c.setPrice(price);

			carriages.add(c);
		}
		
		return carriages;
	}

}
