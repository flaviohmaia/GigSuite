package com.example.flavi.gigsuite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFotografo = (Button) findViewById(R.id.btnfotografo);
        btnFotografo.setOnClickListener(this);

        Button btnCinegrafista = (Button) findViewById(R.id.btnCinegafista);
        btnCinegrafista.setOnClickListener(this);

        Button btnMusico = (Button) findViewById(R.id.btnMusico);
        btnMusico.setOnClickListener(this);

        Button btnRoadie = (Button) findViewById(R.id.btnRoadies);
        btnRoadie.setOnClickListener(this);

        Button btnIluminacao = (Button) findViewById(R.id.btnIluminacao);
        btnIluminacao.setOnClickListener(this);

        Button btnPalco = (Button) findViewById(R.id.btnPalcos);
        btnPalco.setOnClickListener(this);

        Button btnEquipamento = (Button) findViewById(R.id.btnEquipamentos);
        btnEquipamento.setOnClickListener(this);

        Button btnIngresso = (Button) findViewById(R.id.btnIngressos);
        btnIngresso.setOnClickListener(this);

        Button btnAtor = (Button) findViewById(R.id.btnAtor);
        btnIluminacao.setOnClickListener(this);

        Button btnSonorizacao = (Button) findViewById(R.id.btnSonorizacao);
        btnIluminacao.setOnClickListener(this);

        Button btnProdutor = (Button) findViewById(R.id.btnProdutor);
        btnIluminacao.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
