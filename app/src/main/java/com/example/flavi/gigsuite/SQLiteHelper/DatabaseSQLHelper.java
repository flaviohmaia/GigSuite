package com.example.flavi.gigsuite.SQLiteHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by junior on 23/05/17.
 */

public class DatabaseSQLHelper extends SQLiteOpenHelper {

    private static final String NAME_DB = "db_GigSuite";
    private static final int VERSION_DB = 3;

    //Tabelas
    public static final String TABLE_USUARIO = "tb_Usuario";
    public static final String TABLE_PERFIL = "tb_Perfil";
    public static final String TABLE_ENDERECO = "tb_Endereco";

    public DatabaseSQLHelper(Context context){
        super(context, NAME_DB, null, VERSION_DB);
    }

    public String tableUsuario(){
        return "CREATE TABLE tb_Usuario(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "email TEXT NOT NULL UNIQUE," +
                    "usuario TEXT NOT NULL UNIQUE," +
                    "senha TEXT NOT NULL," +
                    "status BOOLEAN NOT NULL," +
                    "FK_Perfil INTEGER," +
                    "CONSTRAINT FK_Perfil FOREIGN KEY (FK_Perfil) REFERENCES tb_Perfil (id)" +
                ");";
    }
    public String tablePerfil(){
        return  "CREATE TABLE tb_Perfil(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nome TEXT NOT NULL," +
                    "apelido TEXT NOT NULL," +
                    "categoria TEXT NOT NULL," +
                    "sub_Categoria TEXT," +
                    "tipo_Telefone TEXT NOT NULL," +
                    "telefone TEXT NOT NULL," +
                    "descricao TEXT," +
                    "site TEXT," +
                    "FK_Endereco INTEGER," +
                    "CONSTRAINT FK_Endereco FOREIGN KEY (FK_Endereco) REFERENCES tb_Endereco (id)" +
                ");";
    }
    public String tableEndereco(){
        return  "CREATE TABLE tb_Endereco(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "logradouro TEXT NOT NULL," +
                    "numero TEXT NOT NULL," +
                    "bairro TEXT NOT NULL," +
                    "cidade TEXT NOT NULL," +
                    "uf TEXT NOT NULL," +
                    "cep TEXT NOT NULL" +
                ");";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tableEndereco());
        db.execSQL(tablePerfil());
        db.execSQL(tableUsuario());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tb_Endereco; DROP TABLE IF EXISTS tb_Perfil; DROP TABLE IF EXISTS tb_Usuario;");
        onCreate(db);
    }
}
