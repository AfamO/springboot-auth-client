/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okta.spring.SpringBootOAuthClient;

import java.security.Principal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author afam.okonkwo
 */
@Controller
public class WebController {
    @RequestMapping("/securedPage")
    public String securedPage(Model model, Principal principal) {
        System.out.println("Request Made for user "+principal.toString());
        
        String email = principal.getName() + "@gmail.com";
        
        UserProfile profile = new UserProfile();
        profile.setEmail(email);
        profile.setName(principal.getName());
        model.addAttribute("authentication", profile);
        return "securedPage";
    }
    @RequestMapping("/")
    public String index(Model model, Principal principal) {
        
        return "index";
    }
}
