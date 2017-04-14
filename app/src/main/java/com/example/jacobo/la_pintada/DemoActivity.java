package com.example.jacobo.la_pintada;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class DemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();

        DinastiaFragment fragment = new DinastiaFragment();
        //ft.add(android.R.id.content, fragment).commit();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
