package ru.ocean.animals.dao;

import ru.ocean.animals.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}
