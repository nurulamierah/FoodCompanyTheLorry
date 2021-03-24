package com.example.foodcompanythelorry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ArrayList<Restaurants> mRestaurantArrayList= new ArrayList<>();
    RestaurantAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeData();

        ImageView back = findViewById(R.id.backbutton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                moveTaskToBack(true);
            }
        });
    }

    private void initializeData() {
        mRestaurantArrayList.clear();
        mRestaurantArrayList.add(new Restaurants("Warung Kafe", "Asian", "5", "12, Jalan 6/62a, Bandar Menjalara, 52200 Kuala Lumpur, Wilayah Persekutuan Kuala Lumpur", "https://www.google.com/maps/search/?api=1&query=warung+king+mat+nor", R.drawable.warungking));
        mRestaurantArrayList.add(new Restaurants("Pizza", "Western", "3.5", "17, Jalan Medan Putra 1, Bandar Menjalara, 52200 Kuala Lumpur, Wilayah Persekutuan Kuala Lumpur", "https://www.google.com/maps/search/?api=1&query=pizza+roma+menjalara", R.drawable.pizza));
        mRestaurantArrayList.add(new Restaurants("Bakery Shop", "Pastry", "4", "Prima Selayang, 68100 Batu Caves, Selangor", "https://www.google.com/maps/search/?api=1&query=eco+bakery+selayang", R.drawable.bakeryshop));
        mRestaurantArrayList.add(new Restaurants("Chicken Rice", "Asian", "2.5", "Jalan Metro Perdana Timur 1, Taman Usahawan Kepong, 52100 Kuala Lumpur, Wilayah Persekutuan Kuala Lumpur", "https://www.google.com/maps/search/?api=1&query=Abang+Black+Corner+Laman+Rimbunan", R.drawable.cikenrais));
        mRestaurantArrayList.add(new Restaurants("Talam Shop", "Western", "4.5", "lot 5482, jalan iskandar, batu 8 1/2, Kampung Bukit Kapar, 42200 Kapar, Selangor", "https://www.google.com/maps/search/?api=1&query=DWesturn+Talam", R.drawable.talam));
        mRestaurantArrayList.add(new Restaurants("Vege Cafe","Vegeterian", "3", "20, Jalan 8/62a, Bandar Menjalara, 52200 Kuala Lumpur, Wilayah Persekutuan Kuala Lumpur", "https://www.google.com/maps/search/?api=1&query=Jujube+Vegetarian+House+Manjalara", R.drawable.vegcafe));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new RestaurantAdapter(mRestaurantArrayList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

   /* public void onClickFilterButton(View view) {
        Button button = findViewById(view.generateViewId());
        String buttonText = button.getText().toString();
        mAdapter.filterFoodType(buttonText);
    }*/

    /*public void filterButton(String type){
        mAdapter.filterFoodType(type);
    }*/
}