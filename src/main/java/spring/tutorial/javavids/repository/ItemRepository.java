package spring.tutorial.javavids.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import spring.tutorial.javavids.entity.Blog;
import spring.tutorial.javavids.entity.Item;

/**
 *
 */
public interface ItemRepository extends JpaRepository<Item, Integer>{
    
    List<Item> findByBlog(Blog blog, Pageable pageable);
    
}
