package com.example.tripprogressmap;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.Polyline;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class TripProgressActivity extends AppCompatActivity {

    Button shareButton, rateButton, helpButton;
    ImageButton tripProgBack;
    Bundle tripInfo;
    TextView pickup, destin, price, driver, dandt, eta, distance;
    MapView mapView;
    Polyline routePolyline;
    LatLng OL, DL;
    GoogleMap gmap;
    Marker originMarker, destMarker;
    double specificLatitude = 50.112778;  // Replace with your desired latitude
    double specificLongitude = -120.789719;  // Replace with your desired longitude
    LatLng specificLatLng = new LatLng(specificLatitude, specificLongitude);



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_progress);

        OL = specificLatLng;
        //OL = TripPassengerFragment.originLatLng;
        DL = TripPassengerFragment.destinationLatLng;

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
        mapView = (MapView) findViewById(R.id.mapProgress);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync((OnMapReadyCallback) this);

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

    //CODE REFERRED FROM https://www.digitalocean.com/community/tutorials/android-google-map-drawing-route-two-points
    // ALSO HELP WAS TAKEN FROM https://developers.google.com/maps/documentation/android-sdk/polygon-tutorial API DEVELOPMENT KIT

    public void onMapReady(GoogleMap googleMap) {
        gmap = googleMap;
        originMarker = gmap.addMarker(new MarkerOptions().position(OL).title("Origin"));
        destMarker = gmap.addMarker(new MarkerOptions().position(DL).title("Destination"));
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(originMarker.getPosition());
        builder.include(destMarker.getPosition());
        LatLngBounds bounds = builder.build();
        gmap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 100));

        String directionsUrl = "https://maps.googleapis.com/maps/api/directions/json" +
                "?origin=" + OL.latitude+","+OL.longitude +"&destination=" + DL.latitude+","+DL.longitude + "&key=AIzaSyCGzZ4JWj8C2SMqGkvkuCpbZiIj0lzM9QY";
        new FetchDirectionsTask().execute(directionsUrl);
    }
    private class FetchDirectionsTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder result = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

                return result.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        @SuppressLint("StaticFieldLeak")
        @Override
        protected void onPostExecute(String directionsData) {
            if (directionsData != null) {
                Log.d("DirectionsData", directionsData);
                drawRoute(directionsData);
            }
        }
    }
    private void drawRoute(String directionsData) {
        try {
            JSONObject jsonObject = new JSONObject(directionsData);
            JSONArray routes = jsonObject.getJSONArray("routes");

            if (routes.length() > 0) {
                JSONObject route = routes.getJSONObject(0);
                JSONObject overviewPolyline = route.getJSONObject("overview_polyline");
                String encodedPolyline = overviewPolyline.getString("points");
                List<LatLng> decodedPolyline = PolyUtil.decode(encodedPolyline);
                PolylineOptions options = new PolylineOptions()
                        .addAll(PolyUtil.decode(encodedPolyline))
                        .color(Color.BLUE)
                        .width(10);
                routePolyline = gmap.addPolyline(options);

                routePolyline = gmap.addPolyline(options);
                for (LatLng point : decodedPolyline) {
                    Log.d("PolylinePoint", "Lat: " + point.latitude + ", Lng: " + point.longitude);
                    Log.d("Polyline", "Number of points: " + decodedPolyline.size());
                }

                // Move camera to show both markers and the route
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                builder.include(originMarker.getPosition());
                builder.include(destMarker.getPosition());
                for (LatLng point : decodedPolyline) {
                    builder.include(point);
                }
                LatLngBounds bounds = builder.build();
                gmap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 200));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}