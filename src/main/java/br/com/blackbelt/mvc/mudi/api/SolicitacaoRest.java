package br.com.blackbelt.mvc.mudi.api;

import br.com.blackbelt.mvc.mudi.dto.RequisicaoNovaSolicitacao;
import br.com.blackbelt.mvc.mudi.model.Produto;
import br.com.blackbelt.mvc.mudi.model.Solicitacao;
import br.com.blackbelt.mvc.mudi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/solicitacao")
public class SolicitacaoRest {

    @Autowired
    private ProdutoRepository produtoRepository;

    //Spring pega os dados da requisição
    @PostMapping
    //REQUESTBODY pega os dados da requisicao
    public Solicitacao criaSolicitacao(@RequestBody RequisicaoNovaSolicitacao requisicao){
        Optional<Produto> produtoBuscado = produtoRepository.findById(requisicao.getProdutoId());
        if(!produtoBuscado.isPresent()){
            return null;
        }
        //Recupera o produto
        Produto produto = produtoBuscado.get();
        //Adiciona solicitação no produto
        Solicitacao nova = requisicao.toSolicitacao();
        nova.setProduto(produto);
        produto.setSolicitacao(nova);
        produtoRepository.save(produto);

        return nova;
    }

}
