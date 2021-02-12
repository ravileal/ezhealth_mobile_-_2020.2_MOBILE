package com.example.ezhealth_mobile.content;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ezhealth_mobile.R;

public class ContentFirstPanelQuantity {

    public ContentFirstPanelQuantity(AppCompatActivity appCompatActivity, String titlePanel, String quantity, String quantityMeasure) {
        View view = appCompatActivity.getWindow().getDecorView();
        ((TextView)view.findViewById(R.id.textViewTitlePanel)).setText(titlePanel);
        ((TextView)view.findViewById(R.id.editTextQtd)).setText(quantity);
        ((TextView)view.findViewById(R.id.textViewUniMed)).setText(quantityMeasure);
    }

}
