package pl.mzuchnik.communicatorserver.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String getChat(Principal principal, Model model){
        String username = principal.getName();
        model.addAttribute("username", username);
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login-page";
    }


}
