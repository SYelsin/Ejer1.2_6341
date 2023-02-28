package com.example.agregar_personas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PersonaActivity extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtApellido;
    private EditText txtEdad;
    private EditText txtCorreo;

    public static final String EXTRA_NOMBRES = "nombres";
    public static final String EXTRA_APELLIDOS = "apellidos";
    public static final String EXTRA_EDAD = "edad";
    public static final String EXTRA_CORREO = "correo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona);

        txtNombre = findViewById(R.id.txtnombre);
        txtApellido = findViewById(R.id.txtapellido);
        txtEdad = findViewById(R.id.edad);
        txtCorreo = findViewById(R.id.txtcorreo);

        Intent intent = getIntent();
        String nombres = intent.getStringExtra(EXTRA_NOMBRES);
        String apellidos = intent.getStringExtra(EXTRA_APELLIDOS);
        String edad = intent.getStringExtra(EXTRA_EDAD);
        String correo = intent.getStringExtra(EXTRA_CORREO);

        if (nombres != null) {
            txtNombre.setText(nombres);
        }
        if (apellidos != null) {
            txtApellido.setText(apellidos);
        }
        if (edad != null) {
            txtEdad.setText(edad);
        }else{
            txtEdad.setText("No se recibio");
        }
        if (correo != null) {
            txtCorreo.setText(correo);
        }
        Button btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setValuesToFields(String nombres, String apellidos, String edad, String correo) {
        if (nombres != null) {
            txtNombre.setText(nombres);
        }
        if (apellidos != null) {
            txtApellido.setText(apellidos);
        }
        if (edad != null) {
            txtEdad.setText(edad);
        }
        if (correo != null) {
            txtCorreo.setText(correo);
        }
    }



}
