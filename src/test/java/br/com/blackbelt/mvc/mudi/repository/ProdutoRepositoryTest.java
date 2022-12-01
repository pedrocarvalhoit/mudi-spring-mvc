package br.com.blackbelt.mvc.mudi.repository;

import br.com.blackbelt.mvc.mudi.model.Produto;
import br.com.blackbelt.mvc.mudi.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Para o Teste de repository é ideal utilizar o h2
 * configurando no proprerties.test
 */
@DataJpaTest
class ProdutoRepositoryTest {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void populaDados(){
        User user = new User();
        user.setUsername("pedro");
        userRepository.save(user);

        Produto produto = new Produto();
        produto.setNomeProduto("Máquina de glúteo");
        produto.setUrlProduto("wwww.afdfsdfsdf.com.br");
        produto.setValorNegociado(new BigDecimal(200));
        produto.setUser(user);

        Produto produto2 = new Produto();
        produto2.setNomeProduto("Máquina de ombro");
        produto2.setUrlProduto("wwww.22222.com.br");
        produto2.setValorNegociado(new BigDecimal(333));
        produto2.setUser(user);
        produtoRepository.save(produto);
        produtoRepository.save(produto2);
    }

    @Test
    void deveriaRetornarTodosProdutos(){
        //given

        //when
        List<Produto> listaProdutos = produtoRepository.findAll();
        //then
        //1
        Assert.notEmpty(listaProdutos);
        //2
        assertThat(listaProdutos.get(0).getNomeProduto()).isEqualTo("Máquina de glúteo");
    }

    @Test
    void deveriaRetornarProdutosPeloUsuario(){
        //given

        //when
        List<Produto> listaProdutos = produtoRepository.findAllByUsuario("pedro");
        //then
        Assert.notEmpty(listaProdutos );
        assertThat(listaProdutos.get(0).getNomeProduto()).isEqualTo("Máquina de glúteo");
    }

}