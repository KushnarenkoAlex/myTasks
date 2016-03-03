package main.java.com.epam.preprod.kushnarenko.captcha;

import java.util.HashMap;

public class CaptchasTypesContainer {

	private static HashMap<String, CaptchaManager> capthas = new HashMap<>();

	static {
		capthas.put("session", new CaptchaSessionManager());
		capthas.put("cookie", new CaptchaCookieManager());
		capthas.put("hidden", new CaptchaHiddenManager());
	}

	public static CaptchaManager getCaptchaGenerator(String key) {
		return capthas.get(key);
	}

}
