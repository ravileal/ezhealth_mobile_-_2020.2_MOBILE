package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.entity.Refeicao;
import com.example.ezhealth_mobile.util.ExampleAdapterRefeicao;

import java.util.ArrayList;

public class Refeicao_TabFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_refeicao_fragment, container, false);

        RecyclerView mRecyclerView = view.findViewById(R.id.recyclerViewRefeicoes);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mRecyclerView.setAdapter(new ExampleAdapterRefeicao(
            nome -> { // Construção do botão de ADICIONAR de cada item da lista
                Intent intent = new Intent(getContext(), EditarRefeicao_Activity.class);
                intent.putExtra("REFEICAO", nome);
                startActivity(intent);
            }, // Construção do botão de VISUALIZAR de cada item da lista
            nome -> {
                Intent intent = new Intent(getContext(), VisualizarRefeicao_Activity.class);
                intent.putExtra("TELA_ANTERIOR", "adicionarRefeicao");
                intent.putExtra("REFEICAO", nome);
                startActivity(intent);
            })
        );

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
