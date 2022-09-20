package com.example.olengcompany.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.olengcompany.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class boardingpertama extends AppCompatActivity {
    FloatingActionButton next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boardingpertama);
        next = findViewById(R.id.floatscreenboardpertama);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(boardingpertama.this, boardingkedua.class);
                startActivity(intent);
                finish();
            }
        });
    }
}