package com.example.tarsbir.zoomcar;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread bk = new Thread() {
            public void run() {
                try {
                    sleep(3 * 1000);

                    Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                    startActivity(i);
                    finish();
                } catch (Exception e) {
                }
            }
        };
        bk.start();
    }
}