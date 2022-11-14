package br.com.blackbelt.mvc.mudi.dto;

import br.com.blackbelt.mvc.mudi.model.Solicitacao;

public class RequisicaoNovaSolicitacao {

    private Long produtoId;
    private String motivoTroca;
    private String sugestaoTroca;

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

    public String getSugestaoTroca() {
        return sugestaoTroca;
    }

    public void setSugestaoTroca(String sugestaoTroca) {
        this.sugestaoTroca = sugestaoTroca;
    }

    public Solicitacao toSolicitacao(){
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setMotivoTroca(this.motivoTroca);
        solicitacao.setSugestaoTroca(this.sugestaoTroca);

        return solicitacao;
    }

}
