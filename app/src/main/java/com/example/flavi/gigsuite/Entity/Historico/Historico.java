package com.example.flavi.gigsuite.Entity.Historico;

/**
 * Created by junior on 27/05/17.
 */

public class Historico {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Historico(){

    }

    private int id;
    private String categoria;
    private String sub_Categoria;
    private String uf;
    private String cidade;

}
