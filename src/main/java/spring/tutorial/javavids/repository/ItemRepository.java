package spring.tutorial.javavids.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.tutorial.javavids.entity.Item;

/**
 *
 */
public interface ItemRepository extends JpaRepository<Item, Integer>{
    
}
