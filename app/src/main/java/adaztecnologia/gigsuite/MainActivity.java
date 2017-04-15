package adaztecnologia.gigsuite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import adaztecnologia.gigsuite.Entity.Cliente;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);

        Button button = (Button) findViewById(R.id.btnToast);
        button.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.btnActivity);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.btnToast);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){

        switch (view.getId()){
            case R.id.btnToast:
                String texto = editText.getText().toString();
                Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnActivity:
                Intent intent = new Intent(this, Tela2Activity.class);
                intent.putExtra("nome", "Flávio Maia");
                intent.putExtra("idade", 35);
                startActivity(intent);
                break;

            case R.id.btnParcel:
                Cliente cliente = new Cliente(1, "Flavio", "32282277", "Musico");
                Intent intent1 = new Intent(this, Tela2Activity.class);
                intent1.putExtra("cliente", cliente);
                startActivity(intent1);
                break;
        }


    }
}
