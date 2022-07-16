package ru.safonovroman.kata.crud.service;

import ru.safonovroman.kata.crud.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void add(User user);
    User getUser(Long id);
    List<User> listUsers();
    void update(User user);
    void delete(Long id);
}
