package com.example.flavi.gigsuite.SQLiteHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by junior on 23/05/17.
 */

public class DatabaseSQLHelper extends SQLiteOpenHelper {

    private static final String NAME_DB = "db_GigSuite";
    private static final int VERSION_DB = 4;

    //Tabelas
    public static final String TABLE_Historico = "tb_Historico";

    public DatabaseSQLHelper(Context context){
        super(context, NAME_DB, null, VERSION_DB);
    }

    public String tableHistorico(){
        return  "CREATE TABLE tb_Historico(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "itemPesquisa TEXT" +
                ");";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tableHistorico());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tb_Historico;");
        onCreate(db);
    }
}
