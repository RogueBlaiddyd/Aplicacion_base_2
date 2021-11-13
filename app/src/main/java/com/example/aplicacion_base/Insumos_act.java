package com.example.aplicacion_base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

public class Insumos_act extends AppCompatActivity {
    private Spinner insumoSpin;
    private TextView calculoText;
    private RatingBar rateInsu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);

        insumoSpin = (Spinner)findViewById(R.id.spinInsu);

        Bundle bun = getIntent().getExtras();
        String[] listadoInsumos = bun.getStringArray("Insumos");
        ArrayAdapter adaptInsu = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listadoInsumos);
        insumoSpin.setAdapter(adaptInsu);
    }
}