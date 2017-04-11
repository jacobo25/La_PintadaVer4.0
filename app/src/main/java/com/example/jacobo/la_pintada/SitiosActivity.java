package com.example.jacobo.la_pintada;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class SitiosActivity extends AppCompatActivity {

    String Usuario, Correo;
    Intent intent;
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
      private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
     private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitios);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        Bundle extras = getIntent().getExtras();
        Usuario = extras.getString("Usuario");
        Correo = extras.getString("Correo");

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

    public class PagerAdapter extends FragmentPagerAdapter{

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return super.getPageTitle(position);
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position){
                case 0: CerroFragment tab1 = new CerroFragment();
                    return tab1;
                case 1: EstacionFragment tab2 = new EstacionFragment();
                    return tab2;
                case 2: FarallonesFragment tab3 = new FarallonesFragment();
                    return tab3;
                default: return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getString(R.string.titulocerro);
                case 1:
                    return getResources().getString(R.string.tituloestacion);
                case 2:
                    return getResources().getString(R.string.titulofarallones);
            }
            return null;
        }
    }
}
