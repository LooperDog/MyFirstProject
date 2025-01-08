package web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String allUsers(Model model) {
        List<User> users = userService.findUsers();
        model.addAttribute("users", users);
        return "list";
    }

    @GetMapping("/new")
    public String createUserForm(@ModelAttribute("user") User user) {
        System.out.println("new user");
        return "new";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") @Valid User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam(value = "id", required = false) long id) {
        logger.info("id: {}", id);
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String editUserForm(@RequestParam(value = "id", required = false) long id, Model model) {
        Optional<User> userById = userService.findUserById(id);
        model.addAttribute("user", userById);
        if (userById.isPresent()) {
            model.addAttribute("user", userById.get());
            return "edit";
        } else {
            return "redirect:/users";
        }
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        userService.saveUser(user);
        return "redirect:/users";
    }
}
