package com.example.flavi.gigsuite;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.flavi.gigsuite.model.Usuario;
import com.example.flavi.gigsuite.retrofit2.IUsuarioREST;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lucasnascimento on 18/06/17.
 */

public class EditarUsuarioActivity extends AppCompatActivity{

    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_musico);

        final EditText usu = (EditText) findViewById(R.id.edtUsuario);
        final EditText email = (EditText) findViewById(R.id.edtEmail);
        final EditText status = (EditText) findViewById(R.id.edtStatus);

        Intent intent = getIntent();
        final String id = Integer.toString(intent.getIntExtra("ID", 0));

        final IUsuarioREST iUsuarioREST = IUsuarioREST.retrofit.create(IUsuarioREST.class);
        final Call<Usuario> call = iUsuarioREST.listarUsuarioPorId(id);
        dialog = new ProgressDialog(EditarUsuarioActivity.this);
        dialog.setMessage("Carregando...");
        dialog.setCancelable(false);
        dialog.show();

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (dialog.isShowing())
                    dialog.dismiss();
                Usuario u = response.body();
                usu.setText(u.getUsuario());
                email.setText(u.getEmail());
                status.setText(String.valueOf(u.getStatus()));
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                if (dialog.isShowing())
                    dialog.dismiss();

                Toast.makeText(getBaseContext(), "Não foi possível fazer a conexão", Toast.LENGTH_SHORT).show();
            }
        });

        Button alterar = (Button) findViewById(R.id.btnEditarUsuario);
        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new ProgressDialog(EditarUsuarioActivity.this);
                dialog.setMessage("Carregando...");
                dialog.setCancelable(false);
                dialog.show();

                Usuario u = new Usuario();
                u.setId(Integer.parseInt(id));
                u.setUsuario(usu.getText().toString());
                u.setEmail(email.getText().toString());
                u.setStatus(Boolean.parseBoolean(status.getText().toString()));

                Call<Void> call = iUsuarioREST.alterarUsuario(id, u);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (dialog.isShowing())
                            dialog.dismiss();
                        Toast.makeText(getBaseContext(), "Usuário alterado com sucesso", Toast.LENGTH_SHORT).show();
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

        Button remover = (Button) findViewById(R.id.btnRemoverUsuario);
        remover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new ProgressDialog(EditarUsuarioActivity.this);
                dialog.setMessage("Carregando...");
                dialog.setCancelable(false);
                dialog.show();

                Call<Void> call = iUsuarioREST.removerUsuario(id);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (dialog.isShowing())
                            dialog.dismiss();
                        Toast.makeText(getBaseContext(), "Usuário removido com sucesso", Toast.LENGTH_SHORT).show();
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
