package com.example.flavi.gigsuite.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.flavi.gigsuite.R;
import com.example.flavi.gigsuite.model.Usuario;

import java.util.List;

/**
 * Created by root on 18/06/17.
 */

public class UsuarioAdapter extends ArrayAdapter<Usuario> {
    private final Context context;
    private final List<Usuario> elementos;

    public UsuarioAdapter(Context context, List<Usuario> elementos){
        super(context, R.layout.linha, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.linha, parent, false);

        TextView email = (TextView) rowView.findViewById(R.id.txtEmail);
        TextView categoria = (TextView) rowView.findViewById(R.id.txtCategoria);
        TextView status = (TextView) rowView.findViewById(R.id.txtStatus);


        email.setText(elementos.get(position).getEmail());
        categoria.setText(elementos.get(position).getUsuario());
        status.setText(Boolean.toString(elementos.get(position).getStatus()));


        return rowView;
    }
}
