package com.jrp.cra.controller;

import com.jrp.cra.dao.IUserAccountRepository;
import com.jrp.cra.entites.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    IUserAccountRepository accountRepo;

    @GetMapping("/register")
    public String register(Model model){
        UserAccount userAccount = new UserAccount();
        model.addAttribute("userAccount",userAccount);
        return "security/register";
    }

    @PostMapping("register/save")
    public String saveUser(Model model, UserAccount user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        accountRepo.save(user);
        return "redirect:/";
    }
}
