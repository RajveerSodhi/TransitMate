package com.example.transitmate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import android.content.Intent;


public class Home extends Fragment {

    TextView homeTitle;
    ImageView imageButton;

    public Home(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        homeTitle = (TextView) view.findViewById(R.id.homeTitle);
        imageButton = view.findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // This method will be called when the ImageView is clicked
                launchSettings();
            }
        });




        return view;
    }
    private void launchSettings() {
        // Your logic to launch settings goes here
        // For example, you can start a new activity
        Intent intent = new Intent(getActivity(), Settings.class);
        startActivity(intent);
    }
}



