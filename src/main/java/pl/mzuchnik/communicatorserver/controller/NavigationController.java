package pl.mzuchnik.communicatorserver.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mzuchnik.communicatorserver.entity.User;
import pl.mzuchnik.communicatorserver.repository.UserRepo;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class NavigationController {

    private UserRepo userRepo;
    private PasswordEncoder encoder;

    @Autowired
    public NavigationController(UserRepo userRepo, PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    @RequestMapping("/")
    public String getChat(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("username", username);
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login-page";
    }


    @GetMapping("/sign-in")
    public String getSignInPage(Model model) {
        model.addAttribute("user", new User());
        return "sign-in";
    }

    @PostMapping("/sign-in")
    public String processSignInPage(@ModelAttribute("user") @Valid User userReg, Errors errors) {
        if (errors.hasErrors()) {
            return "sign-in";
        }
        User user = new User(userReg.getUsername(), encoder.encode(userReg.getPassword()), userReg.getEmail());
        userRepo.save(user);

        return "redirect:/";
    }

}
