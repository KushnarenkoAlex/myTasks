package ua.nure.serdyuk.SummaryTask4.entity;

public enum Role {

	USER(0), ADMIN(1);

	Role(long id) {
		this.id = id;
	}

	private long id;

	public static Role get(long id) {
		for (Role item : values()) {
			if (item.id == id) {
				return item;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Role [name=" + name() + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
