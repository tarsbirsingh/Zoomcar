package com.example.tarsbir.zoomcar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CarListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<CustomCarList> CarList = new ArrayList<>();
    CarListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);

        recyclerView = findViewById(R.id.list_item);
        // Custom Adapter
        mAdapter = new CarListAdapter(CarList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        // OnClick on a song fromm the list
        recyclerView.addOnItemTouchListener(new RecyclerClickListener(getApplicationContext(), recyclerView, new RecyclerClickListener.ClickListener() {
            // Single Click
            @Override
            public void onClick(View view, int position) {
                // Launch the song player activity
                CustomCarList song = CarList.get(position);
                Intent intent = new Intent(getApplicationContext(), BookActivity.class);
                // pass the song information to be played
                intent.putExtra("Car Name", song.getCarName());
                intent.putExtra("Seater", song.getSeater());
                startActivity(intent);
            }


            @Override
            public void onLongClick(View view, int position) {
                // Do nothing for now
            }
        }));

        recyclerView.setAdapter(mAdapter);
        prepareSongsData();
    }

    private void prepareSongsData() {
        CarList.add(new CustomCarList("Ford Figo", "5 Seater", R.drawable.ffigo));
        CarList.add(new CustomCarList("Maruti Swift", "5 Seater", R.drawable.swift));
        CarList.add(new CustomCarList("Ford EcoSport", "5 Seater", R.drawable.ecs1));
        CarList.add(new CustomCarList("Mahindra Scorpio", "7 Seater", R.drawable.scorpio));
        CarList.add(new CustomCarList("Mahindra Kuv", "5Seater", R.drawable.kuv));

        mAdapter.notifyDataSetChanged();
    }
}