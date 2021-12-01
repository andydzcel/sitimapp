package com.example.sitimappcolombia;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sitimappcolombia.modelos.Lugares;
import com.example.sitimappcolombia.viewmodels.LugarViewModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class fragmentMap extends DialogFragment {

    // TODO: Rename and change types of parameters
    private String nombre;
    private double latitud;
    private double longitud;

    public fragmentMap() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static fragmentMap newInstance(String nom, double lat, double lon) {
        fragmentMap fragment = new fragmentMap();
        Bundle args = new Bundle();
        args.putString("nombre", nom);
        args.putDouble("latitud", lat);
        args.putDouble("longitud", lon);
        fragment.setArguments(args);
        return fragment;
    }

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {

            if(latitud!=0&&longitud!=0){
            googleMap.clear();
            LatLng sydney = new LatLng(latitud, longitud);
            googleMap.addMarker(new MarkerOptions().position(sydney).title(nombre));
            googleMap.setMinZoomPreference(18);
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));}

            LugarViewModel vmlugares = ViewModelProviders.of(getActivity()).get(LugarViewModel.class);
            vmlugares.getLugar().observe(getViewLifecycleOwner(), new Observer<Lugares>() {
                @Override
                public void onChanged(Lugares lugares) {
                    googleMap.clear();
                    LatLng sydney = new LatLng(lugares.getLatitud(), lugares.getLongitud());
                    googleMap.addMarker(new MarkerOptions().position(sydney).title(lugares.getNombre()));
                    googleMap.setMinZoomPreference(12);
                    googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                }
            });



        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nombre = getArguments().getString("nombre");
            latitud = getArguments().getDouble("latitud");
            longitud = getArguments().getDouble("longitud");
        }

    }
}