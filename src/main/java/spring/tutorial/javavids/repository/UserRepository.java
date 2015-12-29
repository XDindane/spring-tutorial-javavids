package spring.tutorial.javavids.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.tutorial.javavids.entity.User;

/**
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>{
    
}
