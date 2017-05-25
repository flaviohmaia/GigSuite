package com.example.flavi.gigsuite.Entity;

import java.io.Serializable;

public class Perfil implements Serializable{

    private Long id;
    private String nome;
    private String apelido;
    private String categoria;
    private String sub_Categoria;
    private String tipo_Telefone;
    private String telefone;
    private String descricao;
    private String site;
    private Endereco endereco;

    //CONSTRUTORES
    public Perfil(){
        this.endereco = new Endereco();
    }

    public Perfil(String nome, String apelido, String categoria, String sub_Categoria, String tipo_Telefone, String telefone, String descricao, String site, Endereco endereco){
        this.nome = nome;
        this.apelido = apelido;
        this.categoria = categoria;
        this.sub_Categoria = sub_Categoria;

        this.tipo_Telefone = tipo_Telefone;
        this.telefone = telefone;
        this.descricao = descricao;
        this.site = site;
        this.endereco = endereco;
    }

    //GETTERS E SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSub_Categoria() {
        return sub_Categoria;
    }

    public void setSub_Categoria(String sub_Categoria) {
        this.sub_Categoria = sub_Categoria;
    }

    public String getTipo_Telefone() {
        return tipo_Telefone;
    }

    public void setTipo_Telefone(String tipo_Telefone) {
        this.tipo_Telefone = tipo_Telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
