package com.example.jacobo.la_pintada;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentoPerfil extends Fragment {
    TextView tPUsuario,tPCorreo;
    String PREFS_NAME = "MyPrefsFile";

    public FragmentoPerfil() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tPUsuario = (TextView) view.findViewById(R.id.tPUsuario);
        tPCorreo = (TextView) view.findViewById(R.id.tPCorreo);


        SharedPreferences datos = this.getActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String Usuario = ": "+datos.getString("Usuario","");
        String Correo = ": "+datos.getString("Correo","");
        Log.d("Usuario", Usuario);
        Log.d("Correo", Correo);
        tPUsuario.setText(getString(R.string.usuario)+Usuario);
        tPCorreo.setText(getString(R.string.correo)+Correo);
    }

}
