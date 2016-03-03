package main.java.com.epam.preprod.kushnarenko.entity;

public enum Role {

    ADMIN("admin"), USER("user");

    private final String name;

    private Role(final String name) {
        this.name = name;
    }

    public String getText() {
        return this.name;
    }

}
