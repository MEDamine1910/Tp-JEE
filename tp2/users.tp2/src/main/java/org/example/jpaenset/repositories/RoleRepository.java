package org.example.jpaenset.repositories;

import org.example.jpaenset.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRolename(String rolename);
}
