package com.example.flavi.gigsuite;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.flavi.gigsuite.DAO.Historico.HistoricoDAO;
import com.example.flavi.gigsuite.Entity.Historico.Historico;
import com.example.flavi.gigsuite.Entity.Usuario;
import com.example.flavi.gigsuite.Entity.UsuarioDeserializer;
import com.example.flavi.gigsuite.retrofit2.UsuarioService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener {

    //Colocar o IP do notebook de vcs
    //Tem que startar o projeto no node e o mongodb
    private static final String BASE_URL = "http://192.168.1.105:8080/api/";

    Button btnBuscar;
    Button  btnHistory;
    Spinner spinnerCategoria;
    Spinner spinnerSub_Categoria;
    EditText etCidade;
    Spinner etUf;

    private void insertHistory(){
        Historico historico = new Historico();
        HistoricoDAO dao = new HistoricoDAO(getApplicationContext());

        historico.setCategoria(spinnerCategoria.getSelectedItem().toString());
        historico.setSub_Categoria(spinnerSub_Categoria.getSelectedItem().toString());
        historico.setUf(etUf.getSelectedItem().toString());
        historico.setCidade(etCidade.getText().toString());

        Toast.makeText(MainActivity.this, historico.getCategoria(), Toast.LENGTH_SHORT).show();

        dao.insert(historico);
    }
    private void callList(){
        //TODO: Lucas vai implementar o GET e chamaremos outra pagina mostrando os resultados.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*=========================================================*/

        //TODO: FALTA JOGAR ESSA PORRA EM UM LISTVIEW
        Gson g = new GsonBuilder().registerTypeAdapter(Usuario.class, new UsuarioDeserializer()).create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(g))
                .build();


        UsuarioService service = retrofit.create(UsuarioService.class);
        Call<List<Usuario>> usuarios  = service.getUsuarios();

        usuarios.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                if(response.isSuccessful()){
                    List<Usuario> users = response.body();
                    for(Usuario u : users){
                        Log.i("USER", u.getUsuario()+" -- "+u.getSenha()+" -- "+u.getEndereco().getCidade());
                        Log.i("USER", "---------------------------");
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Erro: "+response.code(), Toast.LENGTH_LONG).show();                }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Erro: "+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        /*===========================================================*/


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        btnBuscar = (Button) findViewById(R.id.btnCadastrar);
        btnHistory = (Button) findViewById(R.id.btnHistorico);
        spinnerCategoria = (Spinner) findViewById(R.id.editCategoria);
        spinnerSub_Categoria = (Spinner) findViewById(R.id.editSubCategoria);
        etCidade = (EditText) findViewById(R.id.editcidade);
        etUf = (Spinner) findViewById(R.id.editUf);

        btnHistory.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(i);
            }
        });

        btnBuscar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                insertHistory();
                //callList();
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_perfil) {
            // Handle the camera action
        } else if (id == R.id.nav_termo) {

        } else if (id == R.id.nav_contato) {

        } else if (id == R.id.nav_faleconosco) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}

