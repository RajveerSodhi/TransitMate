package com.example.transitmate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import android.content.Intent;


public class Home extends Fragment {

    TextView homeTitle;

    public Home(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        homeTitle = (TextView) view.findViewById(R.id.homeTitle);

        return view;
    }

    public void launchSettings(View view) {
        Intent intent = new Intent(getActivity(), SettingsActivity.class);
        startActivity(intent);
    }

}