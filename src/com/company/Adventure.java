package com.company;

import java.util.ArrayList;

public class Adventure {
    private Place location; //to get the location of the palace
    private Place moveFrom; //to move from this place to another place
    private ArrayList<Items> inventory; //items inventory
    private int numberOfObjects; //number of objects in a particular location

    /**
     * Constructor for initialization
     * @param location
     * @param moveFrom
     * @param numberOfObjects
     */
    public Adventure(Place location, Place moveFrom, int numberOfObjects) {//method takes one parameter
        super();
        this.location = location;
        this.moveFrom = moveFrom;
        this.inventory = new ArrayList<Items>();
        this.numberOfObjects = numberOfObjects;
    }

    /**
     * add item to the items inventory
     * @param item
     */
    public void take(Items item) {//Method takes one parameter
        inventory.add(item);
    }

    /**
     * remove items from items inventory
     * @param item
     */
    public void drop(Items item) {
        inventory.remove(item);
    }

    /**
     * to get the current location
     * @return
     */
    public Place getLocation() {//Method return Place
        return location;
    }

    /**
     * to set the location
     * @param location
     */
    public void setLocation(Place location) {//method take one parameter
        this.location = location;
    }


    /**
     * To loop through items available in the inventory
     */
    public void viewAdventurerInventory() {
        System.out.println("Adventure Inventory");
        System.out.println();
        if (inventory.size() == 0)
            System.out.println("No Item in Inventory");
        else {
            for (int i = 0; i < inventory.size(); i++)
                System.out.println(i + "  " + inventory.get(i));
        }
        System.out.println();
    }


    @Override
    /**
     * to get the values of all the fields
     */
    public String toString() {
        return "Adventure [location=" + location + ", moveFrom=" + moveFrom + ", inventory=" + inventory
                + ", numberOfObjects=" + numberOfObjects + "]";
    }


}
