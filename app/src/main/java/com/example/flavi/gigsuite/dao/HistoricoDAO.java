package com.example.flavi.gigsuite.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.flavi.gigsuite.model.Historico;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junior on 26/05/17.
 */

public class HistoricoDAO {

    private DatabaseSQLHelper helper;
    private SQLiteDatabase db;
    private ContentValues cv;
    private Cursor cursor;

    public HistoricoDAO(Context context){
        helper = new DatabaseSQLHelper(context);
    }

    public long insert(Historico historico){
        db = helper.getWritableDatabase();
        cv = new ContentValues();
        cv.put("categoria", historico.getCategoria());
        cv.put("sub_Categoria", historico.getSub_Categoria());
        cv.put("uf", historico.getUf());
        cv.put("cidade", historico.getCidade());
        long retorno = db.insert(DatabaseSQLHelper.TABLE_Historico, null, cv);
        db.close();
        return retorno;
    }

    public List<Historico> selectHistory(){
        ArrayList<Historico> lista = new ArrayList<>();
        String[] campos = {"id", "categoria", "sub_Categoria", "uf", "cidade"};

        db = helper.getReadableDatabase();

        cursor = db.query(DatabaseSQLHelper.TABLE_Historico, campos, null, null, null, null, null);

        while(cursor.moveToNext()){
            Historico historico = new Historico();
            historico.setId(cursor.getInt(cursor.getColumnIndex("id")));
            historico.setCategoria(cursor.getString(cursor.getColumnIndex("categoria")));
            historico.setSub_Categoria(cursor.getString(cursor.getColumnIndex("sub_Categoria")));
            historico.setUf(cursor.getString(cursor.getColumnIndex("uf")));
            historico.setCidade(cursor.getString(cursor.getColumnIndex("cidade")));
            lista.add(historico);
        }
        cursor.close();
        db.close();
        return lista;
    }

    public long delete(int id){
        db = helper.getWritableDatabase();
        String where = "id = "+id;
        long retorno = db.delete(DatabaseSQLHelper.TABLE_Historico, where, null);
        db.close();
        return retorno;
    }


}
