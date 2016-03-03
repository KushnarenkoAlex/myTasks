package main.java.com.epam.preprod.kushnarenko.servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;

import main.java.com.epam.preprod.kushnarenko.bean.RegistrationUserBean;
import main.java.com.epam.preprod.kushnarenko.captcha.CaptchaManager;
import main.java.com.epam.preprod.kushnarenko.constants.Const;
import main.java.com.epam.preprod.kushnarenko.constants.Path;
import main.java.com.epam.preprod.kushnarenko.entity.User;
import main.java.com.epam.preprod.kushnarenko.service.UserService;
import main.java.com.epam.preprod.kushnarenko.utils.ErrorsList;
import main.java.com.epam.preprod.kushnarenko.utils.Transformer;
import main.java.com.epam.preprod.kushnarenko.utils.Util;
import main.java.com.epam.preprod.kushnarenko.utils.Validator;

@MultipartConfig
public class RegistrationServlet extends HttpServlet {

    private final static Logger logger = Logger.getLogger(RegistrationServlet.class);

    private static final long serialVersionUID = 315808438923774321L;

    private CaptchaManager captchaManager;
    private UserService userService;

    @Override
    public void init(ServletConfig sc) throws ServletException {
        captchaManager = (CaptchaManager) sc.getServletContext().getAttribute("manager");

        userService = (UserService) sc.getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession hs = request.getSession();
        String forward = Path.SIGN_UP;

        if (hs != null) {
            if (hs.getAttribute("wasPost") != null) {
                boolean wasPost = (boolean) hs.getAttribute("wasPost");
                if (!wasPost) {
                    hs.setAttribute("errors", null);
                }
                hs.setAttribute("wasPost", false);
            }
        }
        request.getRequestDispatcher(forward).forward(request, resp);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = Path.REGISTER;

        RegistrationUserBean rub = createUserBean(request);
        ErrorsList errors = new ErrorsList();
        new Validator().checkUser(rub, errors);
        logger.info("Captcha type:" + captchaManager.toString());
        boolean flag = captchaManager.check(request, response);
        HttpSession hp = request.getSession(true);
        if (!flag) {
            logger.debug("Wrong captcha was inputed");
            errors.put(Const.CAPTCHA, "Wrong captcha");
        }
        if (!checkFile(request)) {
            errors.put(Const.IMAGE, Const.INCORRECT_IMAGE);
        }
        hp.setAttribute("wasPost", true);
        if (errors.size() != 0) {
            hp.setAttribute("errors", errors);
            this.sendKey(request);
        } else {
            User u = new Transformer().getUser(rub);
            String imageName = u.getEmail().replaceAll("\\.", "").replaceAll("@", "");

            String image = setImage(request, imageName);
            u.setPicture(image);
            logger.debug(u);
            if (userService.exists(u)) {
                logger.info(String.format("User %s already exists", u));
                errors.put(Const.USER_EXISTS, Const.USER_EXISTS);
            }

            if (errors.size() != 0) {
                hp.setAttribute("errors", errors);
                this.sendKey(request);
            } else {
                hp.invalidate();
                hp = request.getSession();
                userService.create(u);
                logger.info(String.format("User %s was created", u));
                hp.setAttribute(Const.CURRENT_USER, u);
                logger.info(String.format("User %s was setted as Current user", u));
                forward = Path.LOGIN_SERVLET;
            }
        }
        response.sendRedirect(forward);
    }

    private void sendKey(HttpServletRequest request) {
        request.setAttribute("captchaId", Util.getKey());
    }

    private RegistrationUserBean createUserBean(HttpServletRequest request) {
        RegistrationUserBean rub = new RegistrationUserBean();
        HttpSession hs = request.getSession();
        String firstName = request.getParameter(Const.FIRST_NAME);
        rub.setFirstName(firstName);
        hs.setAttribute(Const.FIRST_NAME, firstName);
        String lastName = request.getParameter(Const.LAST_NAME);
        rub.setLastName(lastName);
        hs.setAttribute(Const.LAST_NAME, lastName);
        String password = request.getParameter(Const.PASSWORD);
        rub.setPassword(password);
        String password2 = request.getParameter(Const.PASSWORD2);
        rub.setPassword2(password2);
        String email = request.getParameter(Const.EMAIL);
        rub.setEmail(email);
        hs.setAttribute(Const.EMAIL, email);
        String phoneNumber = request.getParameter(Const.PHONE_NUMBER);
        rub.setPhoneNumber(phoneNumber);
        hs.setAttribute(Const.PHONE_NUMBER, phoneNumber);
        String spam = request.getParameter(Const.SPAM);
        rub.setSpam(spam);

        return rub;
    }

    public String setImage(HttpServletRequest request, String imageName)
            throws IllegalStateException, IOException, ServletException {
        Part filePart = request.getPart("image");
        String file = null;
        if (!filePart.equals(null)) {
            file = "avatar/" + imageName + ".png";
            String realPath = request.getServletContext().getRealPath("");
            logger.info("REAL PATH " + realPath);
            String fileName = realPath + "/" + file;
            filePart.write(fileName);
        }
        return file;
    }

    public boolean checkFile(HttpServletRequest request) throws IOException, ServletException {
        Part filePart = request.getPart("image");
        String header = filePart.getHeader("content-disposition");
        Pattern p = Pattern.compile("filename=\"(.*)\"");
        Matcher m = p.matcher(header);
        if (m.find()) {
            if (m.group(1).isEmpty()) {
                return true;
            }
        }
        if (!filePart.getContentType().split("/")[0].equals("image")) {
            System.out.println(filePart.getContentType().split("/")[0]);
            return false;
        }
        return true;
    }
}