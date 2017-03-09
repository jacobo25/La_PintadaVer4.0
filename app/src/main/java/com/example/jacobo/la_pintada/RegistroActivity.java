package com.example.jacobo.la_pintada;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    EditText eRUsuario, eRClave1, eRClave2, eRCorreo;
    Button bRAceptar,bRCancelar;

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
    }

    public void click(View view){
        Intent intent = new Intent();
        switch(view.getId()){
            case R.id.bRAceptar:
                if ((eRUsuario.getText().toString().matches("")) || (eRClave1.getText().toString().matches("")) || (eRClave2.getText().toString().matches("")) || (eRCorreo.getText().toString().matches(""))) {
                    Toast.makeText(this, R.string.faltan_datos, Toast.LENGTH_SHORT).show();
                }else if (!eRClave1.getText().toString().matches(eRClave2.getText().toString())) {
                    eRClave2.setError("La contraseña no coincide");
                }else {
                    intent.putExtra("Usuario", eRUsuario.getText().toString());
                    intent.putExtra("Contraseña", eRClave1.getText().toString());
                    intent.putExtra("Correo", eRCorreo.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                }
                break;
            case R.id.bRCancelar:
                setResult(RESULT_CANCELED, intent);
                finish();
                break;

        }
    }
}
