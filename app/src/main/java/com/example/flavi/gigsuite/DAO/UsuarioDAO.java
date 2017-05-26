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
        db = helper.getWritableDatabase();
        cv = new ContentValues();

        cv.put("email", usuario.getEmail());
        cv.put("usuario", usuario.getUsuario());
        cv.put("senha", usuario.getSenha());
        cv.put("status", true);
        //TODO: GERAR PERFIL
        //TODO: GERAR ENDERECO DO PERFIL
        cv.put("idPerfil", usuario.getPerfil().getId());

        long retorno = db.insert(DatabaseSQLHelper.TABLE_USUARIO, null, cv);
        db.close();

        return retorno;
    }

    private long update(Usuario usuario){
        db = helper.getWritableDatabase();
        cv = new ContentValues();

        String where = "idUsuario = "+usuario.getId();

        cv.put("email", usuario.getEmail());
        cv.put("senha", usuario.getSenha());

        long retorno = db.update(DatabaseSQLHelper.TABLE_USUARIO, cv, where, null);
        db.close();

        return retorno;
    }

    public long save(Usuario usuario){
        long retorno = usuario.getId() == 0 ? insert(usuario) : update(usuario);
        return retorno;
    }

    public long delete(Long id){
        db = helper.getWritableDatabase();
        cv = new ContentValues();

        String where = "idUsuario = "+id;

        cv.put("status", false);

        long retorno = db.update(DatabaseSQLHelper.TABLE_USUARIO, cv, where, null);
        db.close();

        return retorno;
    }
}
