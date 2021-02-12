package com.example.ezhealth_mobile.ui.refeicao;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.ezhealth_mobile.R;

public class RefeicaoFragment extends Fragment {

    private RefeicaoViewModel refeicaoViewModel;

    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState)
    {
        refeicaoViewModel = new ViewModelProvider(this).get(RefeicaoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_refeicao, container, false);

        refeicaoViewModel.getText().observe( getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });

        return root;
    }
}