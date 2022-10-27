import java.util.Random;
import java.util.Scanner;

public class Game {

    CircularLinkedList<Player> players = new CircularLinkedList<>();
    Player currentPlayer; //= (Player) players.first.data
    CircularLinkedList tiles = new CircularLinkedList();

    public Game(){
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Boardwalk", "BW", BoardSpace.tileType.Blue));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Luxury Tax", "LT", BoardSpace.tileType.Utilities));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Park Place", "PP", BoardSpace.tileType.Blue));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Chance", "Ch", BoardSpace.tileType.Chance));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Short Line", "SL", BoardSpace.tileType.Railroad));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Pennsylvania", "PA", BoardSpace.tileType.Green));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Community Chest", "CC", BoardSpace.tileType.CommunityChest));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"North Carolina", "NC", BoardSpace.tileType.Green));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Pacific", "PC", BoardSpace.tileType.Green));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Go To Jail", "TJ", BoardSpace.tileType.GoToJail));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Marvin Gardens", "MG", BoardSpace.tileType.Yellow));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Water Works", "WW", BoardSpace.tileType.Utilities));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Ventnor Avenue", "Ve", BoardSpace.tileType.Yellow));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Atlantic Avenue", "AA", BoardSpace.tileType.Yellow));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"B&O Railroad", "BO", BoardSpace.tileType.Railroad));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Illinois Avenue", "Il", BoardSpace.tileType.Red));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Indiana Avenue", "In", BoardSpace.tileType.Red));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Chance", "Ch", BoardSpace.tileType.Chance));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Kentucky Avenue", "KA", BoardSpace.tileType.Red));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Free Parking", "FP", BoardSpace.tileType.FreeParking));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"New York Avenue", "NY", BoardSpace.tileType.Orange));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Tennessee Avenue", "TA", BoardSpace.tileType.Orange));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Community Chest", "BW", BoardSpace.tileType.CommunityChest));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"St James Place", "SJ", BoardSpace.tileType.Orange));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Pennsylvania Railroad", "PR", BoardSpace.tileType.Railroad));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Virginia Avenue", "Vi", BoardSpace.tileType.Pink));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"States Avenue", "SA", BoardSpace.tileType.Pink));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Electric Company", "EC", BoardSpace.tileType.Utilities));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"St. Charles Place", "SC", BoardSpace.tileType.Pink));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Jail", "Jl", BoardSpace.tileType.Jail));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Connecticut Avenue", "CA", BoardSpace.tileType.lightBlue));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Vermont Avenue", "Ve", BoardSpace.tileType.lightBlue));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Chance", "Ch", BoardSpace.tileType.Chance));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Oriental Avenue", "Or", BoardSpace.tileType.lightBlue));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Reading Railroad", "RR", BoardSpace.tileType.Railroad));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Income Tax", "IT", BoardSpace.tileType.IncomeTax));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Baltic Avenue", "BA", BoardSpace.tileType.Brown));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Community Chest", "CC", BoardSpace.tileType.CommunityChest));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Mediterranean", "Me", BoardSpace.tileType.Brown));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Go", "Go", BoardSpace.tileType.Go));
    }

    public void printListOfBoard(){                  //for testing if the loop with board works
        Link current = tiles.first;
        for(int i = 0; i<40; i++){
         System.out.print(((BoardSpace)(current.data)).printName + ", ");
         current = current.nextLink;
    }
    }
    public void printBoard(Player currentPlayer){
          System.out.print("\n");
        Link current = tiles.first;
        System.out.println("    _________________________________________________________________________________________");
        for(int i = 0; i <11; i++){
            if(currentPlayer.getCurrentBoardSpace() == (current.data)){
                System.out.print("\t| \u001B[31m" + ((BoardSpace)(current.data)).printName+"\u001B[0m");
            }
            else{
                System.out.print("\t| " + ((BoardSpace)(current.data)).printName);
            }
            current = current.nextLink;
        }
        System.out.print("\t|\n");
        for(int i = 0; i < 9; i++){
            Link current2 = current;
            for(int j = 1; j < 29 -2*i; j++){
                current2 = current2.nextLink;
            }
            System.out.print("\t| " + ((BoardSpace)(current2.data)).printName +"\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t| "+ ((BoardSpace)(current.data)).printName + "\t|");
            current = current.nextLink;
            System.out.print("\n");
        }
        for(int i = 11; i > 0; i--){
            Link current3 = current;
            for(int k = 1; k < i; k++){
                current3 = current3.nextLink;
            }
            System.out.print("\t| " + ((BoardSpace)(current3.data)).printName);
        }
        System.out.println("\t|");
        System.out.println("    ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
    }
    public void trade(){
        System.out.println("");
    }
    public void upgrade(){

    }
    public void turn(Player currentPlayer, BoardSpace currentBoardSpace){
        if(currentBoardSpace.getOwner() == null){
            System.out.println("a) Buy Property");
        }
        else{
            System.out.println("a) Pay Rent");
        }



        Scanner in = new Scanner(System.in);
        System.out.println(currentPlayer+", roll the dice.");
    }
    public boolean diceRoll(){
        boolean matchingDiceRolls = false;
        int firstRoll = 0;
        int combinedRoll = 0;
        for(int i = 0; i < 2;i++) {
            Random rand = new Random();
            int roll = rand.nextInt(6) + 1;
            for(int j = 0; j < roll; j++){
                System.out.print("•");
            }
            System.out.println(" "+roll);
            if(roll == firstRoll){
                matchingDiceRolls = true;
            }
            combinedRoll = firstRoll + roll;
            firstRoll = roll;
        }
        move(combinedRoll);
        return matchingDiceRolls;
    }
    public void move(int spaces){
        currentPlayer.getCurrentBoardSpace().removePlayer(currentPlayer);
        Link currentLink = tiles.first;
        for(int i = 0; i < spaces; i++){
            currentLink = currentLink.nextLink;
        }
        BoardSpace newBoardSpace = (BoardSpace)(currentLink.data);
        currentPlayer.setCurrentBoardSpace(newBoardSpace);
        newBoardSpace.addToCurrentPlayers(currentPlayer);
    }
    public void buyProperty(){

    }
    public void payPayment(){

    }
    public void payTax(){

    }
    public void goToJail(Player player){
        player.setInJail(true);
    }
    public void getOutOfJail(Player player, boolean diceRoll){
        if(diceRoll){
            player.setInJail(false);
        }
    }
}
