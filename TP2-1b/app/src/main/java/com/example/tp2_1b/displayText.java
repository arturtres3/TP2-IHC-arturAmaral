package com.example.tp2_1b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.TextView;

public class displayText extends AppCompatActivity {

    //private TextView mensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_text);
        TextView mensagem = (TextView) findViewById(R.id.mensagem);

        String texto_mensagem = getIntent().getStringExtra("mensagem");
        mensagem.setText(texto_mensagem);
    }
}
