package main.java.com.epam.preprod.kushnarenko.utils;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import main.java.com.epam.preprod.kushnarenko.bean.RegistrationUserBean;
import main.java.com.epam.preprod.kushnarenko.bean.ValidatingAnno;
import main.java.com.epam.preprod.kushnarenko.constants.Const;

public class Validator {

    private final static Logger logger = Logger.getLogger(Validator.class.getName());

    public void checkUser(RegistrationUserBean rub, ErrorsList errorsList) {
        try {
            check(errorsList, rub);
        } catch (IllegalArgumentException e) {
            logger.error("IllegalArgumentException in checking user on valid", e);
        } catch (IllegalAccessException e) {
            logger.error("IllegalAccessException", e);
        }
        if (!rub.getPassword().equals(rub.getPassword2())) {
            String passwordsAreIncorrect = Const.INCORRECT_PASSWORDS;
            errorsList.put(passwordsAreIncorrect, Const.INCORRECT_PASSWORDS);
        }
    }

    private static void check(ErrorsList errors, Object obj) throws IllegalArgumentException, IllegalAccessException {
        Class<?> clazz = obj.getClass();
        for (Field f : clazz.getDeclaredFields()) {
            ValidatingAnno a = f.getAnnotation(ValidatingAnno.class);
            if (a != null) {
                Pattern p = Pattern.compile(a.regex());
                f.setAccessible(true);
                Matcher m = p.matcher((String) f.get(obj));
                if (!m.matches()) {
                    String errorText = a.error();
                    errors.put(f.getName(), errorText);
                }
            }
        }
    }

}
