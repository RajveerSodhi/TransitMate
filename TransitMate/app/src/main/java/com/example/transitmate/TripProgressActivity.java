package com.example.transitmate;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TripProgressActivity extends AppCompatActivity {

    Button shareButton, rateButton, helpButton;
    TextView pickup, destin, price, driver, dandt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_progress);

        shareButton = (Button) findViewById(R.id.shareButton);
        rateButton = (Button) findViewById(R.id.rateButton);
        helpButton = (Button) findViewById(R.id.helpButton);
        pickup = (TextView) findViewById(R.id.pickup);
        destin = (TextView) findViewById(R.id.destin);
        price = (TextView) findViewById(R.id.price);
        driver = (TextView) findViewById(R.id.driver);
        dandt = (TextView) findViewById(R.id.dandt);



    }
}