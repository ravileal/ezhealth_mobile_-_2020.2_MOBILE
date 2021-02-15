package com.example.ezhealth_mobile.util;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.activity.EditarRefeicao_Activity;
import com.example.ezhealth_mobile.activity.VisualizarRefeicao_Activity;
import com.example.ezhealth_mobile.entity.Refeicao;
import com.example.ezhealth_mobile.entity.Refeicao_Repositorio;

import java.util.ArrayList;

public class ExampleAdapterRefeicao extends RecyclerView.Adapter<ExampleAdapterRefeicao.ExampleViewHolder> {

    //Array auxiliar
    private ArrayList<Refeicao> mListaRefeicoes;
    Context mContext;

    public ExampleAdapterRefeicao(Context context){
        this.mContext = context;
        this.mListaRefeicoes = Refeicao_Repositorio.getList();
    }


    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageResource;
        public TextView textRefeicao;
        public TextView textMassa;
        public TextView textCalorias;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            textRefeicao = itemView.findViewById(R.id.TextViewRefeicao);
            textMassa = itemView.findViewById(R.id.TextViewMassaRefeicao);
            textCalorias = itemView.findViewById(R.id.TextViewCaloriasRefeicao);

            itemView.findViewById(R.id.buttonItemRefeicaoAdicionar).setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), EditarRefeicao_Activity.class);
                intent.putExtra("REFEICAO", textRefeicao.getText());
                itemView.getContext().startActivity(intent);
            });

            itemView.findViewById(R.id.buttonItemRefeicaoVisualizar).setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), VisualizarRefeicao_Activity.class);
                intent.putExtra("REFEICAO", textRefeicao.getText());
                itemView.getContext().startActivity(intent);
            });

        }

    }
    

    @NonNull
    @Override
    public ExampleAdapterRefeicao.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item_refeicao, parent, false);
        return new ExampleAdapterRefeicao.ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        Refeicao itemAtual = mListaRefeicoes.get(position);

        holder.textRefeicao.setText(itemAtual.getTextRefeicao());
        holder.textMassa.setText(itemAtual.getTextMassa());
        holder.textCalorias.setText(itemAtual.getTextCalorias());
    }


    @Override
    public int getItemCount() {
        return mListaRefeicoes.size();
    }
}
