package com.example.jacobo.la_pintada;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Fragmento para la sección de "Inicio"
 */
public class FragmentoInicio extends Fragment {

    Intent intent;

    private Lista_Entrada[] datos = new Lista_Entrada[] {
            new Lista_Entrada(R.drawable.lapintada, "Información"),
            new Lista_Entrada(R.drawable.historia, "Historia"),
            new Lista_Entrada(R.drawable.simbolos, "Símbolos"),
            new Lista_Entrada(R.drawable.geografia, "Geografía")
    };

    public FragmentoInicio() {}

    ListView list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragmento_inicio, container, false);

        list = (ListView) view.findViewById(R.id.lista);
        Adapter adapter = new Adapter(getContext(),datos);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = ((Lista_Entrada)parent.getItemAtPosition(position)).getNombre();

                int sel = (int) parent.getItemIdAtPosition(position);

                switch (sel) {
                    case 0:
                        Fragment fragment = new InformacionFragment();
                        FragmentActivity myContext = (FragmentActivity) getActivity();
                        myContext.getSupportFragmentManager().beginTransaction().replace(R.id.Contenedor,fragment).commit();
                        break;
                    case 1:
                        Fragment fragment1 = new HistoriaFragment();
                        FragmentActivity myContext1 = (FragmentActivity) getActivity();
                        myContext1.getSupportFragmentManager().beginTransaction().replace(R.id.Contenedor,fragment1).commit();
                        break;
                    case 2:
                        Fragment fragment2 = new SimbolosFragment();
                        FragmentActivity myContext2 = (FragmentActivity) getActivity();
                        myContext2.getSupportFragmentManager().beginTransaction().replace(R.id.Contenedor,fragment2).commit();
                        break;
                    case 3:
                        Fragment fragment3 = new GeografiaFragment();
                        FragmentActivity myContext3 = (FragmentActivity) getActivity();
                        myContext3.getSupportFragmentManager().beginTransaction().replace(R.id.Contenedor,fragment3).commit();
                        break;
                }
            }
        });
        return view;
    }


    public class Adapter extends ArrayAdapter<Lista_Entrada> {

        public Adapter(Context context, Lista_Entrada[] datos) {
            super(context, R.layout.listview_item, datos);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listview_item, null,true);

            TextView nombre = (TextView) item.findViewById(R.id.tNombre);
            nombre.setText(datos[position].getNombre());

            ImageView imagen = (ImageView) item.findViewById(R.id.iFoto);
            imagen.setImageResource(datos[position].getIdImagen());

            return item;
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

    }
}