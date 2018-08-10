package com.example.tarsbir.zoomcar;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.MyViewHolder> {
    private List<CustomCarList> CarList;

    CarListAdapter(List<CustomCarList> CarList) {
        this.CarList = CarList;
    }

    @Override
    public int getItemCount() {
        return CarList.size();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.car_list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CustomCarList car = CarList.get(position);
        holder.carName.setText(car.getCarName());
        holder.seaterView.setText(car.getSeater());
        holder.carImage.setImageResource(car.getImageResource());
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView carName, seaterView;
        Button bookButton;
        ImageView carImage;

        MyViewHolder(View view) {
            super(view);
            carName = view.findViewById(R.id.car_name_text_viewID);
            seaterView = view.findViewById(R.id.seater_text_ViewID);
            // bookButton = view.findViewById(R.id.book_buttonID);
            carImage = view.findViewById(R.id.car_image_viewID);
        }
    }


}

