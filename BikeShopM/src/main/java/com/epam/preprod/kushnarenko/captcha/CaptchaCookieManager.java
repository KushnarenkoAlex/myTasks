package main.java.com.epam.preprod.kushnarenko.captcha;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CaptchaCookieManager implements CaptchaManager {

	@Override
	public void send(String captchaId, String captchaValue, HttpServletRequest request, HttpServletResponse response) {
		CaptchaContainer cc = CaptchaContainer.getInstance();
		cc.put(captchaValue, captchaId);
		Cookie cookie = new Cookie("captchaId", captchaId);
		response.addCookie(cookie);
	}

	@Override
	public boolean check(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		String id = null;
		for (Cookie c : cookies) {
			if (c.getName().equals("captchaId")) {
				id = c.getValue();
			}
		}
		String captcha = request.getParameter("captchaValue");
		CaptchaContainer cc = CaptchaContainer.getInstance();
		boolean b = cc.contains(id, captcha);
		return b;
	}

}
