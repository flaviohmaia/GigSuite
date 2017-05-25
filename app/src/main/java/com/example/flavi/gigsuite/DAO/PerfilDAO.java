package com.example.flavi.gigsuite.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.flavi.gigsuite.Entity.Perfil;
import com.example.flavi.gigsuite.Entity.Usuario;
import com.example.flavi.gigsuite.SQLiteHelper.DatabaseSQLHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junior on 23/05/17.
 */

public class PerfilDAO {

    private DatabaseSQLHelper helper;
    private SQLiteDatabase db;
    private ContentValues cv;
    private Cursor cursor;

    public PerfilDAO(Context context){
        helper = new DatabaseSQLHelper(context);
    }

    private long insert(Perfil perfil){
        db = helper.getWritableDatabase();
        cv = new ContentValues();

        long retorno = db.insert("tb_Perfil", null, cv);
        db.close();
        return retorno;
    }

    private long update(Perfil perfil){
        db = helper.getWritableDatabase();
        cv = new ContentValues();

        String where = "idPerfil = "+perfil.getId();


        long retorno = db.update("tb_Perfil", cv, where, null);
        db.close();
        return retorno;
    }

    public long save(Perfil perfil){
        long retorno = perfil.getId() == 0 ? insert(perfil) : update(perfil);
        return retorno;
    }
}
