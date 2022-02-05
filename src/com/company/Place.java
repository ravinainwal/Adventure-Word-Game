package com.company;

import java.util.ArrayList;

public class Place extends Location {

    private String name; //name of the place
    private String desc; // description of the place
    private ArrayList<Items> contents; //array list of items
    private int numberOfItems; // number of items in the list


    /**
     * constructor for initialization
     * @param name
     * @param desc
     */
    public Place(String name, String desc) {
        this.name = name;
        this.desc = desc;
        contents = new ArrayList<>();
        setType("Place");
    }


    /**
     * to add the item in the array list
     * @param item
     */
    public void addObject(Items item){
        contents.add(item);
    }

    /**
     * to remove the item from the array list
     * @param item
     */
    public void dropObject(Items item){

        contents.remove(item);
    }


    /**
     * to get the number of items in the list
     * @return
     */
    public int getNumberOfItems() {
        numberOfItems = contents.size();
        return numberOfItems;
    }

    /**
     * to get the name
     * @return
     */
    public String getName() {
        return name;
    }


    /**
     * To get the content of the place
     */
    public void viewPlaceContent() {

        System.out.println("Place Contents");
        System.out.println();
        if(contents.size()==0)
            System.out.println("No Item in Place");
        else {
            for(int i = 0 ; i < contents.size(); i++)
                System.out.println(i + "  " + contents.get(i));
        }
        System.out.println();
    }

    @Override
    /**
     * to print the name and description and contents
     */
    public String toString() {
        return "\n"+"name : " + name +"\n"+ "desc : " + desc +"\n"+ "contents : "+"\n"+ contents.toString()+"\n"+"numberOfThings : " + getNumberOfItems();
    }

    /**
     * to get the items in the place
     * @param takeThing
     * @return
     */
    public Items getPlaceItem(int takeThing) {
        Items t = contents.get(takeThing);
        dropObject(t);
        return t;

    }
}
