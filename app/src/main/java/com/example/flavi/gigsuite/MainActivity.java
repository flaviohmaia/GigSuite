package com.example.flavi.gigsuite;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.flavi.gigsuite.dao.HistoricoDAO;
import com.example.flavi.gigsuite.model.Historico;

public class MainActivity extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener {

    TextView tvLogin;
    TextView tvCadastrar;
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

        dao.insert(historico);
    }

    private void buscarUsuarios(){
        Intent intent = new Intent(MainActivity.this, ListarUsuariosActivity.class);
        String txt = etUf.getSelectedItem().toString();
        String txt1 = etCidade.getText().toString();
        String txt2 = spinnerCategoria.getSelectedItem().toString();
        String txt3 = spinnerSub_Categoria.getSelectedItem().toString();

        Bundle bundle = new Bundle();

        bundle.putString("txt", txt);
        bundle.putString("txt1", txt1);
        bundle.putString("txt2", txt2);
        bundle.putString("txt3", txt3);

        intent.putExtras(bundle);

        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        tvLogin = (TextView) findViewById(R.id.tv_login);
        tvCadastrar = (TextView) findViewById(R.id.tv_cadastrar);

        tvCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroUsuarioActivity.class);
                startActivity(intent);
            }
        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this, HistoricoActivity.class);
                startActivity(i);
            }
        });

        btnBuscar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                insertHistory();
                buscarUsuarios();
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

    public void showLocation(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }
}

