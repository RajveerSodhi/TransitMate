package com.example.transitmate;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ameyMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ameyactivity_main);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button submitButton = findViewById(R.id.submitbutton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the NextActivity upon clicking the Submit button
                Intent intent = new Intent(ameyMainActivity.this, step4_payment_screen2.class);
                startActivity(intent);
            }
        });
    }
}