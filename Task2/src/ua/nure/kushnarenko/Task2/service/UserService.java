package ua.nure.kushnarenko.Task2.service;

import ua.nure.kushnarenko.Task2.entity.User;

public interface UserService {

    public boolean add(User u);

    public boolean delete(User u);

    public void update(User u);

    public User get(String login);

    public User login(String login, String password);

}
