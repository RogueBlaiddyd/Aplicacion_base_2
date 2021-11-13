package com.example.aplicacion_base;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import Objetos.Administradores;

public class MainActivity extends AppCompatActivity {
    private EditText user, pass;
    private TextView alerta;
    private Button btn;
    private ProgressBar pro;
    private Administradores adm = new Administradores();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText)findViewById(R.id.userEdit);
        pass = (EditText)findViewById(R.id.passEdit);
        alerta = (TextView)findViewById(R.id.alertView);
        btn = (Button)findViewById(R.id.iniciar);
        pro = (ProgressBar)findViewById(R.id.progres);

        alerta.setVisibility(View.INVISIBLE);
        pro.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Task().execute();
            }
        });
    }

    //Tarea...
    class Task extends AsyncTask<String, Void, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pro.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                for (int i = 0;i <= 10; i++){
                    Thread.sleep(300);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pro.setVisibility(View.INVISIBLE);

            String usuario = adm.getUser().toString().trim();
            String contrasena = adm.getPass().toString().trim();

            String usuarioInter = user.getText().toString().trim();
            String contraInter = pass.getText().toString().trim();

            switch (usuarioInter){
                case "Luciano":
                    if(usuarioInter.equals(usuario) && contraInter.equals(contrasena)){
                        Intent i = new Intent(getBaseContext(), Home_act.class);
                        i.putExtra("usuario", user.getText().toString());
                        startActivity(i);
                    }
                    break;
                case "":
                    if(usuarioInter.equals("") && contraInter.equals("")){
                        alerta.setVisibility(View.VISIBLE);
                        alerta.setText("Campos vacios!");
                    }
                    break;
                default:
                    if(!usuarioInter.equals(usuario) || !contraInter.equals(contrasena)){
                        alerta.setVisibility(View.VISIBLE);
                        alerta.setText("Usuario o contraseña incorrectos");
                    }
            }
        }
    }

    public void info(View v){
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }

    public void facebook(View v){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.facebook.com/"));
        startActivity(i);
    }

    public void twitter(View v){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.twitter.com/"));
        startActivity(i);
    }

    public void youtube(View v){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.youtube.com/"));
        startActivity(i);
    }
}