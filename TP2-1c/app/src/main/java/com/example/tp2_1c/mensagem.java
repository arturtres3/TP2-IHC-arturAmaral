package com.example.tp2_1c;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.TextView;

public class mensagem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagem);
        TextView mensagem = (TextView) findViewById(R.id.mensagem);

        String texto_mensagem = getIntent().getStringExtra("mensagem");
        mensagem.setText(texto_mensagem);
    }
}

