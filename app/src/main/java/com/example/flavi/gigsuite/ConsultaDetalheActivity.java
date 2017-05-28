package com.example.flavi.gigsuite;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.flavi.gigsuite.Entity.Perfil;

public class ConsultaDetalheActivity extends AppCompatActivity {

    public static final String EXTRA_PERFIL = "perfil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_detalhe);

        if(savedInstanceState == null){
            Intent intent = getIntent();
            Perfil perfil = (Perfil) intent.getSerializableExtra(EXTRA_PERFIL);

            ListDetalheFragment fragment = ListDetalheFragment.novaInstancia(perfil);

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.consultaDetalhe, fragment, ListDetalheFragment.TAG_DETALHE);
            fragmentTransaction.commit();
        }
    }
}
