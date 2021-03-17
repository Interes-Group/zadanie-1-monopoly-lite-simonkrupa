package sk.stuba.fei.uim.oop.boxes;

import java.util.Random;

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
}
