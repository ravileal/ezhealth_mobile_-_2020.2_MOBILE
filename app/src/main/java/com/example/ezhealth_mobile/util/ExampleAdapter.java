package com.example.ezhealth_mobile.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    //Array auxiliar
    private ArrayList<Example_Item_Alimento> mListaAlimentos;
    Context mContext;

    public ExampleAdapter(Context context, ArrayList<Example_Item_Alimento> array){
        this.mContext = context;
        this.mListaAlimentos = array;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageResource;
        public TextView textAlimento;
        public TextView textMassa;
        public TextView textCalorias;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            textAlimento = itemView.findViewById(R.id.TextViewAlimento);
            textMassa = itemView.findViewById(R.id.TextViewMassaAlimento);
            textCalorias = itemView.findViewById(R.id.TextViewCaloriasAlimento);
        }
    }

    public ExampleAdapter(ArrayList<Example_Item_Alimento> listaAlimentos){
        mListaAlimentos = listaAlimentos;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item_alimento, parent, false);
        ExampleViewHolder example = new ExampleViewHolder(v);
        return example;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        Example_Item_Alimento itemAtual = mListaAlimentos.get(position);

        holder.textAlimento.setText(itemAtual.getTextAlimento());
        holder.textMassa.setText(itemAtual.getTextMassa());
        holder.textCalorias.setText(itemAtual.getTextCalorias());
    }

    @Override
    public int getItemCount() {
        return mListaAlimentos.size();
    }


}