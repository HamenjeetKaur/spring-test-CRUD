package com.example.springtest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
@RequestMapping("/employee")
public class EuserController {
    @Autowired
    private EuserService userService;
    @GetMapping("/list")
    public String listUsers(Model model) {
        List<Euser> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "elist";
    }
    @GetMapping("/form")
    public String addEmployeeForm(Model model) {
        model.addAttribute("user", new Euser());
        return "eform";
    }
    @PostMapping("/save")
    public String saveUser(@ModelAttribute Euser user) {
        userService.saveUser(user);
        return "redirect:/employee/list";
    }
    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        userService.getUserById(id).ifPresent(user ->
                model.addAttribute("user", user));
        return "eform";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/employee/list";
    }
}
