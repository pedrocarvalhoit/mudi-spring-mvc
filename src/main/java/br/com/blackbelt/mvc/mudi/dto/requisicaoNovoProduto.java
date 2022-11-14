package br.com.blackbelt.mvc.mudi.dto;

import br.com.blackbelt.mvc.mudi.model.Produto;
import br.com.blackbelt.mvc.mudi.model.StatusProduto;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class requisicaoNovoProduto {

    //Os atributos precisam ter o mesmo nome do NAME dos INPUTS

    @NotBlank //Esta anotação aceita o cadastro apenas com preenchimento
    private String nomeProduto;
    @NotBlank
    private BigDecimal valorNegociado;
    @NotBlank
    private String urlProduto;
    @NotBlank
    private String urlImagem;
    private String descricao;
    private StatusProduto status;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public void setUrlProduto(String urlProduto) {
        this.urlProduto = urlProduto;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusProduto getStatus() {
        return status;
    }

    public void setStatus(StatusProduto status) {
        this.status = status;
    }

    public BigDecimal getValorNegociado() {
        return valorNegociado;
    }

    public void setValorNegociado(BigDecimal valorNegociado) {
        this.valorNegociado = valorNegociado;
    }

    public Produto toPedido() {
        Produto produto = new Produto();
        produto.setDescricao(descricao);
        produto.setValorNegociado(valorNegociado);
        produto.setNomeProduto(nomeProduto);
        produto.setUrlImagem(urlImagem);
        produto.setUrlProduto(urlProduto);
        produto.setStatus(status);
        return produto;
    }
}
