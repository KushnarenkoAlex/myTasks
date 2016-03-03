package main.java.com.epam.preprod.kushnarenko.captcha;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class CaptchaContainer {

    /**
     * Represents container for saving all captchas.
     * @author Oleksandr_Kushnarenk
     *
     */
    private ConcurrentHashMap<String, Captcha> captchas = new ConcurrentHashMap<>();

    private static final CaptchaContainer instance = new CaptchaContainer();

    private CaptchaContainer() {
    }

    public static CaptchaContainer getInstance() {
        return instance;
    }

    public void put(String captcha, String captchaId) {
        captchas.put(captchaId, new Captcha(captchaId, captcha, System.currentTimeMillis()));
    }

    public void checkDelete(long deleteTime) {
        for (Entry<String, Captcha> e : captchas.entrySet()) {
            if (System.currentTimeMillis() > e.getValue().getTime() + deleteTime) {
                {
                    captchas.remove(e.getKey());
                }
            }
        }
    }

    public boolean contains(String id, String captcha) {
        if (captchas.get(id) != null) {
            return captchas.get(id).equals(captcha);
        }
        return false;
    }

}
