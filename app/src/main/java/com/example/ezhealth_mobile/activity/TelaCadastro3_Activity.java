package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.entity.Usuario;

public class TelaCadastro3_Activity extends AppCompatActivity {

    private EditText cadastroDia, cadastroMes, cadastroAno;
    private Button buttonProximo3;
    private Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro3);

        // Receber objeto(usuário que irá receber mensagem) de outra activity
        user = getIntent().getExtras().getParcelable("user");
        Log.i("testeTela3", user.getNomeCompleto());

        //* Confirmar se todos os campos estão preenchidos //
        cadastroDia = findViewById(R.id.editTextNascimentoDia);
        cadastroMes = findViewById(R.id.editTextNascimentoMes);
        cadastroAno = findViewById(R.id.editTextNascimentoAno);
        buttonProximo3 = findViewById(R.id.buttonCadastroProximo3);
        buttonProximo3.setEnabled(false);

        cadastroDia.addTextChangedListener(cadastro1Watcher);
        cadastroMes.addTextChangedListener(cadastro1Watcher);
        cadastroAno.addTextChangedListener(cadastro1Watcher);
        // Confirmar se todos os campos estão preenchidos *//

    }

    // Confirmar se todos os campos estão preenchidos

    private TextWatcher cadastro1Watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String diaInput = cadastroDia.getText().toString().trim();
            String mesInput = cadastroMes.getText().toString().trim();
            String anoInput = cadastroAno.getText().toString().trim();

            buttonProximo3.setEnabled(!diaInput.isEmpty() && !mesInput.isEmpty() && !anoInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };


    public void irTela4(View v){
        Intent intent = new Intent(this, TelaCadastro4_Activity.class);

        user.setDiaNasc(cadastroDia.getText().toString());
        user.setMesNasc(cadastroMes.getText().toString());
        user.setAnoNasc(cadastroAno.getText().toString());

        intent.putExtra("user", user);

        startActivity(intent);
    }
}