package com.example.springtest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/list")
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "list";
    }
    @GetMapping("/form")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }
    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users/list";
    }
    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        userService.getUserById(id).ifPresent(user ->
                model.addAttribute("user", user));
        return "form";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users/list";
    }
}
