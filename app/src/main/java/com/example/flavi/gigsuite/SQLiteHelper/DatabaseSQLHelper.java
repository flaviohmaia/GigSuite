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


    public DatabaseSQLHelper(Context context){
        super(context, NAME_DB, null, VERSION_DB);
    }

    public String tableUsuario(){
        return "CREATE TABLE tb_Usuario(" +
                    "idUsuario INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "email TEXT NOT NULL UNIQUE," +
                    "usuario TEXT NOT NULL UNIQUE," +
                    "senha TEXT NOT NULL," +
                    "status BOOLEAN NOT NULL," +
                    "idPerfil INTEGER," +
                    "CONSTRAINT FK_idPefil FOREIGN KEY (idPerfil) REFERENCES tb_Perfil (idPerfil)" +
                ");";
    }
    public String tablePerfil(){
        return  "CREATE TABLE tb_Perfil(" +
                    "idPefil INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nome TEXT NOT NULL," +
                    "apelido TEXT NOT NULL," +
                    "categoria TEXT NOT NULL," +
                    "sub_Categoria TEXT," +
                    "tipo_Telefone TEXT," +
                    "telefone TEXT UNIQUE," +
                    "descricao TEXT," +
                    "site TEXT," +
                    "idEndereco INTEGER," +
                    "CONSTRAINT FK_idEndereco FOREIGN KEY (idEndereco) REFERENCES tb_Enderco (idEndereco)" +
                ");";
    }
    public String tableEndereco(){
        return  "CREATE TABLE tb_Perfil(" +
                    "idEndereco INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "logradouro TEXT NOT NULL," +
                    "numero TEXT," +
                    "bairo TEXT," +
                    "cidade TEXT NOT NULL," +
                    "uf TEXT NOT NULL" +
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
