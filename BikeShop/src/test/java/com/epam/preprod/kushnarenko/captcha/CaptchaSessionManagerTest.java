package test.java.com.epam.preprod.kushnarenko.captcha;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;

import main.java.com.epam.preprod.kushnarenko.captcha.CaptchaSessionManager;

public class CaptchaSessionManagerTest {

    CaptchaSessionManager ccm;
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession hs;

    @Before
    public void init() {
        ccm = new CaptchaSessionManager();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        when(request.getParameter("captchaValue")).thenReturn("1");
        hs = mock(HttpSession.class);
        when(hs.getAttribute("captcha")).thenReturn("1");
        when(request.getSession()).thenReturn(hs);
    }

    @Test
    public void testCheck() {
        ccm.send("1", "1", request, response);
        assertTrue(ccm.check(request, response));
    }

}
