package com.company;

public class Items {

    private String name; //name of the item
    private String desc; //description of the item

    /**
     * constructor for initialization
     * @param name
     * @param desc
     */
    public Items(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    /**
     * Method to print the name and description of the item
     * @return
     */
    public String toString() {
        return "Item : "+"name : " + name +"  description : " + desc;
    }


}