package com.example.olengcompany.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.olengcompany.MainActivity;
import com.example.olengcompany.R;
import com.example.olengcompany.loginregis.login;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class boardingkedua extends AppCompatActivity {
    FloatingActionButton next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boardingkedua);
        next = findViewById(R.id.floatscreenboardkedua);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(boardingkedua.this, login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}