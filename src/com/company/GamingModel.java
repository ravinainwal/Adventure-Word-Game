package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class GamingModel {
    private Place places[]; //Array to store the different places
    private Items items[];  //Array to store the items
    private Adventure adventure; //Instance of adventure class
    private Demon demons[]; //Array to store Demon objects
    private Devil devils[]; //Array to store Demon objects

    /**
     * Empty constructor
     */
    public GamingModel() {
    }

    /**
     * Method to initialize the game
     */
    public void initGame(){
        items = new Items[8];
        demons = new Demon[4];
        devils = new Devil[10];
        places = new Place[16];

        for(int i =0 ;i< 4 ;i++)
            demons[i] = new Demon();//For loop to loop through demons

        for(int i =0 ;i< 10 ;i++)
            devils[i] = new Devil();//For loop to loop through devils

        //Adding items in the item array
        items[0] = new Items("Magical Wand", "A MAGICAL WAN IS HIDDEN IN THE PLACE");
        items[1] = new Items("Demon", "A DEMON IS GUARDING THIS PLACE");
        items[2] = new Items("MAGIC", "THIS WALL IS MAGICAL");
        items[3] = new Items("Almonds",   "ALMONDS TO INCREASE THE PEOPLE'S STRENGTH IN THE CURSED PLACE");
        items[4] = new Items("Mage", "AN ARMY OF MAGES TO PROTECT THE PLACE");
        items[5] = new Items("Flying Carpet", "A MAGIC CARPET TO FLY OVER WATER");
        items[6] = new Items("Anti Magic Sword", "A SWORD TO REMOVE ENEMIES MAGIC");



        places[0] = new Place("Royal Castle","This place contains 2 MAGICAL WANDS and pick up items");
        places[0].addObject(items[0]);
        places[0].addObject(items[0]);

        places[1] = new Place("Noelle's Room","Noelle's Room needs items");
        places[2] = new Place("Sigi Bay","Sigi Bay pick up items");
        places[3] = new Place("Clover Kingdom","Clover Kingdom pick up items and start position");

        places[4] = new Place("Diamond Kingdom","Diamond Kingdom contains pick up items and Mage");
        places[4].addObject(items[4]);

        places[5] = new Place("Spade Kingdom","Spade Kingdom contains pick up items and Draga");
        places[5].addObject(items[1]);

        places[6] = new Place("Asta","Asta contains pick up items");
        places[6].addObject(items[0]);
        places[6].addObject(items[5]);

        places[7] = new Place("Draga","Draga  contains pick up items");
        places[7].addObject(items[1]);
        places[7].addObject(items[2]);

        places[8] = new Place("Careen village","The Careen village contains pick up items");
        places[8].addObject(items[3]);
        places[8].addObject(items[2]);

        places[9] = new Place("Aaron castle","Aaron castle contains pick up items");
        places[9].addObject(items[6]);
        places[9].addObject(items[2]);
        places[9].addObject(items[2]);

        places[10] = new Place("Hage village","Hage village contains pick up items and Almonds");
        places[10].addObject(items[3]);

        places[11] = new Place("Dorthy seeds","Dorthy seeds contains pick up items,Magic and Almonds");
        places[11].addObject(items[2]);
        places[11].addObject(items[3]);

        places[12] = new Place("Izikial dawn","Izikial dawn contains pick up items,Magic and Almonds");
        places[12].addObject(items[0]);
        places[12].addObject(items[2]);

        places[13] = new Place("Dungeon","Dungeon contains pick up items,STRONG MAGIC ZONE and ALMONDS");
        places[13].addObject(items[2]);


        places[14] = new Place("Bravery hills","Bravery hills contains pick up items,Items required,Magic and Almonds");
        places[14].addObject(items[2]);
        places[14].addObject(items[3]);

        places[15] = new Place("Royal court","Royal Court(End) and items required Dragon,Magic and Mage");
        places[15].addObject(items[1]);
        places[15].addObject(items[2]);
        places[15].addObject(items[4]);


        //Mapping demons place using direction

        demons[0].addDirection("east", demons[1]);
        demons[0].addDirection("south", places[0]);

        demons[1].addDirection("east", demons[2]);
        demons[1].addDirection("south", places[1]);
        demons[1].addDirection("west", demons[0]);

        demons[2].addDirection("east", demons[3]);
        demons[2].addDirection("south", devils[2]);
        demons[2].addDirection("west", demons[1]);

        demons[3].addDirection("east", devils[4]);
        demons[3].addDirection("south", devils[3]);
        demons[3].addDirection("west", demons[2]);


        //Mapping demons place using direction

        devils[0].addDirection("east", devils[1]);
        devils[0].addDirection("south", devils[4]);
        devils[0].addDirection("west", demons[3]);

        devils[1].addDirection("south", places[2]);
        devils[1].addDirection("west", devils[0]);

        devils[2].addDirection("east", devils[3]);
        devils[2].addDirection("west", places[1]);
        devils[2].addDirection("north", demons[2]);
        devils[2].addDirection("south", places[5]);

        devils[3].addDirection("east", devils[4]);
        devils[3].addDirection("west", devils[2]);
        devils[3].addDirection("north", demons[3]);
        devils[3].addDirection("south", devils[5]);

        devils[4].addDirection("east", places[2]);
        devils[4].addDirection("west", devils[3]);
        devils[4].addDirection("north", devils[0]);
        devils[4].addDirection("south", places[6]);

        devils[5].addDirection("east", places[6]);
        devils[5].addDirection("west", places[5]);
        devils[5].addDirection("north", devils[3]);
        devils[5].addDirection("south", places[10]);

        devils[6].addDirection("east", places[10]);
        devils[6].addDirection("west", places[9]);
        devils[6].addDirection("north", places[5]);
        devils[6].addDirection("south", devils[7]);

        devils[7].addDirection("east", places[15]);
        devils[7].addDirection("west", places[14]);
        devils[7].addDirection("north", devils[6]);

        devils[8].addDirection("east", devils[9]);
        devils[8].addDirection("west", places[15]);
        devils[8].addDirection("north", places[11]);

        devils[9].addDirection("west", devils[8]);
        devils[9].addDirection("north", places[12]);


        //Mapping places according to the direction

        places[0].addDirection("east", places[1]);
        places[0].addDirection("north", demons[0]);
        places[0].addDirection("south", places[3]);


        places[1].addDirection("east", devils[2]);
        places[1].addDirection("west", places[0]);
        places[1].addDirection("north", demons[1]);
        places[1].addDirection("south", places[4]);

        places[2].addDirection("west", devils[4]);
        places[2].addDirection("north", devils[1]);
        places[2].addDirection("south", places[7]);

        places[3].addDirection("east", places[4]);
        places[3].addDirection("north", places[0]);
        places[3].addDirection("south", places[8]);

        places[4].addDirection("east", places[5]);
        places[4].addDirection("west", places[3]);
        places[4].addDirection("north", places[1]);
        places[4].addDirection("south", places[9]);

        places[5].addDirection("east", devils[5]);
        places[5].addDirection("west", places[4]);
        places[5].addDirection("north", devils[2]);
        places[5].addDirection("south", devils[6]);

        places[6].addDirection("east", places[7]);
        places[6].addDirection("west", devils[5]);
        places[6].addDirection("north", devils[4]);
        places[6].addDirection("south", places[11]);

        places[7].addDirection("west", places[6]);
        places[7].addDirection("north", places[2]);
        places[7].addDirection("south", places[12]);

        places[8].addDirection("east", places[9]);
        places[8].addDirection("north", places[3]);
        places[8].addDirection("south", places[13]);

        places[9].addDirection("east", devils[6]);
        places[9].addDirection("west", places[8]);
        places[9].addDirection("north", places[4]);
        places[9].addDirection("south", places[14]);

        places[10].addDirection("east", places[11]);
        places[10].addDirection("west", devils[5]);
        places[10].addDirection("north", devils[6]);
        places[10].addDirection("south", places[15]);

        places[11].addDirection("east", places[12]);
        places[11].addDirection("west", places[6]);
        places[11].addDirection("north", places[10]);
        places[11].addDirection("south", devils[8]);

        places[12].addDirection("west", places[11]);
        places[12].addDirection("north", places[7]);
        places[12].addDirection("south", devils[9]);

        places[13].addDirection("east", places[14]);
        places[13].addDirection("north", places[8]);

        places[14].addDirection("east", devils[7]);
        places[14].addDirection("west", places[13]);
        places[14].addDirection("north", places[9]);


        places[15].addDirection("east", devils[8]);
        places[15].addDirection("west", devils[7]);
        places[15].addDirection("north", places[10]);

        adventure = new Adventure(places[6],null,0);
    }

    /**
     * Method to start the game all the controls and working of game is here
     */
    public void startGame(){
        initGame();
        Scanner input = new Scanner(System.in);
        int cmd;
        Location currentLoc ,newLoc= null;
        Place currentPlace;
        int takeThing;

        boolean b = false;
        do{//do while loop
            currentLoc = adventure.getLocation();
            currentPlace= (Place) currentLoc;
            showHelpMenu();
            cmd = input.nextInt();
            if(cmd==1){
                do {//do while loop
                    System.out.print("Current Location : "+ currentLoc);
                    System.out.println("\n");
                    System.out.print("Choose Direction: ");
                    System.out.print("    1 : North");
                    System.out.print("   2 : South");
                    System.out.print("   3 : East");
                    System.out.println("   4 : West");
                    int direction=input.nextInt();
                    String direc = null;
                    if(direction==1){
                        direc="north";
                    } else if(direction==2){    /* use of if-else according to the entered number this if-else
                                                 statement will set the value of direc variable to a particular direction */
                        direc="south";
                    } else if(direction==3){
                        direc="east";
                    } else if(direction==4){
                        direc="west";
                    }

                    b = checkPathExist(direc,currentLoc);
                    if(b) {
                        if(currentPlace.getName().equalsIgnoreCase("Royal court")){
                            System.out.println("YOU WIN HURRAY!!!!!!!!!!!!!!!!!!!");
                            System.exit(0);
                        }else if(currentPlace.getName().equalsIgnoreCase("Dungeon")){
                            System.out.println("***********YOU LOOSE**********");
                        }
                        newLoc = adventurerNextLocation(direc,currentLoc);
                        adventure.setLocation((Place) newLoc);
                    }

                    else {
                        System.out.println("You can't move to this direction because here lives the DEMON and the DEVIL");
                    }
                }while(b==false);
            }
            else if(cmd==2){                                   /*If- else statement to change the
                                                                 game control according to the entered value*/
                if(currentLoc instanceof Place)
                    ((Place) currentLoc).viewPlaceContent();
                adventure.viewAdventurerInventory();
            }
            else if(cmd==3){
                if(currentLoc instanceof Place) {
                    ((Place) currentLoc).viewPlaceContent();
                    System.out.println("Take the thing 0/1/2/3 .. from the place : ");
                    takeThing = Integer.parseInt(input.next());
                    Items t = ((Place) currentLoc).getPlaceItem(takeThing);
                    adventure.take(t);
                    adventure.viewAdventurerInventory();
                }

            }
            else if(cmd==4){
                System.exit(0);
            }
            else{
                System.out.println("Invalid command");
            }

        }while(true);

    }

    /**
     * This method shows the menu
     */
    public void showHelpMenu() {
        System.out.print("Choose command: ");
        System.out.print("      1 : Go");
        System.out.print("   2 : Look");
        System.out.print("   3 : Take");
        System.out.print("   4 : Exit ");
        System.out.println();
    }

    /**
     * this method will check the path existence between the current location and the direction you want to go
     * @param path
     * @param loc
     * @return
     */
    public boolean checkPathExist(String path , Location loc) {

        HashMap<String ,Location> hm = loc.getPlaceDir();
        if(hm.containsKey(path)) {
            if(hm.get(path) instanceof Place)             //if Statement to check the path existence
                return true;
        }
        return false;
    }

    /**
     * This method will return the location of next place
     * @param path
     * @param loc
     * @return
     */
    public Location adventurerNextLocation(String path , Location loc) {

        HashMap<String ,Location> hm = loc.getPlaceDir();
        if(hm.containsKey(path)) {
            if(hm.get(path) instanceof Place)                  //if statement to get the location
                return hm.get(path);
        }
        return loc;
    }
}