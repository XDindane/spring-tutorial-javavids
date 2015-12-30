package spring.tutorial.javavids.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.tutorial.javavids.entity.Blog;
import spring.tutorial.javavids.entity.Item;
import spring.tutorial.javavids.entity.User;
import spring.tutorial.javavids.repository.BlogRepository;
import spring.tutorial.javavids.repository.ItemRepository;
import spring.tutorial.javavids.repository.UserRepository;

/**
 *
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private BlogRepository blogRepository;
    
    @Autowired
    private ItemRepository itemRepository;
    
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
            List<Item> items = itemRepository.findByBlog(blog);
            blog.setItems(items);
        }
        
        user.setBlogs(blogs);
        return user;
        
    }    
}
