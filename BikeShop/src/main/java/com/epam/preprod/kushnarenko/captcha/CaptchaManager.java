package main.java.com.epam.preprod.kushnarenko.captcha;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CaptchaManager {

    /**
     * This method sends captchaId and captchaValue to Session, Cookie or Hidden
     * field in dependence of realization.
     * 
     * @param captchaId
     * @param captchaValue
     * @param request
     * @param response
     */
    public void send(String captchaId, String captchaValue, HttpServletRequest request, HttpServletResponse response);

    /**
     * This method get value of captcha from Session, Cookie or Hidden field in
     * dependence of realization and checks if it correct.
     * 
     * @param request
     * @param response
     */
    public boolean check(HttpServletRequest request, HttpServletResponse response);

}
