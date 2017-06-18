package com.example.flavi.gigsuite.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.flavi.gigsuite.R;
import com.example.flavi.gigsuite.model.Perfil;

import java.util.ArrayList;
import java.util.List;


public class ListagemFragment extends ListFragment {

    List<Perfil> mPerfil;
    ArrayAdapter<Perfil> mAdapter;

    public ListagemFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstancedState){
        super.onActivityCreated(savedInstancedState);

        mPerfil = carregarPerfil();

        mAdapter = new ArrayAdapter<Perfil>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                mPerfil);
        setListAdapter(mAdapter);
    }

    private List<Perfil> carregarPerfil(){
        List<Perfil> listPerfil = new ArrayList<Perfil>();
        return listPerfil;
    }

    @Override
    public void onListItemClick(ListView lv, View v, int position, long id){
        super.onListItemClick(lv, v, position, id);

        Activity activity = getActivity();

        if(activity instanceof AoClicarNoPerfil){
            Perfil perfil = (Perfil) lv.getItemAtPosition(position);

            AoClicarNoPerfil listener = (AoClicarNoPerfil) activity;
            listener.clicouNoPerfil(perfil);
        }
    }

    public interface AoClicarNoPerfil{
        void clicouNoPerfil(Perfil perfil);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listagem, container, false);
    }

}
