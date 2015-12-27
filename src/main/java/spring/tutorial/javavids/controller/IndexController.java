
package spring.tutorial.javavids.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author denis
 */
@Controller
public class IndexController {
    
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
