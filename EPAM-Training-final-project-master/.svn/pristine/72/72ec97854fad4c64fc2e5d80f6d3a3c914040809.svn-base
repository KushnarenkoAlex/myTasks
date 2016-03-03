package ua.nure.serdyuk.SummaryTask4.command.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.serdyuk.SummaryTask4.command.Command;
import ua.nure.serdyuk.SummaryTask4.constants.Const;
import ua.nure.serdyuk.SummaryTask4.constants.Path;

public class IndexViewCommand implements Command {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute(Const.TRAIN_INFO_BEANS, null);
		return Path.INDEX_VIEW;
	}

}
