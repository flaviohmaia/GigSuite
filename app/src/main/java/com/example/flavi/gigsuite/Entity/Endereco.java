package com.example.flavi.gigsuite.Entity;

/**
 * Created by junior on 24/05/17.
 */

public class Endereco {

    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String numero;

    //CONSTRUTORES
    public Endereco(){

    }

    public Endereco(String cep, String logradouro, String bairro, String cidade, String numero){
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numero = numero;
    }

    //GETTERS E SETTERS
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
