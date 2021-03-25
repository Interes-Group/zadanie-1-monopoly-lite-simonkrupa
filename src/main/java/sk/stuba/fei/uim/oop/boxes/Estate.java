package sk.stuba.fei.uim.oop.boxes;

import sk.stuba.fei.uim.oop.KeyboardInput;
import sk.stuba.fei.uim.oop.players.Player;

import java.util.Random;

public class Estate extends Box{
    private final int penalty;
    private final int price;
    private Player ownership = null;
    
    public Estate(int position){
        super(position);
        Random rand = new Random();
        this.price = rand.nextInt((50000 - 20000) + 1) + 20000;
        this.penalty = this.price / 10;
    }


    @Override
    public void trigger(Player player) {
        System.out.println(player.getName() + " is standing on estate number: " + position);
        if(this.ownership!=null){
            standingOnProperty(player);
        }else {
            System.out.println("the price is " + this.price + ", press 1 to buy or 0 to pass:");
            if (player.isDiscountCard()){
                System.out.println("You own Discount Card, press 2 to buy this property with 100% discount:");
            }
            int decision = KeyboardInput.readInt();
            while(decision != 1 && decision != 0){
                if (decision==2 && player.isDiscountCard()){
                    break;
                }
                System.out.println("Please, choose between 1 or 0 or 2(if you own Discount Card)");
                decision = KeyboardInput.readInt();
            }
            if (decision == 1) {
                if (player.getCash() - this.price <= 0){
                    System.out.println("Warning! You do not have enough money to obtain this estate. Press 0 again to pass. If you buy it, you will lose.");
                    decision = KeyboardInput.readInt();
                    if (decision == 0){
                        System.out.println("You have decided to pass.");
                        return;
                    }
                }
                buyProperty(player);
            }else if(decision == 2){
                buyPropertyDiscount(player);
            }
            else {
                System.out.println("You have decided to pass.");
            }
        }
    }


    public void buyPropertyDiscount(Player player){
        System.out.println("You have decided to buy this property with discount");
        player.addEstate(this);
        this.ownership = player;
        player.setDiscountCard(false);
    }

    public void buyProperty(Player player){
        System.out.println("You have decided to buy this property");
        player.setCash(-this.price);
        player.addEstate(this);
        this.ownership = player;
    }

    public void standingOnProperty(Player player){
        if (this.ownership.getNumOfPlayer() == player.getNumOfPlayer()){
            System.out.println("You are standing on your own estate, enjoy.");
        }else {
            System.out.println("The owner of this property is " + this.ownership.getName() + ", you will have to pay penalty " + this.penalty + " for standing!");
            if (player.isFreeCard()) {
                System.out.println("You have Free Card, press 1 to use it and you will not have to pay or press 0 to not use teh card:");
                int decision = KeyboardInput.readInt();
                if (decision == 1) {
                    System.out.println("You have used your Free Card, you will not pay for standing on this estate this round.");
                    player.setFreeCard(false);
                }else{
                    player.setCash(-this.penalty);
                    this.ownership.setCash(this.penalty);
                    System.out.println(this.ownership.getName() + ", earned " + this.penalty + " from " + player.getName());
                }
            }else{
                player.setCash(-this.penalty);
                this.ownership.setCash(this.penalty);
                System.out.println(this.ownership.getName() + ", earned " + this.penalty + " from " + player.getName());
            }
        }
    }

    public int getPosition() {
        return position;
    }

    public void setOwnership(Player ownership) {
        this.ownership = ownership;
    }
}
