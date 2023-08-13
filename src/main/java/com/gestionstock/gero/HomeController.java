package com.gestionstock.gero;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String gohome(){
        return "index";
    }

    @GetMapping("index")
    public String gohome2(){
        return "index";
    }

    @GetMapping("/menulateral")
    public String menulat(){
        return "menulateral";
    }

   @GetMapping("/login")
    public String Login(){
        return "login";
    }

    /*@GetMapping("/logout")
    public String logout() {
        return "login";
    }*/

}
