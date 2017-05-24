package com.example.flavi.gigsuite.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.flavi.gigsuite.Entity.Usuario;
import com.example.flavi.gigsuite.SQLiteHelper.DatabaseSQLHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junior on 23/05/17.
 */

public class UsuarioDAO {

    private DatabaseSQLHelper helper;
    private SQLiteDatabase db;
    private ContentValues cv;
    private Cursor cursor;

    public UsuarioDAO(Context context){
        helper = new DatabaseSQLHelper(context);
    }

    private long insert(Usuario usuario){
        return 0;
    }

    private long update(Usuario usuario){
        return 0;
    }

    public long save(Usuario usuario){
        long retorno;
        return retorno = usuario.getId() == 0 ? insert(usuario) : update(usuario);
    }

    public long delete(Long id){
        return 0;
    }

    public List<Usuario> select(){
        List<Usuario> users = new ArrayList<Usuario>();

        return users;
    }
}
