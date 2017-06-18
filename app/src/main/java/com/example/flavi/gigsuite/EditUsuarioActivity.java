package com.example.flavi.gigsuite;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by root on 18/06/17.
 */

public class EditUsuarioActivity extends AppCompatActivity{

    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_musico);

        final EditText nome = (EditText) findViewById(R.id.editUsuario);
        final EditText categoria = (EditText) findViewById(R.id.editEmail);
        final EditText idade = (EditText) findViewById(R.id.editLogradouro);

        Intent intent = getIntent();
        final String id = Integer.toString(intent.getIntExtra("ID", 0));
    }
}
