package com.example.flavi.gigsuite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.flavi.gigsuite.dao.HistoricoDAO;
import com.example.flavi.gigsuite.model.Historico;
import com.example.flavi.gigsuite.utils.HistoricoAdapter;

import java.util.List;

public class HistoricoActivity extends AppCompatActivity {

    List<Historico> historicos;
    HistoricoAdapter adapter;
    ListView lvHistory;

    private void loadList(){
        lvHistory = (ListView) findViewById(R.id.lv_History);
        lvHistory.setEmptyView(findViewById(android.R.id.empty));

        HistoricoDAO dao = new HistoricoDAO(this);
        historicos = dao.selectHistory();

        adapter = new HistoricoAdapter(this, historicos);
        lvHistory.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        loadList();

        lvHistory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Historico historicoSelecionado = historicos.get(position);
                //Fazer o mesmo processo da tela de busca pegando os dados do historicoSelecionado
            }
        });

        lvHistory.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int pos, long id) {

                Historico historicoSelecionado = historicos.get(pos);
                HistoricoDAO daoLongClick = new HistoricoDAO(getApplicationContext());
                daoLongClick.delete(historicoSelecionado.getId());
                loadList();
                return true;
            }
        });
    }
}
