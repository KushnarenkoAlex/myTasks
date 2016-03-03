package ua.nure.serdyuk.SummaryTask4.web.tag;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import ua.nure.serdyuk.SummaryTask4.constants.Const;

public class GoBackTag extends SimpleTagSupport {

	public void doTag() throws JspException, IOException {
		JspWriter jw = getJspContext().getOut();

		Locale locale = (Locale) getJspContext()
				.findAttribute(Const.CURRENT_LOCALE_LOCALE);

		String text = (locale != null && locale.getLanguage().equals("ru"))
				? "Назад" : "Go back";

		jw.append(
				"<div class='container'><a class='btn btn-success btn-lg'  href='javascript:history.go(-1)'>")
				.append(text).append("</a></div>");
	}

}
