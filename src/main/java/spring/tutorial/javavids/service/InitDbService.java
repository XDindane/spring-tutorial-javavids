package spring.tutorial.javavids.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.tutorial.javavids.entity.Blog;
import spring.tutorial.javavids.entity.Item;
import spring.tutorial.javavids.entity.Role;
import spring.tutorial.javavids.entity.User;
import spring.tutorial.javavids.repository.BlogRepository;
import spring.tutorial.javavids.repository.ItemRepository;
import spring.tutorial.javavids.repository.RoleRepository;
import spring.tutorial.javavids.repository.UserRepository;

/**
 *
 */
@Transactional
@Service
public class InitDbService {
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private BlogRepository blogRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ItemRepository itemRepository;
    
    
    @PostConstruct
    public void init() {
        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        roleRepository.save(roleUser);
        
        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        roleRepository.save(roleAdmin);
        
        User userAdmin = new User();
        userAdmin.setName("admin");
        userAdmin.setPassword("admin");
        List<Role> roles = new ArrayList<Role>();
        roles.add(roleAdmin);
        roles.add(roleUser);
        userAdmin.setRoles(roles);
        userRepository.save(userAdmin);
        
        
        Blog blogJavavids = new Blog();
        blogJavavids.setName("Javavids");
        blogJavavids.setUrl("http://feeds.feedburner.com/javavids?format=xml");
        blogJavavids.setUser(userAdmin);
        blogRepository.save(blogJavavids);
        
        Item item1 = new Item();
        item1.setBlog(blogJavavids);
        item1.setTitle("first");
        item1.setLink("http://example.com");
        item1.setPublishedDate(new Date());
        itemRepository.save(item1);
        
        Item item2 = new Item();
        item2.setBlog(blogJavavids);
        item2.setTitle("second");
        item2.setLink("http://example-two.com");
        item2.setPublishedDate(new Date());
        itemRepository.save(item2);

        
    
    }
    
}
