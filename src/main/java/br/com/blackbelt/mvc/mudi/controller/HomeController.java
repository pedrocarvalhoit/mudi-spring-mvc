package br.com.blackbelt.mvc.mudi.controller;

import br.com.blackbelt.mvc.mudi.model.Pedido;
import br.com.blackbelt.mvc.mudi.model.StatusPedido;
import br.com.blackbelt.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/home")
public class HomeController{

    @Autowired //Utiliza sem precisar instanciar
    PedidoRepository pedidoRepository;

    @GetMapping
    public String home(Model model){
        List<Pedido> pedidos= pedidoRepository.findAll();//Lista os pedidos
        model.addAttribute("pedidos",pedidos);
        return"home";
    }

    @GetMapping("/{status}")//Garante o acesso pela digitação de qualquer status
    public String porStatus(@PathVariable("status") String status, Model model){
        List<Pedido> pedidos= pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
        model.addAttribute("pedidos",pedidos);
        return"home";
    }

    @ExceptionHandler(IllegalArgumentException.class)//Redireciona pra home em caso de requisição errada
    public String onError(){
        return "redirect:/home";
    }

}
