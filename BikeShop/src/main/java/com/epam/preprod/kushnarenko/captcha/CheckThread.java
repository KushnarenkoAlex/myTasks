package main.java.com.epam.preprod.kushnarenko.captcha;

import org.apache.log4j.Logger;

public class CheckThread extends Thread {

    private boolean end;

    private final static Logger logger = Logger.getLogger(CheckThread.class);

    private long captchaLiveTime, chekingTime;

    public CheckThread(long captchaLiveTime, long chekingTime) {
        this.captchaLiveTime = captchaLiveTime;
        this.chekingTime = chekingTime;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (!end) {
            try {
                sleep(chekingTime);
                CaptchaContainer.getInstance().checkDelete(captchaLiveTime);
            } catch (InterruptedException e) {
                logger.error("Check thread was interrupted", e);
                return;
            }

        }
    }

    public void endThread() {
        end = true;
    }

}
