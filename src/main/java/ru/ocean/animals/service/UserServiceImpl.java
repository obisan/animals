package ru.ocean.animals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ocean.animals.dao.RoleDao;
import ru.ocean.animals.dao.UserDao;
import ru.ocean.animals.model.Role;
import ru.ocean.animals.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1L));
        user.setRoles(roles);
        userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public List<Role> getRoles() {
        return this.roleDao.findAll();
    }

    @Override
    public List<String> getUserRoles() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
                .map(r -> r.getAuthority()).collect(Collectors.toList());
    }
}
