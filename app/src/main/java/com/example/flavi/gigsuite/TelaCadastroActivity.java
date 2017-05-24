package com.example.flavi.gigsuite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.flavi.gigsuite.DAO.UsuarioDAO;
import com.example.flavi.gigsuite.Entity.Usuario;
//import com.example.flavi.gigsuite.SQLiteHelper.GigSuiteRepositorio;

public class TelaCadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        Button btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        final EditText etNome = (EditText) findViewById(R.id.editNome);
        final EditText etEmail = (EditText) findViewById(R.id.editEmail);
        final EditText etUsuario = (EditText) findViewById(R.id.editUsuario);
        final EditText etSenha = (EditText) findViewById(R.id.editSenha);
        EditText etSenhaConfirmada = (EditText) findViewById(R.id.editSenhaConfirm);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario  = new Usuario();

                usuario.setNome(etNome.getText().toString());
                usuario.setEmail(etEmail.getText().toString());
                usuario.setUsuario(etUsuario.getText().toString());
                usuario.setSenha(etSenha.getText().toString());

                Intent it = getIntent().putExtra("usuario",usuario);
                setResult(RESULT_OK, it);
                finish();
            }
        });
    }
}
