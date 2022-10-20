import java.util.ArrayList;

public class Player {

    String name;
    int money;
    ArrayList<BoardSpace.tileType> completedSets;


    public Player(String name){
        this.name = name;
        money = 1500;
    }

    public String getName(){
        return name;
    }

}
