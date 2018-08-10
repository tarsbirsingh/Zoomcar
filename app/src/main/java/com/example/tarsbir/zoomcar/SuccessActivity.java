package com.example.tarsbir.zoomcar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        Intent successIn = getIntent();
        TextView cab_name = findViewById(R.id.cab_no_TextID_success);
        TextView name = findViewById(R.id.name_Id_sccess);
        TextView phnNO = findViewById(R.id.phn_Id_sccess);
        TextView address = findViewById(R.id.address_Id_sccess);
        cab_name.setText(successIn.getStringExtra("cabNo"));
        name.setText(successIn.getStringExtra("Name"));
        phnNO.setText(successIn.getStringExtra("Phone No"));
        address.setText(successIn.getStringExtra("Address"));


    }
}
