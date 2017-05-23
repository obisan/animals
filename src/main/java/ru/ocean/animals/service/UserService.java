package ru.ocean.animals.service;

import ru.ocean.animals.model.Role;
import ru.ocean.animals.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

    List<Role>  getRoles();

    List<String> getUserRoles();
}
