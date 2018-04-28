package com.androidbasicsnd.android.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // Create a list of locations

        final ArrayList<Location> locations = new ArrayList<Location>();

        String[] restaurants = (String[]) getArguments().getSerializable("restaurants");

        for(int i = 0; i < restaurants.length; i++) {
            Location location = new Location(restaurants[i]);
            locations.add(location);
        }

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.colorPrimary);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }

}
