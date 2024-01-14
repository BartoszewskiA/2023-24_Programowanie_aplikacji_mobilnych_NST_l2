package com.example.lab03p01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] obrazki = new int[] {
            R.drawable.rys_01,
            R.drawable.rys_02,
            R.drawable.rys_03,
            R.drawable.rys_04
    };
    String[] opisy;
    int poz = 0;
    ImageView imageView01;
    TextView textView01;
    Button button01, button02;

    Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView01 = findViewById(R.id.imageView01);
        textView01 = findViewById(R.id.textView01);
        button01 = findViewById(R.id.button01);
        button02 = findViewById(R.id.button02);
        opisy = getResources().getStringArray(R.array.opisy);
        poz = random.nextInt(obrazki.length);
        imageView01.setImageResource(obrazki[poz]);
        textView01.setText(opisy[poz]);

        dodaj_sluchacza();

    }

    private void dodaj_sluchacza() {
        View.OnClickListener sluchacz = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                if(id==R.id.button01)
                    w_lewo();
                else
                    w_prawo();
            }
        };
        button02.setOnClickListener(sluchacz);
        button01.setOnClickListener(sluchacz);
    }

    private void w_prawo() {
    poz++;
    if(poz==obrazki.length)
        poz=0;
        imageView01.setImageResource(obrazki[poz]);
        textView01.setText(opisy[poz]);
    }

    private void w_lewo() {
        poz--;
        if(poz<0)
            poz=obrazki.length-1;
        imageView01.setImageResource(obrazki[poz]);
        textView01.setText(opisy[poz]);
    }
}