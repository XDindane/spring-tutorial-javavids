package spring.tutorial.javavids.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import spring.tutorial.javavids.entity.Blog;
import spring.tutorial.javavids.entity.Item;
import spring.tutorial.javavids.entity.User;
import spring.tutorial.javavids.exception.RssException;
import spring.tutorial.javavids.repository.BlogRepository;
import spring.tutorial.javavids.repository.ItemRepository;
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

    @Autowired
    private ItemRepository itemRepository;
    
    
    
    @Autowired
    private RssService rssService;

    
    public void saveItems(Blog blog) {
        try {
            List<Item> items = rssService.getItems(blog.getUrl());
            for (Item item : items) {
                Item saved = itemRepository.findByBlogAndLink(blog, item.getLink());
                if(saved == null) {
                    item.setBlog(blog);
                    itemRepository.save(item);
                }
                
            }

        } catch (RssException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void save(Blog blog, String name) {
        User user = userRepository.findByName(name);
        blog.setUser(user);
        blogRepository.save(blog);
        saveItems(blog);

    }

    @PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
    public void delete(@P("blog") Blog blog) {
        blogRepository.delete(blog);

    }

    public Blog findOne(int id) {
        return blogRepository.findOne(id);
    }

}
