package spring.tutorial.javavids.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import spring.tutorial.javavids.entity.Item;
import spring.tutorial.javavids.repository.ItemRepository;

/**
 *
 */
@Service
public class ItemService {
    
    @Autowired
    private ItemRepository itemRepository;
    
    
    public List<Item> getItems() {
        return itemRepository.findAll(new PageRequest(0,20, Sort.Direction.DESC, "publishedDate")).getContent();
    }
    
}
