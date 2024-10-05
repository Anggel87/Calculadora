package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCA, btnC, btnPorcentaje, btnEntre, btnPor, btnMenos, btnMas, btnIgual, btnPunto, btn1, btn2,
    btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //super para llamar el metodo de una clase mayor, o sea la del padre
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnCA = (Button) findViewById(R.id.btnCA); // Todos los elementos de xml son vistas
        btnC = (Button) findViewById(R.id.btnC);
        btnPorcentaje = (Button) findViewById(R.id.btnPorcentaje);
        btnEntre = (Button) findViewById(R.id.btnEntre);
        btnPor = (Button) findViewById(R.id.btnPor);
        btnMenos = (Button) findViewById(R.id.btnMenos);
        btnMas = (Button) findViewById(R.id.btnMas);
        btnIgual = (Button) findViewById(R.id.btnIgual);
        btnPunto = (Button) findViewById(R.id.btnPunto);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn0 = (Button) findViewById(R.id.btn0);

        btn0.setOnClickListener(this); // esto es el main activity transformado en listener :v

        btnCA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Hermano realmente es un papoi", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void BotonPrueba(View view){
        Toast.makeText(this,"Otra forma de hacerlo xdxdxd",Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View view) { // este es para el listener del main activity (this)

    }
}