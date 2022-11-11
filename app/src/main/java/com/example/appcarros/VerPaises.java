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

public class VerPaises extends AppCompatActivity {

    //DECLARAR O ARRAY COM AS MARCAS DOS CARROS E OUTRO COM IMAGENS
    private String[] nomePaises = new String[]{"África do Sul", "Brasil", "Itália", "Fiji"};
    private int[] bandeiras = {R.drawable.sul, R.drawable.bra, R.drawable.ita, R.drawable.fiji};
    private String[] capital = new String[]{"Pretória (executiva)," +
            "\nCidade do Cabo (legislativa)\n" +
            "Bloemfontein (judiciária)\n", "Brasília", "Roma", "Suva"};
    private String[] populacao = new String[]{"57.725.600 (2018)", "214 milhões (2021)", "60.317.116 (2020)", "905.354 (2007)"};
    private String[] lingua = new String[]{"Africâner - Inglês (11 idiomas oficiais)","Português","Italiano", "Inglês, Fijiano e Híndi fijiano."};
    private String[] moeda = new String[]{"Rand (ZAR)", "Real (BRL)", "Euro(EUR)", "Dólar Fijiano (FJD)"};

    //CRIAR VARIÁVEIS DO TIPO DE ELEMENTOS EXISTENTES NO XML
    private ImageView imgPaises;
    private TextView VerPaises;
    private Spinner spi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_paises);

        //ASSOCIAR VARIAVÉIS JAVA COM OS RESPECTIVOS ELEMENTOS XML
        imgPaises = findViewById(R.id.imgp);
        VerPaises = findViewById(R.id.textView3);
        spi = findViewById(R.id.spinner2);

        //CONSTRUIR ARRAY ADAPTAR E CARREGAR NO SPINNER
        ArrayAdapter<String> valores = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, nomePaises);

        //ASSOCIAR O ARRAY AO SPINNER
        spi.setAdapter(valores);

        //APLICAR O CÓDIGO AO EVENTO DE SELEÇÃO DAS AÇÕES
        spi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                imgPaises.setImageResource(bandeiras[i]);
                VerPaises.setText(spi.getSelectedItem() + "\nCapital: "+capital[i]+ "" + "\nPopulação: "+populacao[i]+ "" + "\nLíngua Oficial: "+lingua[i]+ "" + "\nMoeda Oficial: "+moeda[i]+ "");
                Toast.makeText(VerPaises.this, spi.getSelectedItem() + "", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void voltaAoMenu(View v) {
        Intent it = new Intent(VerPaises.this, Menu.class);
        startActivity(it);
        finish();
    }
}