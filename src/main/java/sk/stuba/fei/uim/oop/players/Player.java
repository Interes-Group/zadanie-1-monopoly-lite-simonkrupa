package sk.stuba.fei.uim.oop.players;

import sk.stuba.fei.uim.oop.boxes.Estate;

import java.util.ArrayList;

public class Player {
    private String name;
    private int numOfPlayer;
    private int positionOfPlayer;
    private int cash;
    private boolean move = true;
    private ArrayList<Estate> playerOwnership;


    public Player(String name, int numOfPlayer) {
        this.name = name;
        this.numOfPlayer = numOfPlayer;
        this.cash = 10000000;
        playerOwnership = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getPositionOfPlayer() {
        return positionOfPlayer;
    }

    public void setPositionOfPlayer(int positionOfPlayer) {
        System.out.println(positionOfPlayer);
        this.positionOfPlayer = this.positionOfPlayer + positionOfPlayer;
        if(this.positionOfPlayer > 23){
            System.out.println(name + ", you passed the Start, you have received 1000 cash");
            this.cash += 1000;
            this.positionOfPlayer = this.positionOfPlayer - 24;
        }
    }

    public void setPrisonPosition(){
        this.positionOfPlayer = 6;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = this.cash + cash;
    }

    public boolean isMove() {
        return move;
    }

    public boolean checkCash() {
        if (this.cash > 0){
            return true;
        } else {
            for (Estate estate : playerOwnership){
                estate.setOwnership(null);
            }
            playerOwnership.removeAll(playerOwnership);
            System.out.println(this.name + ", you lost all your money, you lost :(");
            return false;
        }
    }

    public void setMove(boolean move) {
        this.move = move;
    }

    public void addEstate(Estate estate){
        this.playerOwnership.add(estate);
    }

    public ArrayList<Integer> getPlayerOwnership() {
        ArrayList<Integer> numberOfEstate = new ArrayList<>();
        for (Estate estate : playerOwnership){
            numberOfEstate.add(estate.getPosition());
        }
        return numberOfEstate;
    }

    public int getNumOfPlayer() {
        return numOfPlayer;
    }
}
