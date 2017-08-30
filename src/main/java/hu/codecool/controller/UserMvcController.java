package hu.codecool.controller;

import hu.codecool.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "/mvc/users")
@Controller
public class UserMvcController {

    private static final Logger LOG = LoggerFactory.getLogger(UserMvcController.class);

    @Autowired
    private UserService service;

    // Value has to be "" instead of "/" when the method should
    // handle the path in the @RequestMapping of the class.
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllUsers(Model model) {
        LOG.info("GET /users");
        model.addAttribute("users", service.getAllUsers());
        // In a @Controller a String return value refers to a view's name
        // which will get rendered as the result of a HTTP request.
        // Here "getSingleUser" will match the "all-users.jsp" view.
        return "all-users";
        // Also, take a look at the webapp/WEB-INF/app-servlet.xml, where the JSP
        // view resolver is mapped to the webapp/views/jsp folder (where the actual
        // JSP files are located.
    }

    @RequestMapping(value = "/{id:\\d+}", method = RequestMethod.GET)
    public ModelAndView getSingleUser(@PathVariable("id") Integer id) {
        LOG.info("GET users/{}", id);
        ModelAndView model = new ModelAndView();
        model.setViewName("single-user");
        model.addObject("user", service.getSingleUser(id));
        return model;
    }
}
