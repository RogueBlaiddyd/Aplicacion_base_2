package com.example.aplicacion_base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import Objetos.Insumos;

public class Insumos_act extends AppCompatActivity {
    private Spinner insumoSpin;
    private TextView calculoText;
    private RatingBar rateInsu;
    
    private Insumos in = new Insumos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);

        insumoSpin = findViewById(R.id.spinInsu);
        calculoText = findViewById(R.id.calculoView);
        rateInsu = findViewById(R.id.rBarInsu);

        Bundle bun = getIntent().getExtras();
        String[] listadoInsumos = bun.getStringArray("Insumos");
        ArrayAdapter adaptInsu = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listadoInsumos);
        insumoSpin.setAdapter(adaptInsu);
    }

    public void calcular(View view){
        String opcion = insumoSpin.getSelectedItem().toString();
        int resultado = 0;

        for(int i = 0; i < opcion.length(); i++){
            if(opcion.equals(in.getInsumos()[i])){
                resultado = in.agregarAdicional(in.getPrecios()[i], 350);
                rateInsu.setRating(i + 1);
                break;
            }
        }
        calculoText.setText("El producto es: "+opcion+"\nY el precio seria: "+resultado);
    }
}