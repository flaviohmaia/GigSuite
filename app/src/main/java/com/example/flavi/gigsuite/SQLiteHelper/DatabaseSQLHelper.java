package com.example.flavi.gigsuite.SQLiteHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by junior on 23/05/17.
 */

public class DatabaseSQLHelper extends SQLiteOpenHelper {

    private static final String NAME_DB = "db_GigSuite";
    private static final int VERSION_DB = 2;


    public DatabaseSQLHelper(Context context){
        super(context, NAME_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE tb_Usuario(" +
                            "idUsuario INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "nome TEXT NOT NULL," +
                            "email TEXT NOT NULL UNIQUE," +
                            "usuario TEXT NOT NULL UNIQUE," +
                            "senha TEXT NOT NULL," +
                            "status BOOLEAN NOT NULL," +
                            "idPerfil INTEGER," +
                            "CONSTRAINT FK_idPefil FOREIGN KEY (idPerfil) REFERENCES tb_Perfil (idPerfil)" +
                        ");" +
                "CREATE TABLE tb_Perfil(" +
                            "idPefil INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "apelido TEXT NOT NULL," +
                            "cpf TEXT NOT NULL UNIQUE," +
                            "categoria TEXT NOT NULL," +
                            "telefone TEXT NOT NULL UNIQUE," +
                            "descricao TEXT NOT NULL" +
                        ");"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tb_Usuario; DROP TABLE IF EXISTS tb_Cliente; ");
        onCreate(db);
    }
}
