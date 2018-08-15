package com.example.tarsbir.zoomcar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class BookActivity extends AppCompatActivity {
    EditText name;
    EditText km;
    EditText day;
    EditText phoneno;
    EditText address;
    Button bookButton, checkFare, checkFareWithoutFuel, bookWithoutButton;
    TextView fareShow;


    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        intentCall();
        name = findViewById(R.id.name_edit_textId);
        km = findViewById(R.id.km_edit_textId);
        day = findViewById(R.id.day_edit_textId);
        phoneno = findViewById(R.id.phone_edit_textId);
        address = findViewById(R.id.address_edit_textId);
        bookButton = findViewById(R.id.book_buttonId_book_activity);
        bookWithoutButton = findViewById(R.id.bookWithoutNew_buttonId_book_activity);
        fareShow = findViewById(R.id.show_fare);
        checkFare = findViewById(R.id.fareCheck_withFuel_buttonId_book_activity);
        checkFareWithoutFuel = findViewById(R.id.fareCheck_without_buttonId_book_activity);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference().child("message");


        String ola = km.getText().toString();
        String nm = name.getText().toString();

        //check Fare Method
        checkFare.setOnClickListener(v -> {
            if (km.getText().toString().isEmpty() || day.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Enter km and Day", Toast.LENGTH_LONG).show();
            } else {
                int a = Integer.parseInt(km.getText().toString());
                int b = Integer.parseInt(day.getText().toString());
                a = 10 * a;
                b = 300 * b;
                int c = a + b;
                //fareShow.setText("Total fare");
                fareShow.setText(String.valueOf(c));
            }
        });


        checkFareWithoutFuel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (day.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter Day", Toast.LENGTH_LONG).show();
                } else {
                    int b = Integer.parseInt(day.getText().toString());
                    b = 300 * b;
                    int c = b;
                    //fareShow.setText("Total fare");
                    fareShow.setText(String.valueOf(b));
                }
            }
        });

        //Booking for car
        bookButton.setOnClickListener(v -> {
            if (name.getText().toString().isEmpty() || km.getText().toString().isEmpty() || day.getText().toString().isEmpty() || phoneno.getText().toString().isEmpty() || address.getText().toString().isEmpty()) {
                Toast.makeText(BookActivity.this, "Fill blank", Toast.LENGTH_SHORT).show();


            }
            if (phoneno.getText().toString().trim().length() < 9) {
                Toast.makeText(getApplicationContext(), "Fill correct Mobile Number", Toast.LENGTH_LONG).show();
            } else {
                //Toast.makeText(BookActivity.this, "Thanks for Booking", Toast.LENGTH_LONG).show();
                //String keyName="Name",keyKm ="KM",user="User";
                Map<String, Object> taskMap = new HashMap<>();
                taskMap.put("Name", name.getText().toString());
                taskMap.put("km", km.getText().toString());
                taskMap.put("Day", day.getText().toString());
                taskMap.put("PhoneNo", phoneno.getText().toString());
                taskMap.put("Address", address.getText().toString());
                mDatabaseReference.push().setValue(taskMap);

                succesIntent();
            }
        });

        //Booking Without Fuel for new car
        bookWithoutButton.setOnClickListener(v -> {
            if (name.getText().toString().isEmpty() || day.getText().toString().isEmpty() || phoneno.getText().toString().isEmpty() || address.getText().toString().isEmpty()) {
                Toast.makeText(BookActivity.this, "Fill blank", Toast.LENGTH_SHORT).show();


            }
            if (phoneno.getText().toString().trim().length() < 9) {
                Toast.makeText(getApplicationContext(), "Fill correct Mobile Number", Toast.LENGTH_LONG).show();
            } else {
                //Toast.makeText(BookActivity.this, "Thanks for Booking", Toast.LENGTH_LONG).show();
                //String value keyName="Name",keyKm ="KM",user="User";
                Map<String, Object> taskMap = new HashMap<>();
                taskMap.put("Name", name.getText().toString());
                taskMap.put("Without Fuel km", km.getText().toString());
                taskMap.put("Day", day.getText().toString());
                taskMap.put("PhoneNo", phoneno.getText().toString());
                taskMap.put("Address", address.getText().toString());
                mDatabaseReference.push().setValue(taskMap);

                succesIntent();
            }
        });


    }

    public void intentCall() {
        Intent in = getIntent();
        TextView car_name = findViewById(R.id.car_name_inBook_display);
        TextView seater = findViewById(R.id.seater_inBook_name_display);
        //ImageView img =findViewById(R.id.art_imageView);
        car_name.setText(in.getStringExtra("Car Name"));
        seater.setText(in.getStringExtra("Seater"));

    }

    public void succesIntent() {
        Intent success = new Intent(getApplicationContext(), SuccessActivity.class);
        success.putExtra("cabNo", "PB01 H 6106");
        success.putExtra("Name", name.getText().toString());
        success.putExtra("Phone No", phoneno.getText().toString());
        success.putExtra("Address", address.getText().toString());
        startActivity(success);

    }
}
