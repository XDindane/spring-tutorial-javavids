package spring.tutorial.javavids.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
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
@Service
@Transactional
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private BlogRepository blogRepository;
    
    @Autowired
    private ItemRepository itemRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(int id) {
        return userRepository.findOne(id);
    }

    @Transactional
    public User findOneWithBlog(int id) {
        User user = findOne(id);
        List<Blog> blogs = blogRepository.findByUser(user);
        for (Blog blog : blogs) {
            List<Item> items = itemRepository.findByBlog(blog, new PageRequest(0, 10, Sort.Direction.DESC, "publishedDate"));
            blog.setItems(items);
        }
        
        user.setBlogs(blogs);
        return user;
        
    }    

    public void save(User user) {
        user.setEnabled(true);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        
        List<Role> roles = new ArrayList<Role>();
        roles.add(roleRepository.findByName("ROLE_USER"));
        user.setRoles(roles);
        
        userRepository.save(user);
    }

    
    public User findOneWithBlog(String name) {
        User user = userRepository.findByName(name);
        return findOneWithBlog(user.getId());
    }

    public void delete(int id) {
        userRepository.delete(id);
    }

    public User findOne(String username) {
        return userRepository.findByName(username);
    }
}
