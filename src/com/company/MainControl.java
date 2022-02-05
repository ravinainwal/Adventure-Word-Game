package com.company;

import java.util.Scanner;

public class MainControl {

    public static Scanner scanner= new Scanner(System.in); // scanner object accept the user input

    public static void main(String[] args) {//main method
        System.out.println("******** WORD MAGIC GAME - THE WORLD OF OZ ******** "+"\n");
        System.out.println("               PRESS 1 : TO START                   ");
        System.out.println("               PRESS 0 : TO QUIT                    ");
        int press= scanner.nextInt();
        if(press==1){
            GamingModel adv = new GamingModel();  // if statement to start and quit the game according to the user input
            adv.startGame();
        } else if(press==0){
            System.exit(0);
        }
    }
}
