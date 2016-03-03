package main.java.com.epam.preprod.kushnarenko.entity;

public class Delivery {

    private Long id;

    private String name;

    public Delivery() {
    }

    public Delivery(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
