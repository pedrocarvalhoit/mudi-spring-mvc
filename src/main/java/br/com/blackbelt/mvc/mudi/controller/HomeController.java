package br.com.blackbelt.mvc.mudi.controller;

import br.com.blackbelt.mvc.mudi.model.Pedido;
import br.com.blackbelt.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController{

    @Autowired //Utiliza sem precisar instanciar
    PedidoRepository pedidoRepository;

    @GetMapping("/home")
    public String home(Model model){
        List<Pedido> pedidos= pedidoRepository.findAll();
        model.addAttribute("pedidos",pedidos);
        return"home";
    }

}
