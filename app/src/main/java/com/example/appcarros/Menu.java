package com.example.appcarros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void saiDaki(View v){
        finish();
    }

    public void mostraCarro(View v){
        Intent it = new Intent(Menu.this,mostraCarro.class);
        startActivity(it);
        finish();
    }

    public void mostraPaises(View v){
        Intent it = new Intent(Menu.this,VerPaises.class);
        startActivity(it);
        finish();
    }

    public void Moeda(View v){
        Intent it = new Intent(Menu.this,ConverteMoeda.class);
        startActivity(it);
        finish();
    }




}