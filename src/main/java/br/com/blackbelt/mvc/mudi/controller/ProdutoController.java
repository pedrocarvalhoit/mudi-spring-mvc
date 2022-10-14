package br.com.blackbelt.mvc.mudi.controller;

import br.com.blackbelt.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.blackbelt.mvc.mudi.model.Produto;
import br.com.blackbelt.mvc.mudi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("pedido")//Todas as requisições para pedido serão mapeadas aqui
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("formulario")//Assim ficará /pedido/formulario
    public String formulario(RequisicaoNovoPedido requisicao){
        return "pedido/formulario";
    }

    @PostMapping("novo")//Esta classe mapea o cadastro
    public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result){//Anotação que garante a validação
        if(result.hasErrors()){//Garante que o formulário seja preenchido
            return "pedido/formulario";
        }

        Produto produto = requisicao.toPedido();//Passa os dados do pedido cadastrado para este pedido
        produtoRepository.save(produto);//Salva no db
        return "redirect:/home";
    }

}
