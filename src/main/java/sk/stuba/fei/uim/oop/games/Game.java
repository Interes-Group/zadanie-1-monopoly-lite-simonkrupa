package sk.stuba.fei.uim.oop.games;


import sk.stuba.fei.uim.oop.KeyboardInput;
import sk.stuba.fei.uim.oop.players.Player;
import sk.stuba.fei.uim.oop.boxes.PlayingArea;

import java.util.ArrayList;
import java.util.Random;
//import java.util.Scanner;

public class Game {
    private int numberOfPlayers;
    private ArrayList<Player> players;
    private int playerPosition;
    private int playerThrow;

    public Game() {
        //Scanner myObj = new Scanner(System.in);
        System.out.println("Enter number of players: ");
        //numberOfPlayers = Integer.parseInt(myObj.nextLine());
        numberOfPlayers = KeyboardInput.readInt();
        if (numberOfPlayers <= 1){
            throw new IllegalArgumentException("Pocet hracov musi byt vacsii ako 1");
        }
        players = new ArrayList<>();
        for(int i = 0; i < numberOfPlayers; i++){
            System.out.println("Name of player number "+ (i+1) + ": ");
            players.add(i, new Player(KeyboardInput.readString(), i));
        }
        PlayingArea gameArea = new PlayingArea();
        Random rand = new Random();
        while(players.size() != 1){
            for (Player player : players) {
                if (player.isVacation() && player.isPrison()) {
                    System.out.println('\n' + player.getName() + " press enter to play: ");
                    //myObj.nextLine();
                    KeyboardInput.readString();
                    //playerThrow = rand.nextInt((6 - 1) + 1) + 1;
                    playerThrow = 3;
                    player.setPositionOfPlayer(playerThrow);
                    playerPosition = player.getPositionOfPlayer();
                    gameArea.loopThrough(playerPosition, player);
                    if(!player.checkCash()){
                        players.remove(player);
                        break;
                    }
                    System.out.println("Your current position is: " + player.getPositionOfPlayer() + " and your budget is: " + player.getCash());
                    if (player.getPlayerOwnership().size() != 0) {
                        System.out.println("You own estates on this positions: " + player.getPlayerOwnership());
                    }
                } else{
                    if(!player.isPrison()){
                        player.setPrison(true);
                        System.out.println('\n' + player.getName() + ", you are still in prison, wait one more round.");
                    }else if(!player.isVacation()){
                        player.setVacation(true);
                        System.out.println('\n' + player.getName() + ", you are still on vacation, wait one more round.");
                    }
                }
            }
        }
        if(players!=null) {
            System.out.println(players.get(0).getName() + " won the game!");
        }
    }

}
