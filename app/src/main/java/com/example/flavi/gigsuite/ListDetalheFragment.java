package com.example.flavi.gigsuite;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.flavi.gigsuite.Entity.Perfil;


public class ListDetalheFragment extends Fragment {

    private static final String EXTRA_PERFIL = "perfil";
    public static  final String TAG_DETALHE = "tagDetalhe";

    TextView txtNome;
    TextView txtApelido;
    TextView txtTelefone;
    TextView txtDescricao;

    Perfil mPerfil;

    public static ListDetalheFragment novaInstancia(Perfil perfil){
        Bundle parametros = new Bundle();
        parametros.putSerializable(EXTRA_PERFIL, perfil);

        ListDetalheFragment fragment = new ListDetalheFragment();
        fragment.setArguments(parametros);
        return fragment;
    }


    public ListDetalheFragment() {
    }

    public void onCreate(Bundle savedInstancesState){
        super.onCreate(savedInstancesState);
        mPerfil = (Perfil) getArguments().getSerializable(EXTRA_PERFIL);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_list_detalhe, container, false);

        txtNome = (TextView) layout.findViewById(R.id.tvNome);
        txtApelido = (TextView) layout.findViewById(R.id.tvApelido);
        txtTelefone = (TextView) layout.findViewById(R.id.tvTelefone);
        txtDescricao = (TextView) layout.findViewById(R.id.tvDescricao);

        if(mPerfil != null){
            txtNome.setText(mPerfil.getNome());
            txtApelido.setText(mPerfil.getApelido());
            txtTelefone.setText(mPerfil.getTelefone());
            txtDescricao.setText(mPerfil.getDescricao());
        }
        return layout;
    }

}
