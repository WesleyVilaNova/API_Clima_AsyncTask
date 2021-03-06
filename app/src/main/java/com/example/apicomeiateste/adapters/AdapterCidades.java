package com.example.apicomeiateste.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.apicomeiateste.R;
import com.example.apicomeiateste.interfaces.Interface_OnClick;
import com.example.apicomeiateste.model.CidadeModel;

import java.util.ArrayList;

public class AdapterCidades extends RecyclerView.Adapter<AdapterCidades.MyViewHolder> {

    private ArrayList<CidadeModel> listInfoCidades;
    private Interface_OnClick interface_onClick;

    public AdapterCidades(ArrayList<CidadeModel> _listInfoCidades, Interface_OnClick _interface_onClick1) {
        this.listInfoCidades = _listInfoCidades;
        this.interface_onClick = _interface_onClick1;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recyclerviews_clima, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CidadeModel item = listInfoCidades.get(position);

        holder.cidade.setText(item.getCidade());
        holder.pais.setText(item.getCountry());
        holder.tempMax.setText(item.getTempMax());
        holder.tempMin.setText(item.getTempMin());
        holder.humidade.setText(item.getHumidade());
    }

    @Override
    public int getItemCount() {
        return listInfoCidades.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView cidade, pais, tempMin, tempMax, humidade;

        public MyViewHolder(View itemView) {
            super(itemView);
            cidade = itemView.findViewById(R.id.layout_recycler_cidade);
            pais = itemView.findViewById(R.id.layout_recycler_country);
            tempMin = itemView.findViewById(R.id.layout_recycler_min);
            tempMax = itemView.findViewById(R.id.layout_recycler_max);
            humidade = itemView.findViewById(R.id.layout_recycler_humidade);

            itemView.setOnLongClickListener(v -> {
                interface_onClick.onLongClick(getAdapterPosition());

                return false;
            });

        }
    }
}
