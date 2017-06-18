package com.example.flavi.gigsuite.model;

public class Usuario {

    private int id;
    private String email;
    private String usuario;
    private String senha;
    private boolean status;
    private Perfil perfil;


    //CONSTRUTORES
    public Usuario(){}

    public Usuario(int id, String email, String usuario, String senha, boolean status, Perfil perfil){
        this.id = id;
        this.email = email;
        this.usuario = usuario;
        this.senha = senha;
        this.status = status;
        this.perfil = perfil;
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

    public boolean getStatus() {
        return status;
    }
}
