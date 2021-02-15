package com.example.ezhealth_mobile.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.content.PainelInformacoes_Content;
import com.example.ezhealth_mobile.entity.ObjectDefault;
import com.example.ezhealth_mobile.entity.ObjectDefault_Repositorio;

public class VisualizarRefeicao_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_panel);
        ((Button) findViewById(R.id.buttonCheck)).setVisibility(View.INVISIBLE);
        popular();
        ((TextView) findViewById(R.id.textViewTitelDualPanel)).setText(ObjectDefault_Repositorio.getTitleListItens());
        this.configuraPrimeiroPainel();
    }

    private void configuraPrimeiroPainel(){
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.content_panel_first_info, null);

        ConstraintLayout includeFirstPanel = (ConstraintLayout) findViewById(R.id.include);
        includeFirstPanel.removeAllViews();
        includeFirstPanel.addView(view);

        ((TextView) findViewById(R.id.textViewTituloPrimeiroPainel)).setText("Lista de alimentos");

        // Classe para configuração do conteúdo do primeiro painel
        new PainelInformacoes_Content(
                getWindow().getDecorView(),
                EditarAlimento_Activity.class,
                false
        );
    }

    //Botão "check" para confirmar que o usuário deseja salvar os itens
    public void salvar(View v){
        Intent intent = new Intent(this, Main_Activity.class);
        startActivity(intent);
    }

    //Botão "voltar" para caso o usuário desista e volte para a tela anterior
    public void voltar(View v){
        Intent intent = new Intent(this, Main_Activity.class);
        startActivity(intent);
    }

    //Botão "add" para caso o usuário queria adicionar um novo item
    public void adicionar(View view){
        Intent intent = new Intent(this, Main_Activity.class);
        startActivity(intent);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Ainda será implementado
    }

    private void popular(){
        ObjectDefault_Repositorio.setTitleListItens("Café da manhã");
        ObjectDefault_Repositorio.add(new ObjectDefault("Maçã", "4", null, "100"));
        ObjectDefault_Repositorio.add(new ObjectDefault("Uva", "3", null, "80"));
        ObjectDefault_Repositorio.add(new ObjectDefault("Coca-Cola", "500", "ml", "120"));
        ObjectDefault_Repositorio.add(new ObjectDefault("Pedaço de Pizza", "2", null, "500"));
    }
}
