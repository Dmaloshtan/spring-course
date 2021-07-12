package org.home.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginContoller {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){
        return "fancy-login";
    }

    //add request mapping for /access - denied

    @GetMapping("/access-denied")
    public String showAcessDenied(){
        return "access-denied";
    }
}
