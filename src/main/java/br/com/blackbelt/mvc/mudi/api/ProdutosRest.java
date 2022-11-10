package br.com.blackbelt.mvc.mudi.api;

import br.com.blackbelt.mvc.mudi.model.Produto;
import br.com.blackbelt.mvc.mudi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

/**Este RestController devolve por default as informação solicitadas em JSON */
@RestController
@RequestMapping("/api/produtos")
public class ProdutosRest {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("meusProdutos")
    public List<Produto> getProdutosUsuario(Model model, Principal principal){
        return produtoRepository.findAllByUsuario(principal.getName());
    }

//    @GetMapping("meusProdutos")
//    public List<Produto> getProdutosMusculacao(){
//        Sort sort = Sort.by("nomeProduto").ascending();
//        PageRequest page = PageRequest.of(0, 5, sort);
//        return produtoRepository.findByStatus(StatusProduto.MUSCULACAO, page);
//    }
}
