package com.example.tp2_pt1a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.EditText;
//import android.widget.Toast;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText input1;
    private EditText input2;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = (EditText) findViewById(R.id.txt_number1);
        input2 = (EditText) findViewById(R.id.txt_number2);
        resultado = (TextView) findViewById(R.id.resultado);
    }

    public void somar(android.view.View view){
        int valor1 = Integer.parseInt(input1.getText().toString());
        int valor2 = Integer.parseInt(input2.getText().toString());
        int res = valor1 + valor2;

        resultado.setText("Resultado: " + res);
    }

}
