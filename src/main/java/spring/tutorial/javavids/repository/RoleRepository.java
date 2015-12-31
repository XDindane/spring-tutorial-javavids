package spring.tutorial.javavids.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.tutorial.javavids.entity.Role;

/**
 *
 */
public interface RoleRepository extends JpaRepository<Role, Integer>{

    public Role findByName(String role_user);
    
}
