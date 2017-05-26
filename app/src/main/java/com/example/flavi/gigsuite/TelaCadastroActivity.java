package com.example.flavi.gigsuite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.flavi.gigsuite.NetworkChecking.InternetCheck;


public class TelaCadastroActivity extends AppCompatActivity {

    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        btnSave = (Button) findViewById(R.id.btnCadastrar);

        /*
            Verifica Conexão Com Internet
            new InternetCheck(TelaCadastroActivity.this).isInternetConnectionAvailable(new InternetCheck.InternetCheckListener() {
                @Override
                public void onComplete(boolean connected) {
                    Log.i("Conectado ", "Esta conectado? "+connected);
                }
            });
        */

        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new InternetCheck(TelaCadastroActivity.this).isInternetConnectionAvailable(new InternetCheck.InternetCheckListener() {
                    @Override
                    public void onComplete(boolean connected) {
                        Log.i("Conectado ", "Esta conectado? "+connected);
                    }
                });
                Toast.makeText(TelaCadastroActivity.this, "Tem conexão? ", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
