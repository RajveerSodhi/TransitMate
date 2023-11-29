package com.example.transitmate;

import java.io.*;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;


public class Home extends Fragment {

    public Home(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public void launchSettings(View view) {
        Intent intent = new Intent(getActivity(), SettingsActivity.class);
        startActivity(intent);
    }

}