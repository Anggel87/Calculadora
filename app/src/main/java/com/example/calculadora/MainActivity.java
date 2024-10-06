package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String SUMA = "+";
    private final String RESTA = "-";
    private final String MULTI = "*";
    private final String DIVISION = "/";
    private final String PORCENTAJE = "%";

    private String operacionActual = "";
    private double primerNumero = Double.NaN;
    private double segundoNumero = Double.NaN;

    private TextView tvTemp;
    private TextView tvResult;

    private DecimalFormat formatoDecimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        formatoDecimal = new DecimalFormat("#.##########");

        // Inicializar los TextViews
        tvTemp = findViewById(R.id.tvTemp);
        tvResult = findViewById(R.id.tvResult);
    }

    public void cambiarOperador(View b) {
        if (!tvTemp.getText().toString().isEmpty() || !Double.isNaN(primerNumero)) {
            calcular(null);
            Button boton = (Button) b;

            if (!operacionActual.equals(boton.getText().toString().trim())) {
                operacionActual = boton.getText().toString().trim();
            }

            tvResult.setText(formatoDecimal.format(primerNumero) + " " + operacionActual);
            tvTemp.setText("");
        }
    }


    public void calcular(View b) {
        try {
            if (!Double.isNaN(primerNumero)) {
                if (tvTemp.getText().toString().isEmpty()) {
                    tvTemp.setText(tvResult.getText().toString());
                }

                segundoNumero = Double.parseDouble(tvTemp.getText().toString());
                tvTemp.setText("");

                switch (operacionActual) {
                    case "+":
                        primerNumero += segundoNumero;
                        break;
                    case "-":
                        primerNumero -= segundoNumero;
                        break;
                    case "*":
                        primerNumero *= segundoNumero;
                        break;
                    case "/":
                        if (segundoNumero != 0) {
                            primerNumero /= segundoNumero;
                        } else {
                            tvResult.setText(":'v");
                            return;
                        }
                        break;
                    case "%":
                        primerNumero = (primerNumero * segundoNumero) / 100;
                        break;
                }

                tvResult.setText(formatoDecimal.format(primerNumero));
            } else {
                primerNumero = Double.parseDouble(tvTemp.getText().toString());
            }
        } catch (Exception e) {
            tvResult.setText("Error");
        }
    }


    public void borrar(View b) {
        Button boton = (Button) b;
        if (boton.getText().toString().trim().equals("CA")) {
            primerNumero = Double.NaN;
            segundoNumero = Double.NaN;
            tvTemp.setText("");
            tvResult.setText("");
        }
    }


    public void seleccionarNumero(View b) {
        Button boton = (Button) b;
        if (tvTemp.getText().toString().equals("0")) {
            tvTemp.setText("");
        }
        tvTemp.setText(tvTemp.getText().toString() + boton.getText().toString());
    }

    public void igual(View b) {
        calcular(null);
        tvResult.setText(formatoDecimal.format(primerNumero));
        //primerNumero = Double.NaN;
        operacionActual = "";
    }

    public void BotonPrueba(View view) {
        Toast.makeText(this, "ejem ejem, no está implementado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        // Este es el listener principal, donde puedes manejar las acciones de cada botón.
    }
}
