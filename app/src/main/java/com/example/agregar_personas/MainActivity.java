package com.example.agregar_personas;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombres;
    private EditText apellidos;
    private EditText edad;
    private EditText correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombres = findViewById(R.id.txt_nombres);
        apellidos = findViewById(R.id.txt_apellidos);
        edad = findViewById(R.id.txtedad);
        correo = findViewById(R.id.txt_correo);

        Button btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombresStr = nombres.getText().toString().trim();
                String apellidosStr = apellidos.getText().toString().trim();
                String edadStr = edad.getText().toString().trim();
                String correoStr = correo.getText().toString().trim();

                if (TextUtils.isEmpty(nombresStr)) {
                    nombres.setError("Este campo es obligatorio");
                    nombres.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(apellidosStr)) {
                    apellidos.setError("Este campo es obligatorio");
                    apellidos.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(edadStr)) {
                    edad.setError("Este campo es obligatorio");
                    edad.requestFocus();
                    return;
                }

                int edadInt;
                try {
                    edadInt = Integer.parseInt(edadStr);
                } catch (NumberFormatException e) {
                    edad.setError("Ingrese una edad válida");
                    edad.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(correoStr)) {
                    correo.setError("Este campo es obligatorio");
                    correo.requestFocus();
                    return;
                }

                Intent persona = new Intent(MainActivity.this, PersonaActivity.class);
                persona.putExtra("nombres", nombresStr);
                persona.putExtra("apellidos", apellidosStr);
                persona.putExtra("edad", edadStr);
                persona.putExtra("correo", correoStr);
                startActivity(persona);
                Toast.makeText(MainActivity.this, "Persona agregada correctamente", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
