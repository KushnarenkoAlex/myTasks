package main.java.com.epam.preprod.kushnarenko.captcha;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.com.epam.preprod.kushnarenko.constants.Const;

public class CaptchaSessionManager implements CaptchaManager {

	@Override
	public void send(String captchaId, String captchaValue, HttpServletRequest request, HttpServletResponse response) {
		HttpSession hs = request.getSession(true);
		CaptchaContainer.getInstance().put(captchaValue, captchaId);
		hs.setAttribute(Const.CAPTCHA, captchaValue);
	}

	@Override
	public boolean check(HttpServletRequest request, HttpServletResponse response) {
		HttpSession hs = request.getSession(true);
		String captcha = request.getParameter("captchaValue");
		String correctCaptcha = (String) hs.getAttribute(Const.CAPTCHA);
		return captcha.equals(correctCaptcha);
	}

}
