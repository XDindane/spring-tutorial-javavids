package spring.tutorial.javavids.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.tutorial.javavids.entity.Blog;
import spring.tutorial.javavids.entity.User;
import spring.tutorial.javavids.repository.BlogRepository;
import spring.tutorial.javavids.repository.UserRepository;

/**
 *
 */
@Service
public class BlogService {
    
    @Autowired
    private BlogRepository blogRepository;
    
    @Autowired
    private UserRepository userRepository;
    public void save(Blog blog, String name) {
        User user = userRepository.findByName(name);
        blog.setUser(user);
        blogRepository.save(blog);
        
    }

    public void delete(int id) {
        blogRepository.delete(id);
        
        
    }
    
}
