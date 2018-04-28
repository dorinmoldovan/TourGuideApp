package com.androidbasicsnd.android.tourguideapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    /** The context of the application */
    private Context mContext;

    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param context is the context of the app
     * @param fm is the fragment manager that keeps the state of each fragment in the adapter
     *           across the swipes
     */
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            ClubsFragment clubsFragment = new ClubsFragment();
            String[] clubs = mContext.getResources().getStringArray(R.array.clubs);
            Bundle bundle = new Bundle();
            bundle.putSerializable("clubs", clubs);
            clubsFragment.setArguments(bundle);
            return clubsFragment;
        } else if (position == 1){
            MallsFragment mallsFragment = new MallsFragment();
            String[] malls = mContext.getResources().getStringArray(R.array.malls);
            Bundle bundle = new Bundle();
            bundle.putSerializable("malls", malls);
            mallsFragment.setArguments(bundle);
            return mallsFragment;
        } else if (position == 2) {
            RestaurantsFragment restaurantsFragment = new RestaurantsFragment();
            String[] restaurants = mContext.getResources().getStringArray(R.array.restaurants);
            Bundle bundle = new Bundle();
            bundle.putSerializable("restaurants", restaurants);
            restaurantsFragment.setArguments(bundle);
            return restaurantsFragment;
        } else {
            UniversitiesFragment universitiesFragment = new UniversitiesFragment();
            String[] universities = mContext.getResources().getStringArray(R.array.universities);
            String[] universitiesImages = mContext.getResources().getStringArray(R.array.universities_images);
            int N = universities.length;
            Integer[] universitiesImagesIDs = new Integer[N];

            for(int i = 0; i < N; i++) {
                int resourceID = mContext.getResources().getIdentifier(universitiesImages[i], "drawable", mContext.getPackageName());
                universitiesImagesIDs[i] = resourceID;
            }

            Bundle bundle = new Bundle();
            bundle.putSerializable("universities", universities);
            bundle.putSerializable("universitiesImagesIDs", universitiesImagesIDs);
            universitiesFragment.setArguments(bundle);
            return universitiesFragment;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_clubs);
        } else if (position == 1) {
            return mContext.getString(R.string.category_malls);
        } else if (position == 2) {
            return mContext.getString(R.string.category_restaurants);
        } else {
            return mContext.getString(R.string.category_universities);
        }
    }

}
