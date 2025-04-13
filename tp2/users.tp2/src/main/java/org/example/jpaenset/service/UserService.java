package org.example.jpaenset.service;

import org.example.jpaenset.entities.Role;
import org.example.jpaenset.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);

    User findUserByUsername(String username);
    Role findRoleByRolename(String rolename);

    void addRoleToUser(String username, String rolename);
    User authenticate(String username, String password);
}
