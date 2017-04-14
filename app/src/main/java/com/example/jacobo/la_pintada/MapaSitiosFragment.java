package com.example.jacobo.la_pintada;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapaSitiosFragment extends Fragment implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap mMap;

    public MapaSitiosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mapa_sitios, container, false);

        mapView = (MapView) view.findViewById(R.id.MapaSitios);
        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(this);

        // Inflate the layout for this fragment
        return view;


    }
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID); //tipo de mapa

        LatLng Sitio1 = new LatLng(5.716461, -75.612907);
        mMap.addMarker(new MarkerOptions().position(Sitio1).title("Los Farallones"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Sitio1, 16));

        LatLng Sitio2 = new LatLng(5.746102, -75.605297);
        mMap.addMarker(new MarkerOptions().position(Sitio2).title("Antigua Estación del Ferrocarril"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Sitio2, 16));

        LatLng Sitio3 = new LatLng(5.766016, -75.584952);
        mMap.addMarker(new MarkerOptions().position(Sitio3).title("Cerro Amarillo"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Sitio3, 16));
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        mapView.onLowMemory();
        super.onLowMemory();
    }
}
