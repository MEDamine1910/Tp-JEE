package org.example.jpaenset.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.jpaenset.entities.Role;
import org.example.jpaenset.entities.User;
import org.example.jpaenset.repositories.RoleRepository;
import org.example.jpaenset.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;


    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {

        return roleRepository.save(role);
    }

    @Override
    public User findUserByUsername(String username) {

        return userRepository.findByUsername(username);
    }

    @Override
    public Role findRoleByRolename(String rolename) {

        return roleRepository.findByRolename(rolename);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        User user=findUserByUsername(username);
        Role role=findRoleByRolename(rolename);
        if(user.getRoles()!=null) {
            user.getRoles().add(role);
            role.getUsers().add(user);
        }
        //userRepository.save(user);
    }

    @Override
    public User authenticate(String username, String password) {
        User user=userRepository.findByUsername(username);
        if(user==null) throw new RuntimeException("Bad Credentials");
        if(user.getPassword().equals(password)) {
            return user;
        }
        throw new RuntimeException("Bad Credentials");
    }
}
