package sk.stuba.fei.uim.oop.boxes;

import sk.stuba.fei.uim.oop.cards.*;
import sk.stuba.fei.uim.oop.players.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class PlayingArea {
    private final ArrayList<Box> area;
    private final int sizeOfArea = 24;
    private ArrayList<Card> cards = new ArrayList<>(
            Arrays.asList(new DiscountCard(),
                    new VacationCard(),
                    new JackpotCard(),
                    new PenaltyCard(),
                    new FreeCard()));
    private Chance chanceHelp = new Chance(0);

    public PlayingArea () {
        area = new ArrayList<>();
        for(int i = 0; i < sizeOfArea; i++){
            if(i == 0) {
                area.add(new Start(i));
            }else if(i == 3){
                area.add(new Chance(i));
            }else if(i == 6){
                area.add(new Prison(i));
            }else if(i == 9){
                area.add(new Chance(i));
            }else if(i == 12){
                area.add(new Police(i));
            }else if(i == 15){
                area.add(new Chance(i));
            }else if(i == 18){
                area.add(new Tax(i));
            }else if(i == 21){
                area.add(new Chance(i));
            }else{
                area.add(new Estate(i));
            }
        }
    }

    public void loopThrough(int positionOfPlayer, Player player){
        if (area.get(positionOfPlayer) instanceof Chance){
            if (this.cards.isEmpty()){
                cards = new ArrayList<>(
                        Arrays.asList(new DiscountCard(),
                                new VacationCard(),
                                new JackpotCard(),
                                new PenaltyCard(),
                                new FreeCard()));
            }
            chanceHelp.triggerChance(player, this.cards);
        }else {
            area.get(positionOfPlayer).trigger(player);
        }
    }
}
