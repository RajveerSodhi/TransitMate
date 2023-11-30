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

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewTrip.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


        return view;
    }

//    private void launchHome() {
//        Fragment homeFragment=new Home();
//        FragmentTransaction tr=getActivity().getSupportFragmentManager().beginTransaction();
//        tr.replace(R.id.home_fragment_container, homeFragment);
//        tr.addToBackStack(null);
//        tr.commit();
//    }


}