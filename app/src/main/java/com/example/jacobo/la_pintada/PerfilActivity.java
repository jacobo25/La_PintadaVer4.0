package com.example.jacobo.la_pintada;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {

    TextView tNombre,tCorreo;
    String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tNombre = (TextView) findViewById(R.id.tPUsuario);
        tCorreo = (TextView) findViewById(R.id.tPCorreo);

        SharedPreferences datos = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String Usuario = ": "+datos.getString("usuario","");
        String Correo = ": "+datos.getString("correo","");
        tNombre.setText(getString(R.string.usuario)+Usuario);
        tCorreo.setText(getString(R.string.correo)+Correo);
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
            case R.id.mPerfil: break;

            case R.id.mCerrar:
                Intent b = new Intent(this,LoginActivity.class);
                startActivity(b);
                finish();
                break;
            case R.id.mHoteles:
                Intent b2 = new Intent(this,HotelActivity.class);
                startActivity(b2);
                finish();
                break;

            case R.id.mPrincipal:
                Intent b5 = new Intent(this,MainActivity.class);
                startActivity(b5);
                finish();

                break;
            case R.id.mRestaurantes:
                Intent b3 = new Intent(this,RestActivity.class);
                startActivity(b3);
                finish();

                break;
            case R.id.mSitios:
                Intent b4 = new Intent(this,SitiosActivity.class);

                startActivity(b4);
                finish();

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
