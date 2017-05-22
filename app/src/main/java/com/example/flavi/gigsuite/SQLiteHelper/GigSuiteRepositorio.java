package com.example.flavi.gigsuite.SQLiteHelper;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.flavi.gigsuite.Entity.Cliente;

public class GigSuiteRepositorio {

    private GigSuiteSQLiteHelper helper;
    private SQLiteDatabase db;

    public GigSuiteRepositorio(Context context){

        helper = new GigSuiteSQLiteHelper(context);
    }

    public String inserir(String nome, String apelido, String categoria, String cpf, String descricao, String email, String telefone){
        db = helper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(GigSuiteSQLiteHelper.COLUNA_NOME, nome);
        cv.put(GigSuiteSQLiteHelper.COLUNA_APELIDO, apelido);
        cv.put(GigSuiteSQLiteHelper.COLUNA_CATEGORIA, categoria);
        cv.put(GigSuiteSQLiteHelper.COLUNA_CPF, cpf);
        cv.put(GigSuiteSQLiteHelper.COLUNA_DESCRICAO, descricao);
        cv.put(GigSuiteSQLiteHelper.COLUNA_EMAIL, email);
        cv.put(GigSuiteSQLiteHelper.COLUNA_TELEFONE, telefone);

        long id = db.insert(GigSuiteSQLiteHelper.TABELA_CLIENTE, null, cv);
        db.close();

        if(id == -1) {
            return "Erro ao cadastrar. Por favor tente novamente";
        } else{
            return "Cadastrado com sucesso. Obrigado.";
        }
    }

    public Cursor carregarDados(){
        Cursor cursor;
        String[] campos = {helper.COLUNA_ID_CLIENTE, helper.COLUNA_NOME, helper.COLUNA_APELIDO, helper.COLUNA_CATEGORIA, helper.COLUNA_CPF, helper.COLUNA_DESCRICAO, helper.COLUNA_EMAIL, helper.COLUNA_TELEFONE};

        db = helper.getReadableDatabase();
        cursor = db.query(helper.TABELA_CLIENTE, campos, null, null, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}
