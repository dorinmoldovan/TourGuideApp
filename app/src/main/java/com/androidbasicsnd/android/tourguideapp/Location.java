package com.androidbasicsnd.android.tourguideapp;

/**
 * A class that stores information about a location
 */
public class Location {

    /**
     * The name of the location
     */
    private String mName;

    /**
     * A value used for the discrimination between the locations that are associated with images
     * and the locations that have no images
     */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * The id of the image associated with the location
     */
    private Integer mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     * Create a new Location object
     *
     * @param name is the name of the location
     */
    public Location(String name) {
        mName = name;
    }

    /**
     * Create a new Location object
     *
     * @param name is the name of the location
     * @param imageResourceId is the ID of the image resource associated with the location
     */
    public Location(String name, int imageResourceId) {
        mName = name;
        mImageResourceId = imageResourceId;
    }

    /**
     *
     * @return the name of the location
     */
    public String getName() {
        return mName;
    }

    /**
     *
     * @param mName the name of the location
     */
    public void setName(String mName) {
        this.mName = mName;
    }

    /**
     *
     * @return the id of the image associated with the location
     */
    public Integer getImageResourceId() {
        return mImageResourceId;
    }

    /**
     *
     * @param mImageResourceId the id of the image associated with the location
     */
    public void setImageResourceId(Integer mImageResourceId) {
        this.mImageResourceId = mImageResourceId;
    }
}
