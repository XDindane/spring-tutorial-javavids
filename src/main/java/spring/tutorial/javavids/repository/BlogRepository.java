package spring.tutorial.javavids.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.tutorial.javavids.entity.Blog;

/**
 *
 */
public interface BlogRepository extends JpaRepository<Blog, Integer>{
    
}
