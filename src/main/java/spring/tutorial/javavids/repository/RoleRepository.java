package spring.tutorial.javavids.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import spring.tutorial.javavids.entity.Role;

/**
 *
 */
public interface RoleRepository extends JpaRepository<Role, Integer>{
    
}
