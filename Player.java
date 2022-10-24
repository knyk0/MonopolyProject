import java.util.ArrayList;

public class Player {

    String name;
    int money;
    ArrayList<BoardSpace.tileType> completedSets;

    public Player(String name){
        this.name = name;
        money = 1500;
    }

    public void parseForCompletedSets(Player owner, CircularLinkedList list){
        BoardSpace.tileType[] sets = {BoardSpace.tileType.Red, BoardSpace.tileType.Orange, BoardSpace.tileType.Yellow, BoardSpace.tileType.Green, BoardSpace.tileType.Blue, BoardSpace.tileType.lightBlue, BoardSpace.tileType.Brown, BoardSpace.tileType.Pink, BoardSpace.tileType.Utilities, BoardSpace.tileType.Railroad};
        //Red, Orange, Yellow, Green, Blue, lightBlue, Brown, Pink, Utilities, Railroad
        for(int type = 0;type < 10;type++) {
            int setNum = 0;
            int j = 0;
            Link currentLink = list.first;
            while (j < 2) {
                if (currentLink == list.first) {
                    j++;
                }
                if (((BoardSpace)(currentLink.data)).getThisTileType() == sets[type]) {
                    setNum++;
                }
                currentLink = currentLink.nextLink;
            }
            if((type == 4 || type == 6 || type == 8) && setNum == 2){
                owner.addToCompletedSets(sets[type]);
            }
            else if(type == 9 && setNum == 4){
                owner.addToCompletedSets(sets[type]);
            }
            else{
                if(setNum == 3){
                    owner.addToCompletedSets(sets[type]);
                }
            }
        }
    }

    public void addToCompletedSets(BoardSpace.tileType tileType){
        completedSets.add(tileType);
    }

    public ArrayList<BoardSpace.tileType> getCompletedSets(){
        return completedSets;
    }

    public String getName(){
        return name;
    }

}
