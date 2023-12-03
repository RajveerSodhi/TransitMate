package com.example.transitmate;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.*;
import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {


    ImageView backButton;
    Button editButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        backButton = findViewById(R.id.backImageButton);
        editButton=findViewById(R.id.edit);



        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch the Profile activity
                Intent intent = new Intent(Settings.this, Profile.class);
                startActivity(intent);
            }
        });
    }
    }
