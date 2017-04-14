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
public class MapaHotelesFragment extends Fragment implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap mMap;

    public MapaHotelesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mapa_hoteles, container, false);

        mapView = (MapView) view.findViewById(R.id.MapaHoteles);
        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(this);

        // Inflate the layout for this fragment
        return view;


    }
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID); //tipo de mapa

        LatLng Hotel1 = new LatLng(5.758051703017709,-75.60471832752228);
        mMap.addMarker(new MarkerOptions().position(Hotel1).title("Hotel Real Dinastia"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Hotel1, 16));

        LatLng Hotel2 = new LatLng(5.747906641681119,-75.60601215809584);
        mMap.addMarker(new MarkerOptions().position(Hotel2).title("Hotel Sol Pintada"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Hotel2, 16));

        LatLng Hotel3 = new LatLng(5.74249711376311,-75.60992918908596);
        mMap.addMarker(new MarkerOptions().position(Hotel3).title("Hotel Villa Camila"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Hotel3, 16));
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
