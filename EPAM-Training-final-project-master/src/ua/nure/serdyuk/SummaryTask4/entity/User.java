package ua.nure.serdyuk.SummaryTask4.entity;

import java.io.Serializable;

import ua.nure.serdyuk.SummaryTask4.constants.Const;
import ua.nure.serdyuk.SummaryTask4.validation.Validation;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

	@Validation(regex = Const.REGEX_EMAIL, message = "message.email_not_valid")
	private String email;

	@Validation(regex = Const.REGEX_PASSWORD, message = "message.password_not_valid")
	private String password;

	@Validation(regex = Const.REGEX_NAME, required = false, message = "message.name_not_valid")
	private String firstName;

	@Validation(regex = Const.REGEX_NAME, required = false, message = "message.name_not_valid")
	private String lastName;
	
	private String documentTag;

	private Role role;

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", documentTag=" + documentTag + ", role=" + role + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getDocumentTag() {
		return documentTag;
	}

	public void setDocumentTag(String documentTag) {
		this.documentTag = documentTag;
	}
}
