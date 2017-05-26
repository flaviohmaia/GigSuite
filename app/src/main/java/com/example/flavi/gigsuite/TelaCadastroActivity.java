package com.example.flavi.gigsuite;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.flavi.gigsuite.Util.UtilsMethods;


public class TelaCadastroActivity extends AppCompatActivity {

    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
        
        btnSave = (Button) findViewById(R.id.btnCadastrar);

        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(TelaCadastroActivity.this, "Testando", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
