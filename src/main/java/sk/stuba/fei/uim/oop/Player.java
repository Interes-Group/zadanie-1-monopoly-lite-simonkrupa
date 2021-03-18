package sk.stuba.fei.uim.oop;

public class Player {
    private String name;
    private int numOfPlayer;
    private int positionOfPlayer;
    private int cash;

    public Player(String name, int numOfPlayer) {
        this.name = name;
        this.numOfPlayer = numOfPlayer;
        this.cash = 10000;
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
            this.positionOfPlayer = this.positionOfPlayer - 24;
        }
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = this.cash + cash;
    }
}
