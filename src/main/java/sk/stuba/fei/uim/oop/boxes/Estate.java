package sk.stuba.fei.uim.oop.boxes;

import sk.stuba.fei.uim.oop.Player;

import java.util.Random;
import java.util.Scanner;

public class Estate extends Box{
    private final int penalty;
    private final int price;
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
        System.out.println(player.getName() + " is standing on estate, press 1 to buy or 0 to pass:");
        int decision = obj.nextInt();
        if (decision == 1){
            System.out.println("You have decided to buy this property, cost is "+this.price);
            player.setCash(-this.price);
        } else{
            System.out.println("You have decided to pass.");
        }
    }
}
