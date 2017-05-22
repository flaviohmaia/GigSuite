package com.example.flavi.gigsuite.SQLiteHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GigSuiteSQLiteHelper extends SQLiteOpenHelper{

    public static final String NOME_BANCO = "gigSuite";
    public static final int VERSAO_BANCO = 1;

    public static final String TABELA_CLIENTE = "tb_cliente";
    public static final String COLUNA_ID_CLIENTE = "id_cliente";
    public static final String COLUNA_NOME = "nome";
    public static final String COLUNA_APELIDO = "apelido";
    public static final String COLUNA_CPF = "cpf";
    public static final String COLUNA_EMAIL = "email";
    public static final String COLUNA_TELEFONE = "telefone";
    public static final String COLUNA_DESCRICAO = "descricao";
    public static final String COLUNA_CATEGORIA = "categoria";

    public GigSuiteSQLiteHelper(Context context) {

        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE" + TABELA_CLIENTE+ "("
                + COLUNA_ID_CLIENTE + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUNA_NOME + "TEXT,"
                + COLUNA_APELIDO + "TEXT,"
                + COLUNA_CATEGORIA + "TEXT,"
                + COLUNA_CPF + "TEXT,"
                + COLUNA_DESCRICAO + "TEXT,"
                + COLUNA_EMAIL + "TEXT,"
                + COLUNA_TELEFONE + "TEXT"
                + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABELA_CLIENTE);
        onCreate(db);
    }
}
