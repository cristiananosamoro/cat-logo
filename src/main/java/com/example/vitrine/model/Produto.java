package com.example.vitrine.model;

import java.math.BigDecimal;


public class Produto {
    private Long id;
    private String name;
    private String descricao;
    private BigDecimal preco;
    private String urlImagem;
    
    public Produto(Long id, String name, String descricao, BigDecimal preco, String urlImagem){
        this.id = id;
        this.name = name;
        this.descricao = descricao;
        this.preco = preco;
        this.urlImagem = urlImagem;
    }

    public Long getId(){
        return id;
    }

    public void setId(){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }


}
