package br.com.blackbelt.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/** Os alunos podem fazer solicitações (mudanças) de produtos que não estão na lista
 * Muitas vezes por questão de gosto, ou mesmo de logística. */
@Controller
@RequestMapping("/solicitacao")
public class SolicitacaoController {

    @GetMapping
    public String getFormularioParaSolicitacao(){
        return "solicitacao/home";
    }

}
