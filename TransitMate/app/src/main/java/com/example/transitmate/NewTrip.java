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

public class NewTrip extends Fragment {

    TextView newTripTitle;

    ImageView backButton;
    Button passengerButton;
    public NewTrip(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_trip, container, false);

        newTripTitle = (TextView) view.findViewById(R.id.newTripTitle);

        backButton = view.findViewById(R.id.backImageButton);
        passengerButton=view.findViewById(R.id.passengerButton);

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

        passengerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Call the new method to navigate to TripPassengerFragment
                TripPassengerFragment tripPassengerFragment = new TripPassengerFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.flFragment, tripPassengerFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        return view;
    }


}


