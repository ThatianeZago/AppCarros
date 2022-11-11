package com.example.appcarros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ConverteMoeda extends AppCompatActivity {

    //DECLARAR O ARRAY COM AS MOEDAS
    private String[] moeda = new String[]{"EUR - Euro", "BRA - Real brasileiro", "USD - Dólar americano", "GBP - Libra esterlina britânica"};

    //CRIAR VARIÁVEIS DO TIPO DE ELEMENTOS EXISTENTES NO XML
    private TextView ConverteFinal;
    private Spinner spi1, spi2;
    private EditText ConverteInicial;
    private int val1,val2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converte_moeda);

        //ASSOCIAR VARIAVÉIS JAVA COM OS RESPECTIVOS ELEMENTOS XML
        ConverteInicial = findViewById(R.id.inicial);
        ConverteFinal = findViewById(R.id.final1);
        spi1 = findViewById(R.id.spinner3);
        spi2 = findViewById(R.id.spinner4);

        //CONSTRUIR ARRAY ADAPTAR E CARREGAR NO SPINNER
        ArrayAdapter<String> valores = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, moeda);

        //ASSOCIAR O ARRAY AO SPINNER
        spi1.setAdapter(valores);
        spi2.setAdapter(valores);
    }

    public void converter(View v) {
        val1 = spi1.getSelectedItemPosition();
        val2 = spi2.getSelectedItemPosition();
        double qtd = Double.parseDouble(ConverteInicial.getText().toString());

        Toast.makeText(this, "op2: "+val1, Toast.LENGTH_SHORT).show();
       // System.out.println("op1: "+val1);
        switch (val1) {
            case 0:
                switch (val2) {
                    case 0:
                        ConverteFinal.setText(String.format(qtd+ "€"));
                        break;
                    case 1:
                        ConverteFinal.setText(String.format("%.2f",qtd * 5.30) +"R$");
                        break;
                    case 2:
                        ConverteFinal.setText(String.format("%.2f",qtd * 1.00) +"$");
                        break;
                    case 3:
                        ConverteFinal.setText(String.format("%.2f", qtd * 0.87) +"£");
                        break;
                }
                break;
            case 1:
                switch (val2) {
                    case 0:
                        ConverteFinal.setText(String.format("%.2f" ,qtd * 0.18) +"€");
                        break;
                    case 1:
                        ConverteFinal.setText(String.format(qtd + "R$"));
                        break;
                    case 2:
                        ConverteFinal.setText(String.format("%.2f", qtd * 0.18) +"$");
                        break;
                    case 3:
                        ConverteFinal.setText(String.format("%.2f", qtd * 0.16) +"£");
                        break;
                }
                break;
            case 2:
                switch (val2) {
                    case 0:
                        ConverteFinal.setText(String.format("%.2f", qtd * 0.99) +"€");
                        break;
                    case 1:
                        ConverteFinal.setText(String.format("%.2f",qtd * 5.26) +"R$");
                        break;
                    case 2:
                        ConverteFinal.setText(String.format( qtd + "$"));
                        break;
                    case 3:
                        ConverteFinal.setText(String.format("%.2f", qtd * 0.86) +"£");
                        break;
                }
                break;
            case 3:
                switch (val2) {
                    case 0:
                        ConverteFinal.setText(String.format("%.2f" ,qtd * 1.14) +"€");
                        break;
                    case 1:
                        ConverteFinal.setText(String.format("%.2f" ,qtd * 6.05) +"R$");
                        break;
                    case 2:
                        ConverteFinal.setText(String.format("%.2f" ,qtd * 1.15) +"$");
                        break;
                    case 3:
                        ConverteFinal.setText(String.format(qtd + "£"));
                        break;
                }
                break;
        }

    }

    public void voltaAoMenu(View v) {
        Intent it = new Intent(ConverteMoeda.this, Menu.class);
        startActivity(it);
        finish();
    }
}