package sk.stuba.fei.uim.oop.boxes;

import sk.stuba.fei.uim.oop.players.Player;

import java.util.ArrayList;

public class PlayingArea {
    private final ArrayList<Box> area;
    private final int sizeOfArea = 24;

    public PlayingArea () {
        area = new ArrayList<>();
        for(int i = 0; i < sizeOfArea; i++){
            if(i == 0) {
                area.add(new Start(i));
            }else if(i == 6){
                area.add(new Prison(i));
            }else if(i == 12){
                area.add(new Police(i));
            }else if(i == 18){
                area.add(new Tax(i));
            }

            else{
                area.add(new Estate(i));
            }
        }
    }

    public ArrayList<Box> getArea() {
        return area;
    }

    public void loopThrough(int positionOfPlayer, Player player){
        area.get(positionOfPlayer).trigger(player);
    }
}
