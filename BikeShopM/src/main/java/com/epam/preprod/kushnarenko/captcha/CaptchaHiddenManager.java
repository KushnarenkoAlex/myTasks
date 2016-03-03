package main.java.com.epam.preprod.kushnarenko.captcha;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CaptchaHiddenManager implements CaptchaManager {

	@Override
	public void send(String captchaId, String captchaValue, HttpServletRequest request, HttpServletResponse response) {
		CaptchaContainer cc = CaptchaContainer.getInstance();
		cc.put(captchaValue, captchaId);
		request.setAttribute("captchaId", captchaId);
	}

	@Override
	public boolean check(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("captchaId");
		String captcha = request.getParameter("captchaValue");
		CaptchaContainer cc = CaptchaContainer.getInstance();
		boolean b = cc.contains(id, captcha);
		return b;
	}

}
