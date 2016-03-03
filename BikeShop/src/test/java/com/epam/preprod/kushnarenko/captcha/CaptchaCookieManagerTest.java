package test.java.com.epam.preprod.kushnarenko.captcha;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

import main.java.com.epam.preprod.kushnarenko.captcha.CaptchaCookieManager;

public class CaptchaCookieManagerTest {

	CaptchaCookieManager ccm;
	HttpServletRequest request;
	HttpServletResponse response;
	Cookie cookie;

	@Before
	public void init() {
		ccm = new CaptchaCookieManager();
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		cookie = mock(Cookie.class);
	}

	@Test
	public void testCheck() {
		when(cookie.getName()).thenReturn("captchaId");
		when(cookie.getValue()).thenReturn("1");
		when(request.getParameter("captchaValue")).thenReturn("1");
		when(request.getCookies()).thenReturn(new Cookie[] { cookie });
		ccm.send("1", "1", request, response);
		assertTrue(ccm.check(request, response));
	}

}
