package com.example.jacobo.la_pintada;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity{

    TextView tPUsuario,tPCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tPUsuario = (TextView) findViewById(R.id.tPUsuario);
        tPCorreo = (TextView) findViewById(R.id.tPCorreo);

        Bundle extras= getIntent().getExtras();
        tPUsuario.setText(extras.getString("Usuario"));
        tPCorreo.setText(extras.getString("Correo"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.mPerfil:break;

            case R.id.mCerrar:
                Intent b = new Intent(this,LoginActivity.class);
                startActivity(b);
                finish();
                break;
            case R.id.mPrincipal:
                Intent a = new Intent(this,MainActivity.class);
                startActivity(a);
                finish();
                break;
        }

        return true;
    }
}
