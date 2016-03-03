package ua.nure.kushnarenko.Task2.container;

import java.util.HashMap;

import ua.nure.kushnarenko.Task2.entity.User;

public class UserContainer {

    private final HashMap<String, User> container = new HashMap<>();

    public boolean add(User u) {
        return false;
    }

    public User find(String login) {
        return container.get(login);
    }

}
