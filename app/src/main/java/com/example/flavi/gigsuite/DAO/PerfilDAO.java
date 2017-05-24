package com.example.flavi.gigsuite.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.flavi.gigsuite.Entity.Perfil;
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
        return 0;
    }

    private long update(Perfil perfil){
        return 0;
    }

    public long save(Perfil perfil){
        long retorno;
        return retorno = perfil.getId() == 0 ? insert(perfil) : update(perfil);
    }

    public long delete(Long id){
        return 0;
    }

    public List<Perfil> select(){
        List<Perfil> users = new ArrayList<Perfil>();

        return users;
    }

}
