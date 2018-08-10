package com.example.tarsbir.zoomcar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class WelcomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Intent i = getIntent();
        if (i.hasExtra("Name")) {
            EditText t1 = findViewById(R.id.name_view);
            t1.setText(i.getStringExtra("Name"));
        }
    }
}