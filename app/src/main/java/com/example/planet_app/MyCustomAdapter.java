package com.example.planet_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<planet> {

    //using custom layout --> MyCustomAdapter
    //using custom objects--> extents ArrayAdapter<plant>
    // planet because we are using modal class to de define our own created data

    private ArrayList<planet>planetArrayList;
    Context context;

    public MyCustomAdapter( ArrayList<planet> planetArrayList, Context context1) {
        super(context1, R.layout.list_item_layout, planetArrayList);
        this.planetArrayList = planetArrayList;
        this.context = context1;
    }

   private static class MyViewHolder{

        TextView planetName, moonCount;
        ImageView planetImg;
   }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        planet planet = getItem(position);

        MyViewHolder myViewHolder;
        final View result;

        if(convertView== null){
            myViewHolder= new MyViewHolder();
            LayoutInflater inflater= LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.list_item_layout,
                    parent,
                    false
            );

            myViewHolder.planetName= (TextView) convertView.findViewById(R.id.textView);
            myViewHolder.moonCount= (TextView) convertView.findViewById(R.id.textView2);
            myViewHolder.planetImg= (ImageView) convertView.findViewById(R.id.imageView);

            result = convertView;

            convertView.setTag(myViewHolder);

        }else{

            myViewHolder=(MyViewHolder) convertView.getTag();
            result = convertView;

        }

        myViewHolder.planetName.setText(planet.getPlanetName());
        myViewHolder.moonCount.setText(planet.getMoonCount());
        myViewHolder.planetImg.setImageResource(planet.getPlanetImage());

        return result;
    }
}
