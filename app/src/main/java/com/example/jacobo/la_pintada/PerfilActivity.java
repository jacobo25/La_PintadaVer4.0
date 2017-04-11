package com.example.jacobo.la_pintada;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity{

    TextView tPUsuario,tPCorreo;
    Intent intent;
    String Usuario,Correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tPUsuario = (TextView) findViewById(R.id.tPUsuario);
        tPCorreo = (TextView) findViewById(R.id.tPCorreo);

        Bundle extras = getIntent().getExtras();
        Usuario = extras.getString("Usuario");
        Correo = extras.getString("Correo");

        tPUsuario.setText("NOMBRE: "+""+extras.getString("Usuario"));
        tPCorreo.setText("CORREO: "+""+extras.getString("Correo"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //noinspection SimplifiableIfStatement
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
