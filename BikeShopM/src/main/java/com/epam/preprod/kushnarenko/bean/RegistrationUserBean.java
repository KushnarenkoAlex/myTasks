
package main.java.com.epam.preprod.kushnarenko.bean;

import main.java.com.epam.preprod.kushnarenko.constants.Const;

public class RegistrationUserBean implements Bean {

    private String id;

    @ValidatingAnno(error = Const.INCORRECT_FIRST_NAME, regex = Const.FIRST_NAME_REGEX)
    private String firstName;

    @ValidatingAnno(error = Const.INCORRECT_LAST_NAME, regex = Const.LAST_NAME_REGEX)
    private String lastName;

    @ValidatingAnno(error = Const.INCORRECT_PASSWORD, regex = Const.PASSWORD_REGEX)
    private String password;

    private String password2;

    @ValidatingAnno(error = Const.INCORRECT_EMAIL, regex = Const.EMAIL_REGEX)
    private String email;

    @ValidatingAnno(error = Const.INCORRECT_PHONE_NUMBER, regex = Const.PHONE_NUMBER_REGEX)
    private String phoneNumber;

    private String spam;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSpam(String spam) {
        this.spam = spam;
    }

    public RegistrationUserBean() {
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getPassword2() {
        return password2;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSpam() {
        return spam;
    }
}
