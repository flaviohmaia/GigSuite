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
 * Created by lucasnascimento on 18/06/17.
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

        TextView nomeUsuario = (TextView) rowView.findViewById(R.id.txtNomeUsuario);
        TextView categoria = (TextView) rowView.findViewById(R.id.txtCategoria);
        TextView subCategoria = (TextView) rowView.findViewById(R.id.txtSubCategoria);


        nomeUsuario.setText(elementos.get(position).getUsuario());
        categoria.setText(elementos.get(position).getPerfil().getCategoria());
        subCategoria.setText(elementos.get(position).getPerfil().getSub_Categoria());

        return rowView;
    }
}
