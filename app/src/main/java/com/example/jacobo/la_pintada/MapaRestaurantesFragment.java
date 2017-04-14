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
public class MapaRestaurantesFragment extends Fragment implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap mMap;

    public MapaRestaurantesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mapa_restaurantes, container, false);

        mapView = (MapView) view.findViewById(R.id.MapaRestaurantes);
        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(this);

        // Inflate the layout for this fragment
        return view;


    }
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID); //tipo de mapa

        LatLng Restaurante1 = new LatLng(5.741319, -75.606804);
        mMap.addMarker(new MarkerOptions().position(Restaurante1).title("Asados Doña Rosa"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Restaurante1, 16));

        LatLng Restaurante2 = new LatLng(5.741656, -75.606950);
        mMap.addMarker(new MarkerOptions().position(Restaurante2).title("Salpicolandia"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Restaurante2, 16));

        LatLng Restaurante3 = new LatLng(5.747209, -75.605973);
        mMap.addMarker(new MarkerOptions().position(Restaurante3).title("Estadero Las Monas"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Restaurante3, 16));
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
