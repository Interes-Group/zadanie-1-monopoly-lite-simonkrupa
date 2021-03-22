package sk.stuba.fei.uim.oop.games;


import sk.stuba.fei.uim.oop.players.Player;
import sk.stuba.fei.uim.oop.boxes.PlayingArea;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private int numberOfPlayers;
    private ArrayList<Player> players;
    private int playerPosition;
    private int playerThrow;

    public Game() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter number of players: ");
        numberOfPlayers = Integer.parseInt(myObj.nextLine());
        players = new ArrayList<>();
        for(int i = 0; i < numberOfPlayers; i++){
            System.out.println("Name of player number "+ (i+1) + ": ");
            players.add(i, new Player(myObj.nextLine(), i));
        }
        PlayingArea gameArea = new PlayingArea();
        Random rand = new Random();
        while(players.size() != 1){
            for (Player player : players) {
                if (player.isMove()) {
                    System.out.println('\n' + player.getName() + " press enter to play: ");
                    myObj.nextLine();
                    playerThrow = rand.nextInt((6 - 1) + 1) + 1;
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
                    player.setMove(true);
                    System.out.println('\n' + player.getName() + ", you are still in prison, wait one more round.");
                }
            }
        }
        if(players!=null) {
            System.out.println(players.get(0).getName() + " won the game!");
        }
    }

}
