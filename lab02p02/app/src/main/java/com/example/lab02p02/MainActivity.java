package com.example.lab02p02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText poleX, poleY;
    TextView poleWynik;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        poleX = findViewById(R.id.editText01);
        poleY = findViewById(R.id.editText02);
        poleWynik = findViewById(R.id.textView03);

    }

    public void licz(View view) {
        String s = poleX.getText().toString();
        if (s.length()==0)
        {
            Toast.makeText(this, "Pole x musi być wypełnione", Toast.LENGTH_SHORT).show();
            return;
        }
        int x = Integer.parseInt(s);

        s = poleY.getText().toString();
        if (s.length()==0)
        {
            Toast.makeText(this, "Pole y musi być wypełnione", Toast.LENGTH_SHORT).show();
            return;
        }
        int y = Integer.parseInt(s);

        poleWynik.setText("x+y="+String.valueOf(x+y));
    }
}