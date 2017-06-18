package com.example.flavi.gigsuite;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.flavi.gigsuite.model.Usuario;
import com.example.flavi.gigsuite.retrofit2.IUsuarioREST;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroUsuarioActivity extends AppCompatActivity {

    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
        final EditText email = (EditText) findViewById(R.id.editEmail);
        final EditText usuario = (EditText) findViewById(R.id.editUsuario);
        final EditText senha = (EditText) findViewById(R.id.editSenha);
        Button adicionar = (Button) findViewById(R.id.btnCadastrar);

        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new ProgressDialog(CadastroUsuarioActivity.this);
                dialog.setMessage("Carregando...");
                dialog.setCancelable(false);
                dialog.show();

                Usuario u = new Usuario();
                u.setEmail(email.getText().toString());
                u.setUsuario(usuario.getText().toString());
                u.setSenha(senha.getText().toString());

                IUsuarioREST iUsuarioREST = IUsuarioREST.retrofit.create(IUsuarioREST.class);
                final Call<Void> call = iUsuarioREST.inserirUsuario(u);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (dialog.isShowing())
                            dialog.dismiss();
                        Toast.makeText(getBaseContext(), "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        if (dialog.isShowing())
                            dialog.dismiss();
                        Toast.makeText(getBaseContext(), "Não foi possível fazer a conexão", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
