package com.example.flavi.gigsuite.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.flavi.gigsuite.Entity.Perfil;
import com.example.flavi.gigsuite.SQLiteHelper.DatabaseSQLHelper;

/**
 * Created by junior on 24/05/17.
 */

public class EnderecoDAO {

    private DatabaseSQLHelper helper;
    private SQLiteDatabase db;
    private ContentValues cv;
    private Cursor cursor;

    public EnderecoDAO(Context context){
        helper = new DatabaseSQLHelper(context);
    }

    private long insert(Perfil perfil){
        db = helper.getWritableDatabase();
        cv = new ContentValues();

        long retorno = db.insert("tb_Endereco", null, cv);
        db.close();
        return retorno;
    }

    private long update(Perfil perfil){
        db = helper.getWritableDatabase();
        cv = new ContentValues();

        String where = "idEndereco = "+perfil.getId();


        long retorno = db.update("tb_Endereco", cv, where, null);
        db.close();
        return retorno;
    }

    public long save(Perfil perfil){
        long retorno = perfil.getId() == 0 ? insert(perfil) : update(perfil);
        return retorno;
    }

}
