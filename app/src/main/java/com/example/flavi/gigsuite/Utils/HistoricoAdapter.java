package com.example.flavi.gigsuite.Utils;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.flavi.gigsuite.Entity.Historico.Historico;
import com.example.flavi.gigsuite.R;

import java.util.List;

/**
 * Created by junior on 30/05/17.
 */

public class HistoricoAdapter extends BaseAdapter {

    Context ctx;
    List<Historico> historicos;
    public HistoricoAdapter(Context ctx, List<Historico> historico){
        this.ctx = ctx;
        this.historicos = historico;
    }

    @Override
    public int getCount() {
        return historicos.size();
    }

    @Override
    public Object getItem(int position) {
        return historicos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Historico historico = historicos.get(position);

        ViewHolder holder = null;

        if (convertView == null){
            convertView = LayoutInflater.from(ctx).inflate(R.layout.item_historico, null);

            holder = new ViewHolder();
            holder.txtUf = (TextView) convertView.findViewById(R.id.txtUf);
            holder.txtModelo = (TextView) convertView.findViewById(R.id.txtModelo);
            holder.txtAno = (TextView) convertView.findViewById(R.id.txtAno);
            holder.txtCombustivel = (TextView) convertView.findViewById(R.id.txtCombustivel);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }

        // Passo 3
        Resources res = ctx.getResources();
        holder.txtUf.setText(historico.getUf()+"\n"+historico.getCidade());
        holder.txtModelo.setText(historico.getCategoria());
        holder.txtAno.setText(historico.getSub_Categoria());
        holder.txtCombustivel.setText(historico.getId()+"");
        // Passo 4
        return convertView;
    }

    static class ViewHolder {
        TextView txtUf;
        TextView txtModelo;
        TextView txtAno;
        TextView txtCombustivel;
    }
}
