package com.example.jacobo.la_pintada;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    EditText eRUsuario, eRClave1, eRClave2, eRCorreo;
    Button bRAceptar, bRCancelar;
    String PREFS_NAME = "MyPrefsFile";
    SharedPreferences datos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        eRUsuario = (EditText) findViewById(R.id.eRUsuario);
        eRClave1 = (EditText) findViewById(R.id.eRClave1);
        eRClave2 = (EditText) findViewById(R.id.eRClave2);
        eRCorreo = (EditText) findViewById(R.id.eRCorreo);
        bRAceptar = (Button) findViewById(R.id.bRAceptar);
        bRCancelar = (Button) findViewById(R.id.bRCancelar);

        datos = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);


    }

    public void click(View v) {
        Intent i = new Intent();
        switch (v.getId()) {

            case R.id.bRAceptar:
                if ((eRUsuario.getText().toString().matches("")) || (eRClave1.getText().toString().matches("")) ||
                        (eRClave2.getText().toString().matches("")) || (eRCorreo.getText().toString().matches(""))) {
                    Toast.makeText(this, "Faltan Datos", Toast.LENGTH_SHORT).show();
                } else if (!eRClave2.getText().toString().matches(eRClave1.getText().toString())) {

                    eRClave1.setError("Las contraseñas no son iguales");
                } else {

                    SharedPreferences.Editor edit = datos.edit();
                    edit.putString("Usuario", eRUsuario.getText().toString());
                    edit.putString("Contraseña", eRClave1.getText().toString());
                    edit.putString("Correo", eRCorreo.getText().toString());
                    edit.commit();

                    i.putExtra("Usuario", eRUsuario.getText().toString());
                    i.putExtra("Contraseña", eRClave1.getText().toString());
                    i.putExtra("Correo", eRCorreo.getText().toString());
                    setResult(RESULT_OK, i);
                    finish();
                }
                break;
            case R.id.bRCancelar:
                setResult(RESULT_CANCELED, i);
                finish();
                break;

        }

    }
}