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
import com.example.ezhealth_mobile.entity.Example_Item_Refeicao;

import java.util.ArrayList;

public class ExampleAdapterRefeicao extends RecyclerView.Adapter<ExampleAdapterRefeicao.ExampleViewHolder> {

    //Array auxiliar
    private ArrayList<Example_Item_Refeicao> mListaRefeicoes;
    Context mContext;

    public ExampleAdapterRefeicao(Context context, ArrayList<Example_Item_Refeicao> array){
        this.mContext = context;
        this.mListaRefeicoes = array;
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

            /*itemView.findViewById(R.id.buttonTESTE).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(this, HomeActivity.class);
                    startActivity(intent);
                    //Log.d("demo", "TESTE");
                }
            });*/

        }

    }
    

    @NonNull
    @Override
    public ExampleAdapterRefeicao.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item_refeicao, parent, false);
        ExampleAdapterRefeicao.ExampleViewHolder example = new ExampleAdapterRefeicao.ExampleViewHolder(v);
        return example;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        Example_Item_Refeicao itemAtual = mListaRefeicoes.get(position);

        holder.textRefeicao.setText(itemAtual.getTextRefeicao());
        holder.textMassa.setText(itemAtual.getTextMassa());
        holder.textCalorias.setText(itemAtual.getTextCalorias());
    }


    @Override
    public int getItemCount() {
        return mListaRefeicoes.size();
    }
}