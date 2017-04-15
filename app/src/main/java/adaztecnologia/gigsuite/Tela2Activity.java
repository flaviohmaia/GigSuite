package adaztecnologia.gigsuite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import adaztecnologia.gigsuite.Entity.Cliente;

public class Tela2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        TextView txt = (TextView) findViewById(R.id.txtTexto);
        Intent intent = getIntent();

        Cliente cliente = intent.getParcelableExtra("cliente");
        if(cliente != null){
          String texto = String.format("Nome: %s / Código: %d", cliente.nome, cliente.id);
            txt.setText(texto);
        }else{
            String nome = intent.getStringExtra("nome");
            int idade = intent.getIntExtra("idade", -1);
            txt.setText(String.format("Nome: %s / Idade: %d", nome, idade));
        }

    }
}
