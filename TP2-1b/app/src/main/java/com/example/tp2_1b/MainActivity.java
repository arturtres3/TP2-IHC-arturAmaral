package com.example.tp2_1b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText) findViewById(R.id.mensagem);
    }

    public void send (android.view.View view){
        //Toast.makeText(this, "lmao "+input.getText().toString(), Toast.LENGTH_SHORT).show();
        Intent display = new Intent(this, displayText.class);

        display.putExtra("mensagem", input.getText().toString());
        //Toast.makeText(this, "add text", Toast.LENGTH_SHORT).show();

        startActivity(display);
    }
}
