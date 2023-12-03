package com.example.transitmate;

import static androidx.core.content.ContentProviderCompat.requireContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ameyMainActivit extends AppCompatActivity {
    ImageView backButton;


    public ameyMainActivit(){
        // require a empty public constructor
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.ameyactivity_main, container, false);
//
//        backButton = view.findViewById(R.id.backImageButton);
//
//        backButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Home home = new Home();
//                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
//                transaction.replace(R.id.flFragment, home);
//                transaction.addToBackStack(null);
//                transaction.commit();
//            }
//        });
//        return view;

    }
