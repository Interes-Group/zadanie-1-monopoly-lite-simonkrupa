package sk.stuba.fei.uim.oop;


import sk.stuba.fei.uim.oop.boxes.PlayingArea;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private int numberOfPlayers;
    private Player players[];

    public Game() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter number of players: ");
        numberOfPlayers = Integer.parseInt(myObj.nextLine());
        players = new Player[numberOfPlayers];
        for(int i = 0; i < numberOfPlayers; i++){
            System.out.println("Name of player number "+ (i+1) + ": ");
            players[i] = new Player(myObj.nextLine(), i);
        }
        PlayingArea gameArea = new PlayingArea();
        Random rand = new Random();
        while(players.length != 0){
            for(int i = 0; i<players.length; i++){
                System.out.println(players[i].getName() + " press enter to play: ");
                myObj.nextLine();
                players[i].setPositionOfPlayer(rand.nextInt((6-1)+1)+1);
                System.out.println("Your current position is: " + players[i].getPositionOfPlayer());

            }
        }
    }
}
