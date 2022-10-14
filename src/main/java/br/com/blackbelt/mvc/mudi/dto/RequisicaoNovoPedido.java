package br.com.blackbelt.mvc.mudi.dto;

import br.com.blackbelt.mvc.mudi.model.Produto;
import br.com.blackbelt.mvc.mudi.model.StatusProduto;

import javax.validation.constraints.NotBlank;

public class RequisicaoNovoPedido {

    //Os atributos precisam ter o mesmo nome do NAME dos INPUTS

    @NotBlank //Esta anotação aceita o cadastro apenas com preenchimento
    private String nomeProduto;
    @NotBlank
    private String urlProduto;
    @NotBlank
    private String urlImagem;
    private String descricao;

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

    public Produto toPedido() {
        Produto produto = new Produto();
        produto.setDescricao(descricao);
        produto.setNomeProduto(nomeProduto);
        produto.setUrlImagem(urlImagem);
        produto.setUrlProduto(urlProduto);
        produto.setStatus(StatusProduto.MUSCULACAO);
        return produto;
    }
}
