package hu.codecool.controller;

import hu.codecool.model.User;
import hu.codecool.repository.UserRepository;
import hu.codecool.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/rest/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
// A @RestController = @Controller + @ResponseBody
// If a class/method is annotated with the @ResponseBody annotation
// then the methods' result values will be sent back to clients
// as is (serialized according to the MIME-type (which is JSON by default)
public class UserRestController {

    private static final Logger LOG = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    private UserService service;

    // Value has to be "" instead of "/" when the method should
    // handle the path in the @RequestMapping of the class.
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        LOG.info("GET /users");
        return service.getAllUsers();
    }

    @RequestMapping(value = "/{id:\\d+}", method = RequestMethod.GET)
    public User getSingleUser(@PathVariable("id") Integer id) {
        LOG.info("GET /users/{}", id);
        return service.getSingleUser(id);
    }
}
