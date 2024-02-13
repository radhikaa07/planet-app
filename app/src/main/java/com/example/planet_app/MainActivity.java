package com.example.planet_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     ListView listView;
     ArrayList<planet>plantsArrayList;

     @SuppressLint("StaticFieldLeak")
     private static MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= findViewById(R.id.listview);
        plantsArrayList = new ArrayList<>();

       planet planet1= new planet("earth","1 moon",R.drawable.earth );
       planet planet2 = new planet("mercury","0 moon", R.drawable.earth);
        planet planet3 = new planet("venus","0 moon", R.drawable.venus);
        planet planet4 = new planet("mars","0 moon", R.drawable.mars);
        planet planet5 = new planet("jupiter","0 moon", R.drawable.jupiter);
        planet planet6 = new planet("saturn","0 moon", R.drawable.saturn);
        planet planet7 = new planet("neptune","0 moon", R.drawable.neptune);

        plantsArrayList.add(planet1);
        plantsArrayList.add(planet2);
        plantsArrayList.add(planet3);
        plantsArrayList.add(planet4);
        plantsArrayList.add(planet5);
        plantsArrayList.add(planet6);
        plantsArrayList.add(planet7);

        adapter= new MyCustomAdapter(plantsArrayList, getApplicationContext());
        listView.setAdapter((adapter));

    }
}