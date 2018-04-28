package com.androidbasicsnd.android.tourguideapp;

import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class UniversitiesFragment extends Fragment {

    public UniversitiesFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // Create a list of locations

        final ArrayList<Location> locations = new ArrayList<Location>();

        String[] universities = (String[]) getArguments().getSerializable("universities");
        Integer[] universitiesImagesIDs = (Integer[]) getArguments().getSerializable("universitiesImagesIDs");

        for(int i = 0; i < universities.length; i++) {
            Location location = new Location(universities[i], universitiesImagesIDs[i]);
            locations.add(location);
        }

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.colorPrimary);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }

}
