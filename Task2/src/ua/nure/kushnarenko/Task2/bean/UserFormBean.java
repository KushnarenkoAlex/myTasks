package ua.nure.kushnarenko.Task2.bean;

import ua.nure.kushnarenko.Task2.validating.ValidatingAnno;

public class UserFormBean {

    @ValidatingAnno(error = "incorrectLogin", regex = "^.{5,}$")
    private String login;

    @ValidatingAnno(error = "incorrectLogin", regex = "^.{1,}$")
    private String fullName;

    @ValidatingAnno(error = "incorrectLogin", regex = "^(.)*@(.)*$")
    private String email;

    @ValidatingAnno(error = "incorrectLogin", regex = "^.{3,}$")
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
