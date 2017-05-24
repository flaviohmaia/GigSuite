package com.example.flavi.gigsuite.Entity;

import java.io.Serializable;

public class Cliente implements Serializable{

    private Long id;
    private String nome;
    private String apelido;
    private String cpf;
    private String email;
    private String categoria;
    private String telefone;
    private String descricao;


    public Cliente( Long id, String nome, String apelido, String cpf, String email, String categoria, String telefone, String descricao){
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.cpf = cpf;
        this.email = email;
        this.categoria = categoria;
        this.telefone = telefone;
        this.descricao = descricao;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
}
