package com.example.tarsbir.zoomcar;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        ImageView carImageView = findViewById(R.id.car_image_view);
        carImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent carImage = new Intent(Main2Activity.this, CarListActivity.class);
                startActivity(carImage);
            }
        });
        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        TextView signIn = headerView.findViewById(R.id.signIn_text_view);
        TextView signUp = headerView.findViewById(R.id.signUp_text_view);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signIn = new Intent(getApplicationContext(), SignInActivity.class);
                startActivity(signIn);
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUp = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(signUp);
            }
        });
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        // set item as selected to persist highlight
                        switch (menuItem.getItemId()) {
                            case R.id.cars: {
                                Intent carList = new Intent(getApplicationContext(), CarListActivity.class);
                                startActivity(carList);
                                return true;
                            }
                            case R.id.policies: {
                                Intent policies = new Intent(getApplicationContext(), PoliciesActivity.class);
                                startActivity(policies);
                                return true;
                            }
                            case R.id.help: {
                                Intent help = new Intent(getApplicationContext(), HelpActivity.class);
                                startActivity(help);
                                return true;
                            }
                        }
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
