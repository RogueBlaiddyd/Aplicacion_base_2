package com.example.aplicacion_base;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aplicacion_base.DB.AdminSQLiteOpenHelper;

public class Comprar_act extends AppCompatActivity {
    private TextView producto, nombre, saldo, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar);

        producto = findViewById(R.id.produText);
        nombre = findViewById(R.id.nameText);
        saldo = findViewById(R.id.saldoText);
        id = findViewById(R.id.idText);
    }

    public void crear(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Cartas yugi", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        int aidi = Integer.parseInt(id.getText().toString());
        String pro = producto.getText().toString();
        String name = nombre.getText().toString();
        int dinero = Integer.parseInt(saldo.getText().toString());

        if(!producto.equals("") && !nombre.equals("") && !saldo.equals("") && !id.equals("")){
            if(pro.equals("Baraja poker")){
                dinero = dinero - 1000;

                ContentValues cont = new ContentValues();
                cont.put("id", aidi);
                cont.put("producto", pro);
                cont.put("nombre_cli", name);
                cont.put("saldo", dinero);

                db.insert("boleta", null, cont);
                db.close();
                clean();
                Toast.makeText(getBaseContext(), "Boleta creada con exito!", Toast.LENGTH_SHORT).show();
            }else if(pro.equals("Sobres de cartas Pokémon")){
                dinero = dinero - 500;

                ContentValues cont = new ContentValues();
                cont.put("id", aidi);
                cont.put("producto", pro);
                cont.put("nombre_cli", name);
                cont.put("saldo", dinero);

                db.insert("boleta", null, cont);
                db.close();
                clean();
                Toast.makeText(getBaseContext(), "Boleta creada con exito!", Toast.LENGTH_SHORT).show();
            }else if(pro.equals("Sobres de cartas yu gi oh")){
                dinero = dinero - 800;

                ContentValues cont = new ContentValues();
                cont.put("id", aidi);
                cont.put("producto", pro);
                cont.put("nombre_cli", name);
                cont.put("saldo", dinero);

                db.insert("boleta", null, cont);
                db.close();
                clean();
                Toast.makeText(getBaseContext(), "Boleta creada con exito!", Toast.LENGTH_SHORT).show();
            }else if(pro.equals("Juego de mesa")){
                dinero = dinero - 2000;

                ContentValues cont = new ContentValues();
                cont.put("id", aidi);
                cont.put("producto", pro);
                cont.put("nombre_cli", name);
                cont.put("saldo", dinero);

                db.insert("boleta", null, cont);
                db.close();
                clean();
                Toast.makeText(getBaseContext(), "Boleta creada con exito!", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getBaseContext(), "Producto no disponible, sentimos la molestia", Toast.LENGTH_SHORT).show();
            }


        }else{
            Toast.makeText(getBaseContext(), "No ingrese campos vacios, por favor", Toast.LENGTH_SHORT).show();
        }
    }

    public void revisar(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Cartas yugi", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        int aidi = Integer.parseInt(id.getText().toString());

        if(!id.equals("")){
            Cursor file = db.rawQuery("SELECT producto, nombre_cli, saldo FROM boleta WHERE id = '"+aidi+"'", null);
            if(file.moveToFirst()){
                producto.setText(file.getString(0));
                nombre.setText(file.getString(1));
                String saldoAText = ""+file.getInt(2);
                saldo.setText(saldoAText);
            }else{
                Toast.makeText(getBaseContext(), "Datos no encontrados, F", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getBaseContext(), "No ingrese campos vacios, por favor", Toast.LENGTH_SHORT).show();
        }
    }

    public void actualizar(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Cartas yugi", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        int aidi = Integer.parseInt(id.getText().toString());
        String pro = producto.getText().toString();
        String name = nombre.getText().toString();
        int dinero = Integer.parseInt(saldo.getText().toString());

        if(!id.equals("") && !producto.equals("") && !nombre.equals("") && !saldo.equals("")){
            ContentValues cont = new ContentValues();
            cont.put("producto", pro);
            cont.put("saldo", dinero);

            db.update("boleta", cont, "id="+aidi, null);
            db.close();
            clean();
            Toast.makeText(getBaseContext(), "A actualizado los datos de: "+name, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getBaseContext(), "No ingrese campos vacios, por favor", Toast.LENGTH_SHORT).show();
        }
    }

    public void eliminar(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Cartas yugi", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        int aidi = Integer.parseInt(id.getText().toString());

        if(!id.equals("")){
            int cant = db.delete("boleta", "id="+aidi, null);
            db.close();
            clean();
            if(cant==1){
                Toast.makeText(getBaseContext(), "Eliminaste la boleta en id: "+aidi, Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getBaseContext(), "No existe la boleta a eliminar", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getBaseContext(), "No ingrese campos vacios, por favor", Toast.LENGTH_SHORT).show();
        }
    }

    public void clean(){
        producto.setText("");
        nombre.setText("");
        saldo.setText("");
        id.setText("");
    }
}