package spring.tutorial.javavids.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        userAdmin.setEnabled(true);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userAdmin.setPassword(encoder.encode("admin"));
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
    }
    
}
