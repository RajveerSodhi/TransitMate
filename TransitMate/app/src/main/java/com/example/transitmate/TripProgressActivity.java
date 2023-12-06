package com.example.transitmate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TripProgressActivity extends AppCompatActivity {

    Button shareButton, rateButton, helpButton;
    ImageButton tripProgBack;
    Bundle tripInfo;
    TextView pickup, destin, price, driver, dandt, eta, distance;

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
        tripProgBack = (ImageButton) findViewById(R.id.tripProgBack);
        eta = (TextView) findViewById(R.id.eta);
        distance = (TextView) findViewById(R.id.distance);
        tripInfo = getIntent().getExtras();

        pickup.setText(tripInfo.getString("pickup"));
        destin.setText(tripInfo.getString("dest"));
        driver.setText(tripInfo.getString("name"));
        dandt.setText(tripInfo.getString("dandt"));
        price.setText(tripInfo.getString("cost"));

        // TODO: set eta, distance
        // TODO: make sharebutton and helpbuton do something?
        // TODO: edit map

        rateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rateTrip = new Intent(TripProgressActivity.this, RateTripActivity.class);
                rateTrip.putExtras(tripInfo);
                startActivity(rateTrip);
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TripProgressActivity.this, "Trip Info Shared with Saved Contact", Toast.LENGTH_SHORT).show();
            }
        });

        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TripProgressActivity.this, "SOS sent to Emergency Contact and Police", Toast.LENGTH_SHORT).show();
            }
        });

        tripProgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TripProgressActivity.this, MainActivity.class));
            }
        });

    }
}