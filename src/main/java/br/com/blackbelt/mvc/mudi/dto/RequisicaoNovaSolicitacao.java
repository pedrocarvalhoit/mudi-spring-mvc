package br.com.blackbelt.mvc.mudi.dto;

import br.com.blackbelt.mvc.mudi.model.Solicitacao;

public class RequisicaoNovaSolicitacao {

    private Long produtoId;
    private String motivoTroca;
    private String urlNovoProduto;

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long id) {
        this.produtoId = id;
    }

    public String getMotivoTroca() {
        return motivoTroca;
    }

    public void setMotivoTroca(String motivoTroca) {
        this.motivoTroca = motivoTroca;
    }

    public String getUrlNovoProduto() {
        return urlNovoProduto;
    }

    public void setUrlNovoProduto(String urlNovoProduto) {
        this.urlNovoProduto = urlNovoProduto;
    }

    public Solicitacao toSolicitacao(){
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setMotivoTroca(this.motivoTroca);
        solicitacao.setUrlNovoProduto(this.urlNovoProduto);

        return solicitacao;
    }

}
