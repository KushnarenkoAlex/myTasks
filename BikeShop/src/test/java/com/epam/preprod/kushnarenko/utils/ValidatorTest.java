package test.java.com.epam.preprod.kushnarenko.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.java.com.epam.preprod.kushnarenko.bean.RegistrationUserBean;
import main.java.com.epam.preprod.kushnarenko.constants.Const;
import main.java.com.epam.preprod.kushnarenko.utils.ErrorsList;
import main.java.com.epam.preprod.kushnarenko.utils.Validator;

public class ValidatorTest {

    Validator v;
    RegistrationUserBean rub;

    @Before
    public void init() {
        v = new Validator();
        rub = new RegistrationUserBean();
        rub.setFirstName("alex");
        rub.setLastName("kush");
        rub.setEmail("kush@gmail.com");
        rub.setPassword("1234");
        rub.setPassword2("1234");
        rub.setPhoneNumber("123 123 12 12");
        rub.setSpam("spam");

    }

    @Test
    public void testCheckUser() {
        ErrorsList el = new ErrorsList();
        v.checkUser(rub, el);
        assertEquals(0, el.size());
    }

    @Test
    public void testCheckDifferentPaswords() {
        rub.setPassword2("12345");
        ErrorsList el = new ErrorsList();
        v.checkUser(rub, el);
        assertEquals(Const.INCORRECT_PASSWORDS + System.lineSeparator(), el.get(Const.INCORRECT_PASSWORDS));
    }

}
