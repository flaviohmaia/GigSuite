package com.example.flavi.gigsuite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.flavi.gigsuite.DAO.Historico.HistoricoDAO;
import com.example.flavi.gigsuite.Entity.Historico.Historico;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    ListView lvHistory;
    String[] itens = { "item 1", "item 2", "item 3", "item 4" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        ArrayList<String> historico = new ArrayList<>();
        HistoricoDAO dao = new HistoricoDAO(this);
        List<Historico> history = new ArrayList<>();
        history = dao.selectHistory();


        for (Historico history2 : history) {
            historico.add(history2.getCategoria());
        }


        lvHistory = (ListView) findViewById(R.id.lv_History);
        lvHistory.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, historico));
    }
}
