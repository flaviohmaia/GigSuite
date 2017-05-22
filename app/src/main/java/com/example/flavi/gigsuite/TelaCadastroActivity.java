package com.example.flavi.gigsuite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.flavi.gigsuite.Entity.Cliente;
import com.example.flavi.gigsuite.SQLiteHelper.GigSuiteRepositorio;

public class TelaCadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        Button btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GigSuiteRepositorio g = new GigSuiteRepositorio(getBaseContext());

                EditText nome = (EditText) findViewById(R.id.editNome);
                EditText apelido = (EditText) findViewById(R.id.editApelido);
                EditText cpf = (EditText) findViewById(R.id.editCpf);
                EditText telefone = (EditText) findViewById(R.id.editTelefone);
                EditText descricao = (EditText) findViewById(R.id.editDescricao);
                EditText email = (EditText) findViewById(R.id.editEmail);
                Spinner categoria = (Spinner) findViewById(R.id.editCategoria);

                String strNome = nome.getText().toString();
                String strApelido = apelido.getText().toString();
                String strCpf = cpf.getText().toString();
                String strTelefone = telefone.getText().toString();
                String strDescricao = descricao.getText().toString();
                String strEmail = email.getText().toString();
                String strCategoria = categoria.getSelectedItem().toString();

                String resultado;

                resultado = g.inserir(strNome, strApelido, strCategoria, strCpf, strDescricao, strEmail, strTelefone);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
    }
}
