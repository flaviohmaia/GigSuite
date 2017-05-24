package com.example.flavi.gigsuite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;



public class ConsultaActivity extends AppCompatActivity {

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
}
