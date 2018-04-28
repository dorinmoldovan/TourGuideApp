package com.androidbasicsnd.android.tourguideapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<Location> {

    private int color;

    public LocationAdapter(Activity context, ArrayList<Location> locations, int color) {
        super(context, 0, locations);
        this.color = color;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Location currentLocation = getItem(position);

        TextView locationNameTextView = (TextView) listItemView.findViewById(R.id.location_name_text_view);
        locationNameTextView.setText(currentLocation.getName());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if(currentLocation.hasImage()) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(currentLocation.getImageResourceId());
        } else {
            imageView.setVisibility(View.GONE);
        }

        listItemView.findViewById(R.id.text_container).setBackgroundColor(ContextCompat.getColor(getContext(), color));

        return listItemView;
    }

}
