package com.example.a03projetos_01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etGasolina, etEtanol;
    private Button btnCalcular;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGasolina = findViewById(R.id.et_gasolina);
        etEtanol = findViewById(R.id.et_etanol);
        btnCalcular = findViewById(R.id.btn_calcular);
        tvResultado = findViewById(R.id.tv_resultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }
        });
    }

    private void calcular() {
        String gasolinaStr = etGasolina.getText().toString();
        String etanolStr = etEtanol.getText().toString();

        if (!gasolinaStr.isEmpty() && !etanolStr.isEmpty()) {
            double precoGasolina = Double.parseDouble(gasolinaStr);
            double precoEtanol = Double.parseDouble(etanolStr);

            double porcentagem = (precoEtanol / precoGasolina) * 100;

            if (porcentagem <= 70) {
                tvResultado.setText("Compensa abastecer com Etanol!");
            } else {
                tvResultado.setText("Compensa abastecer com Gasolina!");
            }
        } else {
            Toast.makeText(this, "Por favor, insira os preços da Gasolina e do Etanol.", Toast.LENGTH_SHORT).show();
        }
    }
}
