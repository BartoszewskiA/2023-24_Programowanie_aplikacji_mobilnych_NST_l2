package com.example.lab03p01_przelicznik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_zrodlowa, tv_docelowa;
    RadioGroup rg_in, rg_out;
    RadioButton rb_in_pln, rb_in_euro, rb_in_usd,
                rb_out_pln, rb_out_euro, rb_out_usd;
    SeekBar suwak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        przygotujInterfejs();
        obslugaSuwaka();
        obslugaRadiobuttonow();
    }

    private void obslugaRadiobuttonow() {
        RadioGroup.OnCheckedChangeListener sluchacz = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                wypiszWynik();
            }
        };
        rg_in.setOnCheckedChangeListener(sluchacz);
        rg_out.setOnCheckedChangeListener(sluchacz);
    }

    private void obslugaSuwaka() {
        suwak.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                tv_zrodlowa.setText(String.valueOf(i));

                wypiszWynik();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void wypiszWynik() {
        int kz, kd;
        if(rb_in_pln.isChecked())
            kz = 0;
        else if(rb_in_euro.isChecked())
            kz = 1;
        else
            kz= 2;
        if(rb_out_pln.isChecked())
            kd = 0;
        else if(rb_out_euro.isChecked())
            kd = 1;
        else
            kd= 2;
        double x = przelicz(Double.parseDouble(tv_zrodlowa.getText().toString()),kz,kd);
        tv_docelowa.setText(String.valueOf(x));
    }

    private void przygotujInterfejs() {
        tv_zrodlowa = findViewById(R.id.textView01);
        tv_docelowa = findViewById(R.id.textView02);
        suwak = findViewById(R.id.seekBar01);
        rg_in = findViewById(R.id.rg_in);
        rg_out = findViewById(R.id.rg_out);
        rb_in_pln = findViewById(R.id.rb_in_pln);
        rb_in_euro = findViewById(R.id.rb_in_euro);
        rb_in_usd = findViewById(R.id.rb_in_usd);
        rb_out_pln = findViewById(R.id.rb_out_pln);
        rb_out_euro = findViewById(R.id.rb_out_euro);
        rb_out_usd = findViewById(R.id.rb_out_usd);
        rb_in_pln.setChecked(true);
        rb_out_euro.setChecked(true);
    }

    double przelicz(double x ,int kod_zr, int kod_doc )
            // 0 - PLN
            // 1 - EURO
            // 2 - USD
    {
        double kursUSD = 4.12;
        double kursEURO = 4.6;
        double wynik=0;
        double posredniaPLN =0;
        if(kod_zr==0)
            posredniaPLN = x;
        else if(kod_zr==1)
            posredniaPLN = x*kursEURO;
        else
            posredniaPLN = x*kursUSD;

        if(kod_doc==0)
            wynik= posredniaPLN;
        else if(kod_doc==1)
            wynik = posredniaPLN / kursEURO;
        else
            wynik = posredniaPLN / kursUSD;
        wynik *= 100;
        wynik = Math.round(wynik);
        wynik /= 100;
        return wynik;
    }

}