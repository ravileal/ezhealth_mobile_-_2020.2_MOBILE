package com.example.ezhealth_mobile;

import android.view.View;
import android.widget.TextView;

public abstract class ContentPanel {

    private View view;

    public ContentPanel(View view, String title) {
        this.view = view;
        this.setTitle(title);
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    private void setTitle(String title){
        TextView textView = view.findViewById(R.id.textViewTitle);
        textView.setText(title);
    }

}
