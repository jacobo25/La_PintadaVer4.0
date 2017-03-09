package com.example.jacobo.la_pintada;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText eLUsuario, eLClave;
    Button bLIniciar;
    TextView tLRegistrarse;

    String Usuario="",Clave="",Correo="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eLUsuario = (EditText) findViewById(R.id.eLUsuario);
        eLClave = (EditText) findViewById(R.id.eLClave);
        bLIniciar = (Button) findViewById(R.id.bLIniciar);
        tLRegistrarse = (TextView) findViewById(R.id.tLRegistrarse);

        tLRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivityForResult(intent,1234);
           }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == 1234 && resultCode == RESULT_OK){
            Usuario = data.getExtras().getString("Usuario");
            Clave = data.getExtras().getString("Contraseña");
            Correo = data.getExtras().getString("Correo");
        }
    }

    public void Inicio(View view){

        if ( (eLUsuario.getText().toString().matches("")) || ( eLClave.getText().toString().matches("") ) ){
            Toast.makeText(this,R.string.faltan_datos,Toast.LENGTH_SHORT).show();
        }
        else if (eLUsuario.getText().toString().equals(Usuario) && (eLClave.getText().toString().equals(Clave))){

            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra("Usuario",Usuario);
            intent.putExtra("Contraseña",Clave);
            intent.putExtra("Correo",Correo);
            startActivity(intent);
            finish();
        }
        else {
            Toast.makeText(this,getString(R.string.incorrecto),Toast.LENGTH_SHORT).show();
        }

    }
}
