package com.example.jacobo.la_pintada;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    String Usuario, Correo;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        Usuario = extras.getString("Usuario");
        Correo = extras.getString("Correo");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu m) {
        getMenuInflater().inflate(R.menu.menu,m);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.mPerfil:
                intent = new Intent(this, PerfilActivity.class);
                intent.putExtra("Usuario",Usuario);
                intent.putExtra("Correo",Correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mPrincipal:
                intent = new Intent(this, MainActivity.class);
                intent.putExtra("Usuario",Usuario);
                intent.putExtra("Correo",Correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mHoteles:
                intent = new Intent(this, HotelActivity.class);
                intent.putExtra("Usuario",Usuario);
                intent.putExtra("Correo",Correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mSitios:
                intent = new Intent(this, SitiosActivity.class);
                intent.putExtra("Usuario",Usuario);
                intent.putExtra("Correo",Correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mRestaurantes:
                intent = new Intent(this, RestActivity.class);
                intent.putExtra("Usuario",Usuario);
                intent.putExtra("Correo",Correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mCerrar:
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);

    }
}
