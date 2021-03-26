package sk.stuba.fei.uim.oop.games;


import sk.stuba.fei.uim.oop.ZKlavesnice;
import sk.stuba.fei.uim.oop.players.Player;
import sk.stuba.fei.uim.oop.boxes.PlayingArea;

import java.util.ArrayList;
import java.util.Random;


public class Game {
    private int numberOfPlayers;
    private ArrayList<Player> players;
    private PlayingArea gameArea;

    public Game() {
        gameInit();
        gamePlay();
    }

    private void gameInit(){
        numberOfPlayers = ZKlavesnice.readInt("Enter number of players:");
        while(numberOfPlayers<=1){
            System.out.println("Minimal number of players is 2");
            numberOfPlayers = ZKlavesnice.readInt("Enter number of players:");
        }
        players = new ArrayList<>();
        for(int i = 0; i < numberOfPlayers; i++){
            players.add(i, new Player(ZKlavesnice.readString("Name of player number " + (i+1) + ":"), i));
        }
        gameArea = new PlayingArea();
    }

    private void gamePlay(){
        int playerPosition;
        int playerThrow;
        Random rand = new Random();
        while(players.size() != 1){
            for (Player player : players) {
                if (player.isVacation() && player.isPrison()) {
                    ZKlavesnice.readString('\n' + player.getName() + " press enter to play: ");
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
                    prisonVacationInfo(player);
                }
            }
        }
        System.out.println(players.get(0).getName() + " won the game!");
    }

    private void prisonVacationInfo(Player player){
        if(!player.isPrison()){
            player.setPrison(true);
            System.out.println('\n' + player.getName() + ", you are still in prison, wait one more round.");
        }else if(!player.isVacation()){
            player.setVacation(true);
            System.out.println('\n' + player.getName() + ", you are still on vacation, wait one more round.");
        }
    }

}
