package br.com.blackbelt.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //Passa a ser um controler gerenciado pelo Spring
public class HelloController {

    @GetMapping("/hello") //Liga o método na view
    public String hello(Model model){
        model.addAttribute("nome", "Mundo"); //Cria variável acessível pela view
       return "Hello";
    }

}
