package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent=getIntent();

        String username=intent.getStringExtra("username");
        String password=intent.getStringExtra("password");

        TextView tvUsername=findViewById(R.id.tv_username);
        TextView tvPassword=findViewById(R.id.tv_password);

        tvUsername.setText(username);
        tvPassword.setText(password);

    }
}
