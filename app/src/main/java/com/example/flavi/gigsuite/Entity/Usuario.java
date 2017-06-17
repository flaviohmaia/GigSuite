package com.example.flavi.gigsuite.Entity;

import java.io.Serializable;

public class Usuario implements Serializable {

    private int id;
    private String email;
    private String usuario;
    private String senha;
    private boolean status;
    private Perfil perfil;
    /*private String nome;
    private String apelido;
    private String categoria;
    private String sub_Categoria;
    private String tipo_Telefone;
    private String telefone;
    private String descricao;
    private String site;
    private Endereco endereco;*/

    //CONSTRUTORES
    public Usuario(){
        //this.endereco = new Endereco();
        this.perfil = new Perfil();

    }

    //GETTERS E SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    /*public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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
    }*/
}
