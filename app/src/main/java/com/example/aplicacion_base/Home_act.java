package com.example.aplicacion_base;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import Objetos.Insumos;

public class Home_act extends AppCompatActivity {
    private VideoView video;
    private TextView titulo;

    private Insumos in = new Insumos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        titulo = (TextView)findViewById(R.id.bienvenida);
        video = (VideoView)findViewById(R.id.videazo);

        String ruta = "android.resource://"+getPackageName()+"/"+R.raw.video;
        Uri uri = Uri.parse(ruta);
        video.setVideoURI(uri);

        video.start();

        String use = getIntent().getStringExtra("usuario");

        titulo.setText("Bienvenido a Cartas Yugi, "+use);
    }

    public void abrirInsumos(View v){
        Intent i = new Intent(this, Insumos_act.class);
        Bundle bun = new Bundle();
        bun.putStringArray("Insumos", in.getInsumos());
        i.putExtras(bun);
        startActivity(i);
    }

    public void comprar(View v){
        Intent i = new Intent(this, Comprar_act.class);
        startActivity(i);
    }


}