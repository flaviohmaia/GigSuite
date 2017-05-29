package com.example.flavi.gigsuite;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.flavi.gigsuite.Entity.Perfil;


public class ConsultaActivity extends AppCompatActivity implements ListagemFragment.AoClicarNoPerfil {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        //GigSuiteRepositorio g = new GigSuiteRepositorio(getBaseContext());
        //Cursor cursor = g.carregarDados();

        //String[] nomeCampos = new String[]{GigSuiteSQLiteHelper.COLUNA_ID_CLIENTE, GigSuiteSQLiteHelper.COLUNA_NOME};
        //int[] idViews = new int[]{R.id.idCliente, R.id.nomeCliente};

        //SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(), R.layout.activity_consulta, cursor, nomeCampos, idViews, 0);

        //lista = (ListView) findViewById(R.id.listView);
        //lista.setAdapter(adapter);
    }


    @Override
    public void clicouNoPerfil(Perfil perfil) {
        Intent intent = new Intent(this, ConsultaDetalheActivity.class);
        intent.putExtra(ConsultaDetalheActivity.EXTRA_PERFIL, perfil);
        startActivity(intent);
    }
}
