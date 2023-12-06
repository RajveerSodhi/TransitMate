package com.example.transitmate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmTripActivity extends AppCompatActivity {

    TextView pickup, dest, dandt, name, cost;
    Bundle driverInfo;
    ImageButton confirmBack;
    Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_trip);

        pickup = (TextView) findViewById(R.id.pickup);
        dest = (TextView) findViewById(R.id.destin);
        dandt = (TextView) findViewById(R.id.dandt);
        name = (TextView) findViewById(R.id.driver);
        cost = (TextView) findViewById(R.id.price);
        confirmBack = (ImageButton) findViewById(R.id.confirmBack);
        confirm = (Button) findViewById(R.id.confirm);

        driverInfo = getIntent().getExtras();
        pickup.setText(driverInfo.getString("pickup"));
        dest.setText(driverInfo.getString("dest"));
        name.setText(driverInfo.getString("name"));
        dandt.setText(driverInfo.getString("dandt"));
        cost.setText("CAD " + driverInfo.getString("cost"));

        // TODO: edit map

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToPaymentMethods = new Intent(ConfirmTripActivity.this, PaymentMethodsActivity.class);
                goToPaymentMethods.putExtras(driverInfo);
                startActivity(goToPaymentMethods);
            }
        });

        confirmBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToMessages = new Intent(ConfirmTripActivity.this, MainActivity.class);
                Bundle info = new Bundle();
                info.putString("fragment", "messages");
                backToMessages.putExtras(info);
                startActivity(backToMessages);
            }
        });



    }
}