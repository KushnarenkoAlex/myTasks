package main.java.com.epam.preprod.kushnarenko.entity;

import java.sql.Timestamp;
import java.util.Date;

public class User {

    private Integer id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phoneNumber;
    private Boolean spam;
    private String picture;
    private Role role;
    private Timestamp unblockingTime;
    private Integer unsuccessTriesCount;

    public User() {
    }

    public User(String firstName, String lastName, String password, String email, String phoneNumber, Boolean spam,
            String picture, Role role) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.spam = spam;
        this.picture = picture;
        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (phoneNumber == null) {
            if (other.phoneNumber != null)
                return false;
        } else if (!phoneNumber.equals(other.phoneNumber))
            return false;
        if (spam == null) {
            if (other.spam != null)
                return false;
        } else if (!spam.equals(other.spam))
            return false;
        return true;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPicture() {
        return picture;
    }

    public Role getRole() {
        return role;
    }

    public Boolean getSpam() {
        return spam;
    }

    public Timestamp getUnblockingTime() {
        return unblockingTime;
    }

    public Integer getUnsuccessTriesCount() {
        return unsuccessTriesCount;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
        result = prime * result + ((spam == null) ? 0 : spam.hashCode());
        return result;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setRole(String role) {
        switch (role) {
        case "admin":
            this.role = Role.ADMIN;
            break;
        default:
            this.role = Role.USER;
            break;
        }
    }

    public void setSpam(Boolean spam) {
        this.spam = spam;
    }

    public void setUnblockingTime(Timestamp unblockingTime) {
        this.unblockingTime = unblockingTime;
    }

    public void setUnsuccessTriesCount(Integer unsuccessTriesCount) {
        this.unsuccessTriesCount = unsuccessTriesCount;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
                + ", email=" + email + ", phoneNumber=" + phoneNumber + ", spam=" + spam + ", picture=" + picture
                + ", role=" + role + ", unblockingTime=" + new Date(unblockingTime.getTime()) + ", unsuccessTriesCount="
                + unsuccessTriesCount + "]";
    }

    public boolean isBlocked(Integer maxLoginTries) {
        if (unsuccessTriesCount >= maxLoginTries) {
            if (unblockingTime.after(new Date())) {
                return true;
            }
        }
        return false;
    }

}
