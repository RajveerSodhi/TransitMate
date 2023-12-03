package com.example.transitmate;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.*;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class DriverFragment extends Fragment implements OnMapReadyCallback{

//    TextView newTripTitle;

    ImageView backButton;
    GoogleMap gMap;

    public DriverFragment(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_driverprofile, container, false);

//        newTripTitle = (TextView) view.findViewById(R.id.newTripTitle);

        backButton = view.findViewById(R.id.backImageButton);
//        passengerButton=view.findViewById(R.id.passengerButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Home homeFragment = new Home();

                // Replace the current fragment with the Home fragment
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.flFragment, homeFragment);
                transaction.addToBackStack(null);
                transaction.commit(); //change the horizontal menu bar to show Home.
            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        return view;
    }
    public void onMapReady (GoogleMap googleMap) {
        gMap = googleMap;
        gMap.moveCamera( CameraUpdateFactory.newLatLngZoom(new LatLng(49.8801, -119.4402) , 11.5f) );
        gMap.getUiSettings().setZoomControlsEnabled(true);

        gMap.addMarker(new MarkerOptions().position(new LatLng(49.8801, -119.4402)));
        gMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            public boolean onMarkerClick (Marker marker) {
                if (marker.getPosition().latitude == 49.8801) marker.setTitle("Kelowna");
                return false;
            }
        });
    }


}


