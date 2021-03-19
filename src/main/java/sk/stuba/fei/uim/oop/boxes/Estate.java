package sk.stuba.fei.uim.oop.boxes;

import sk.stuba.fei.uim.oop.Player;

import java.util.Random;
import java.util.Scanner;

public class Estate extends Box{
    private final int penalty;
    private final int price;
    private Player ownership = null;
    public Estate(int position){
        super(position);
        Random rand = new Random();
        this.penalty = rand.nextInt((500 - 200) + 1) + 200;
        this.price = rand.nextInt((50000 - 20000) + 1) + 20000;
    }

    public int getPrice() {
        return price;
    }

    public int getPenalty() {
        return penalty;
    }

    @Override
    public void trigger(Player player) {
        Scanner obj = new Scanner(System.in);
        System.out.println(player.getName() + " is standing on estate");
        if(this.ownership!=null){
            standingOnProperty(player);
        }else {
            System.out.println("the price is " + this.price + ", press 1 to buy or 0 to pass:");
            int decision = obj.nextInt();
            if (decision == 1) {
                buyProperty(player);
            } else {
                System.out.println("You have decided to pass.");
            }
        }
    }

    public void buyProperty(Player player){
        System.out.println("You have decided to buy this property");
        player.setCash(-this.price);
        this.ownership = player;
    }

    public void standingOnProperty(Player player){
        System.out.println("The owner of this property is " + this.ownership.getName() + ", you will have to pay penalty " +this.penalty +" for standing!");
        player.setCash(-this.penalty);
        this.ownership.setCash(this.penalty);
        System.out.println(this.ownership.getName() + ", earned " + this.penalty + " from " + player.getName());
    }
}
