package com.example.appcarros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class mostraCarro extends AppCompatActivity {

    //DECLARAR O ARRAY COM AS MARCAS DOS CARROS E OUTRO COM IMAGENS
    private String[] marcaCarros = new String[]{"BMW", "Ferrari", "Mercedes-Benz", "Porsche"};
    private int[] imagens = {R.drawable.bmw, R.drawable.ferrari, R.drawable.mercedes, R.drawable.porche};

    //CRIAR VARIÁVEIS DO TIPO DE ELEMENTOS EXISTENTES NO XML
    private ImageView imgCarros;
    private TextView marca;
    private Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_carro);

        //ASSOCIAR VARIAVÉIS JAVA COM OS RESPECTIVOS ELEMENTOS XML
        imgCarros = findViewById(R.id.img);
        marca = findViewById(R.id.txtCarros);
        sp = findViewById(R.id.spinner);

        //CONSTRUIR ARRAY ADAPTAR E CARREGAR NO SPINNER
        ArrayAdapter<String> valores = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, marcaCarros);

        //ASSOCIAR O ARRAY AO SPINNER
        sp.setAdapter(valores);

        //APLICAR O CÓDIGO AO EVENTO DE SELEÇÃO DAS AÇÕES
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                imgCarros.setImageResource(imagens[i]);
                marca.setText(sp.getSelectedItem() + " ");
                Toast.makeText(mostraCarro.this, sp.getSelectedItem() + "", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    public void voltaAoMenu(View v) {
        Intent it = new Intent(mostraCarro.this, Menu.class);
        startActivity(it);
        finish();
    }
}