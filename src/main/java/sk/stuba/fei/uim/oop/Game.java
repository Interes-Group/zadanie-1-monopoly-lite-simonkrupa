package sk.stuba.fei.uim.oop;


import sk.stuba.fei.uim.oop.boxes.PlayingArea;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private int numberOfPlayers;
    private Player players[];
    private int playerPosition;
    private int playerThrow;

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
            for (Player player : players) {
                if (player.isMove()) {
                    System.out.println('\n' + player.getName() + " press enter to play: ");
                    myObj.nextLine();
                    playerThrow = rand.nextInt((6 - 1) + 1) + 1;
                    player.setPositionOfPlayer(playerThrow);
                    playerPosition = player.getPositionOfPlayer();
                    gameArea.loopThrough(playerPosition, player);

                    System.out.println("Your current position is: " + player.getPositionOfPlayer() + " and your budget is: " + player.getCash());
                } else{
                    player.setMove(true);
                    System.out.println('\n' + player.getName() + ", you are still in prison, wait one more round.");
                }
            }
        }
    }
}
