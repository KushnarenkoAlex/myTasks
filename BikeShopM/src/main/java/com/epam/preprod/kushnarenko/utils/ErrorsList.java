package main.java.com.epam.preprod.kushnarenko.utils;

import java.util.HashMap;

public class ErrorsList {

    private HashMap<String, String> errors;

    public ErrorsList() {
        errors = new HashMap<>();
    }

    public void put(String key, String value) {
        if (errors.get(key) == null) {
            errors.put(key, "");
        }
        errors.put(key, errors.get(key) + value + System.lineSeparator());
    }

    public HashMap<String, String> get() {
        return errors;
    }

    public String get(String key) {
        return errors.get(key);
    }

    public int size() {
        return errors.size();
    }
}
