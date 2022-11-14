package br.com.blackbelt.mvc.mudi.model;

import javax.persistence.*;

@Entity
@Table(name = "solicitacoes")
public class Solicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String motivoTroca;
    private String sugestaoTroca;

    @OneToOne(
            fetch = FetchType.LAZY
    )
    private Produto produto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
