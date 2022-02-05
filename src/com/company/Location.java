package com.company;

import java.util.HashMap;


public class Location {
    private String type; // type of location like it's demon place or demons place or it's just a place
    private HashMap<String ,Location> placeDir; //A map between direction and location

    /**
     * constructor for initialization
     */
    public Location() {
        placeDir = new HashMap<String,Location>();
    }

    /**
     * to set the type of the location
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * to map the direction with the location
     * @param dir
     * @param location
     */
    public void addDirection(String dir,Location location){
        placeDir.put(dir, location);
    }

    /**
     * to get the map
     * @return
     */
    public HashMap<String, Location> getPlaceDir() {
        return placeDir;
    }

    @Override
    /**
     * to print the type and direction of the place
     */
    public String toString() {
        return "Location [type=" + type + ", placeDir=" + placeDir + "]";
    }
}