import java.util.Random;
import java.util.Scanner;

public class Game {

    CircularLinkedList<Player> players = new CircularLinkedList<>();
    Player currentPlayer;
    CircularLinkedList<BoardSpace> tiles = new CircularLinkedList<>();

    public Game(){
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Boardwalk", "BW", BoardSpace.tileType.Blue));
        tiles.insertFirst(new BoardSpace(0, 0, 0,0,"Luxury Tax", "LT", BoardSpace.tileType.Utilities));
        tiles.insertFirst(new BoardSpace(350, 0, 0,0,"Park Place", "PP", BoardSpace.tileType.Blue));
        tiles.insertFirst(new BoardSpace(0, 0, 0,0,"Chance", "Ch", BoardSpace.tileType.Chance));
        tiles.insertFirst(new BoardSpace(200, 0, 0,0,"Short Line", "SL", BoardSpace.tileType.Railroad));
        tiles.insertFirst(new BoardSpace(320, 0, 0,0,"Pennsylvania", "PA", BoardSpace.tileType.Green));
        tiles.insertFirst(new BoardSpace(0, 0, 0,0,"Community Chest", "CC", BoardSpace.tileType.CommunityChest));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"North Carolina", "NC", BoardSpace.tileType.Green));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Pacific", "PC", BoardSpace.tileType.Green));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Go To Jail", "TJ", BoardSpace.tileType.GoToJail));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Marvin Gardens", "MG", BoardSpace.tileType.Yellow));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Water Works", "WW", BoardSpace.tileType.Utilities));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Ventnor Avenue", "Ve", BoardSpace.tileType.Yellow));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Atlantic Avenue", "AA", BoardSpace.tileType.Yellow));
        tiles.insertFirst(new BoardSpace(200, 0, 0,0,"B&O Railroad", "BO", BoardSpace.tileType.Railroad));
        tiles.insertFirst(new BoardSpace(220, 0, 0,0,"Illinois Avenue", "Il", BoardSpace.tileType.Red));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Indiana Avenue", "In", BoardSpace.tileType.Red));
        tiles.insertFirst(new BoardSpace(0, 0, 0,0,"Chance", "Ch", BoardSpace.tileType.Chance));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Kentucky Avenue", "KA", BoardSpace.tileType.Red));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Free Parking", "FP", BoardSpace.tileType.FreeParking));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"New York Avenue", "NY", BoardSpace.tileType.Orange));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Tennessee Avenue", "TA", BoardSpace.tileType.Orange));
        tiles.insertFirst(new BoardSpace(0, 0, 0,0,"Community Chest", "BW", BoardSpace.tileType.CommunityChest));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"St James Place", "SJ", BoardSpace.tileType.Orange));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Pennsylvania Railroad", "PR", BoardSpace.tileType.Railroad));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Virginia Avenue", "Vi", BoardSpace.tileType.Pink));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"States Avenue", "SA", BoardSpace.tileType.Pink));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Electric Company", "EC", BoardSpace.tileType.Utilities));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"St. Charles Place", "SC", BoardSpace.tileType.Pink));
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Jail", "Jl", BoardSpace.tileType.Jail));
        tiles.insertFirst(new BoardSpace(120, 0, 0,0,"Connecticut Avenue", "CA", BoardSpace.tileType.lightBlue));
        tiles.insertFirst(new BoardSpace(100, 0, 0,0,"Vermont Avenue", "Ve", BoardSpace.tileType.lightBlue));
        tiles.insertFirst(new BoardSpace(0, 0, 0,0,"Chance", "Ch", BoardSpace.tileType.Chance));
        tiles.insertFirst(new BoardSpace(100, 0, 0,0,"Oriental Avenue", "Or", BoardSpace.tileType.lightBlue));
        tiles.insertFirst(new BoardSpace(200, 0, 0,0,"Reading Railroad", "RR", BoardSpace.tileType.Railroad));
        tiles.insertFirst(new BoardSpace(0, 0, 0,0,"Income Tax", "IT", BoardSpace.tileType.IncomeTax));
        tiles.insertFirst(new BoardSpace(60, 0, 0,0,"Baltic Avenue", "BA", BoardSpace.tileType.Brown));
        tiles.insertFirst(new BoardSpace(0, 0, 0,0,"Community Chest", "CC", BoardSpace.tileType.CommunityChest));
        tiles.insertFirst(new BoardSpace(60, 0, 0,0,"Mediterranean", "Me", BoardSpace.tileType.Brown));
        tiles.insertFirst(new BoardSpace(0, 0, 0,0,"Go", "Go", BoardSpace.tileType.Go));
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
            if(currentPlayer.getCurrentBoardSpace() == (current.data)){
                System.out.print("\t| \u001B[31m" + ((BoardSpace)(current2.data)).printName +"\u001B[0m\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t| \u001B[31m"+ ((BoardSpace)(current.data)).printName + "\u001B[0m\t|");
            }
            else{

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
            if(currentBoardSpace.getThisTileType() == BoardSpace.tileType.Red || currentBoardSpace.getThisTileType() == BoardSpace.tileType.Orange || currentBoardSpace.getThisTileType() == BoardSpace.tileType.Yellow || currentBoardSpace.getThisTileType() == BoardSpace.tileType.Green || currentBoardSpace.getThisTileType() == BoardSpace.tileType.Blue || currentBoardSpace.getThisTileType() == BoardSpace.tileType.lightBlue || currentBoardSpace.getThisTileType() == BoardSpace.tileType.Brown || currentBoardSpace.getThisTileType() == BoardSpace.tileType.Pink || currentBoardSpace.getThisTileType() == BoardSpace.tileType.Utilities || currentBoardSpace.getThisTileType() == BoardSpace.tileType.Railroad){
                System.out.println("a) Buy");
            }
        }
        else{
            System.out.println("b) Pay");
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
        if(currentPlayer.getJailRolls() == 0){ //If not in jail
            move(combinedRoll);
            if(currentPlayer.getCurrentBoardSpace().getOwner() != null && currentPlayer.getCurrentBoardSpace().getThisTileType() == BoardSpace.tileType.Utilities){
                if(currentPlayer.getCurrentBoardSpace().getOwner().getCompletedSets().contains(BoardSpace.tileType.Utilities)){
                    currentPlayer.getCurrentBoardSpace().setPayment(combinedRoll * 10); //Payment x10 if utilities is someone else's completed set
                }
                else{
                    currentPlayer.getCurrentBoardSpace().setPayment(combinedRoll * 4);
                }
            }
            else{

            }
        }
        else{ //If in jail
            if(matchingDiceRolls){ //If dice are matching
                getOutOfJail(currentPlayer);
            }
            else{
                currentPlayer.setJailRolls(currentPlayer.getJailRolls()-1);
            }
        }
        return matchingDiceRolls;
    }
    public void move(int spaces){
        currentPlayer.getCurrentBoardSpace().removePlayer(currentPlayer);//Remove player from space
        Link currentLink = tiles.first;
        for(int i = 0; i < spaces; i++){
            currentLink = currentLink.nextLink;
        }
        BoardSpace newBoardSpace = (BoardSpace)(currentLink.data);//New space
        currentPlayer.setCurrentBoardSpace(newBoardSpace);//Player's current space updated
        newBoardSpace.addToCurrentPlayers(currentPlayer);//New space contains player
    }
    public void buyProperty(Player player, BoardSpace property){
        //player.
    }
    public void payPayment(){

    }
    public void payTax(){

    }
    public void goToJail(Player player){
        player.setJailRolls(3);
        player.getCurrentBoardSpace().removePlayer(player);
        player.setCurrentBoardSpace(index(10));
        index(10).addToCurrentPlayers(player);
    }
    public BoardSpace index(int n){
        Link currentLink = tiles.first;
        for(int i = 0;i < n;i++){
            currentLink = currentLink.nextLink;
        }
        return (BoardSpace)(currentLink.data);
    }
    public void getOutOfJail(Player player){
        player.setJailRolls(0);
        player.getCurrentBoardSpace().removePlayer(player);
    }
}
