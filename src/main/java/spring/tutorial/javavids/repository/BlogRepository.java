package spring.tutorial.javavids.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import spring.tutorial.javavids.entity.Blog;
import spring.tutorial.javavids.entity.User;

/**
 *
 */
public interface BlogRepository extends JpaRepository<Blog, Integer>{
    
    List<Blog> findByUser(User user);
    
}
