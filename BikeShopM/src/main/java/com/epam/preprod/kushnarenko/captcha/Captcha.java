package main.java.com.epam.preprod.kushnarenko.captcha;

public class Captcha {

	private String id;
	private String value;
	private long time;

	public Captcha(String id, String value, long time) {
		super();
		this.id = id;
		this.value = value;
		this.time = time;
	}

	public String getId() {
		return id;
	}

	public String getValue() {
		return value;
	}

	public long getTime() {
		return time;
	}

}
