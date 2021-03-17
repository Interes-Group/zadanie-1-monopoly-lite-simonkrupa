package sk.stuba.fei.uim.oop.boxes;

import java.util.ArrayList;

public class PlayingArea {
    ArrayList<Box> area;
    private int sizeOfArea = 24;

    public PlayingArea () {
        area = new ArrayList<Box>();
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
}
