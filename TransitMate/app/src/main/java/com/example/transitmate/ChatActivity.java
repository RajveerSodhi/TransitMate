package com.example.transitmate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChatActivity extends AppCompatActivity {

    ImageView textImg;
    TextView textName, msg1, msg2, msg3;
    Bundle textInfo;
    Context context;
    ImageButton backButton, sendButton;
    EditText msgBox;
    int msgCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        textName = (TextView) findViewById(R.id.textName);
        textImg = (ImageView) findViewById(R.id.textImg);
        backButton = (ImageButton) findViewById(R.id.backButtonChat);
        sendButton = (ImageButton) findViewById(R.id.sendButton);
        msgBox = (EditText) findViewById(R.id.messageBox);
        msg1 = (TextView) findViewById(R.id.msg1);
        msg2 = (TextView) findViewById(R.id.msg2);
        msg3 = (TextView) findViewById(R.id.msg3);
        textInfo = getIntent().getExtras();
        msgCount = 0;

        String name = textInfo.getString("Name", "No Name");
        String img = textInfo.getString("ImgResource", "profile_icon");
        context = this.getApplicationContext();

        textName.setText(name);
        textImg.setImageResource(context.getResources().getIdentifier("drawable/" + img, null, context.getPackageName()));

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToMessages = new Intent(ChatActivity.this, MainActivity.class);
                Bundle info = new Bundle();
                info.putString("fragment", "messages");
                backToMessages.putExtras(info);
                startActivity(backToMessages);

            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msgCount++;
                String msg = msgBox.getText().toString();
                if (msgCount == 1)  {
                    msg1.setText(msg);
                    msg1.setVisibility(View.VISIBLE);
                }
                else if (msgCount == 2) {
                    msg2.setText(msg);
                    msg2.setVisibility(View.VISIBLE);
                }
                else if (msgCount == 3) {
                    msg3.setText(msg);
                    msg3.setVisibility(View.VISIBLE);
                }
                msgBox.setText("");
            }
        });

    }
}