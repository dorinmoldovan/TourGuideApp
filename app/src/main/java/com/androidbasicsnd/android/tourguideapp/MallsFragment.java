package com.androidbasicsnd.android.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class MallsFragment extends Fragment {

    public MallsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // Create a list of locations

        final ArrayList<Location> locations = new ArrayList<Location>();

        String[] malls = (String[]) getArguments().getSerializable("malls");

        for(int i = 0; i < malls.length; i++) {
            Location location = new Location(malls[i]);
            locations.add(location);
        }

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.colorPrimary);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }

}
