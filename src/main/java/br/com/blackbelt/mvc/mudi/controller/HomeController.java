package br.com.blackbelt.mvc.mudi.controller;

import br.com.blackbelt.mvc.mudi.model.Produto;
import br.com.blackbelt.mvc.mudi.model.StatusProduto;
import br.com.blackbelt.mvc.mudi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController{

    @Autowired //Utiliza sem precisar instanciar
    ProdutoRepository produtoRepository;

    @GetMapping
    public String home(Model model, Principal principal){ //Principal ingeta os dados do usuário logado
        List<Produto> produtos = produtoRepository.findAllByUsuario(principal.getName());//Lista os pedidos por usuário
        model.addAttribute("produtos", produtos);
        return"home";
    }

    @GetMapping("/{status}")//Garante o acesso pela digitação de qualquer status
    public String porStatus(@PathVariable("status") String status, Model model){
        List<Produto> produtos = produtoRepository.findByStatus(StatusProduto.valueOf(status.toUpperCase()));
        model.addAttribute("produtos", produtos);
        model.addAttribute("status", status);//Acessa o valor do Estado do Pedido
        return"home";
    }

    @ExceptionHandler(IllegalArgumentException.class)//Exception que cuida da digitação errada
    public String onError(){
        return "redirect:/home";//Redireciona pra home em caso de requisição errada
    }

}
