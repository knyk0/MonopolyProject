import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    CircularLinkedList<Player> players = new CircularLinkedList<>();
    Player currentPlayer;
    CircularLinkedList<BoardSpace> tiles = new CircularLinkedList<>();
    Scanner in = new Scanner(System.in);


    public Game(){
        tiles.insertFirst(new BoardSpace(400, 0, 0,0,"Boardwalk", "BW", BoardSpace.tileType.Blue));
        tiles.insertFirst(new BoardSpace(0, 0, 0,0,"Luxury Tax", "LT", BoardSpace.tileType.Utilities));
        tiles.insertFirst(new BoardSpace(350, 0, 0,0,"Park Place", "PP", BoardSpace.tileType.Blue));
        tiles.insertFirst(new BoardSpace(0, 0, 0,0,"Chance", "Ch", BoardSpace.tileType.Chance));
        tiles.insertFirst(new BoardSpace(200, 0, 0,0,"Short Line", "SL", BoardSpace.tileType.Railroad));
        tiles.insertFirst(new BoardSpace(320, 0, 0,0,"Pennsylvania", "PA", BoardSpace.tileType.Green));
        tiles.insertFirst(new BoardSpace(0, 0, 0,0,"Community Chest", "CC", BoardSpace.tileType.CommunityChest));
        tiles.insertFirst(new BoardSpace(300, 0, 0,0,"North Carolina", "NC", BoardSpace.tileType.Green));
        tiles.insertFirst(new BoardSpace(300, 0, 0,0,"Pacific", "PC", BoardSpace.tileType.Green));
        tiles.insertFirst(new BoardSpace(0, 0, 0,0,"Go To Jail", "TJ", BoardSpace.tileType.GoToJail));
        tiles.insertFirst(new BoardSpace(280, 0, 0,0,"Marvin Gardens", "MG", BoardSpace.tileType.Yellow));
        tiles.insertFirst(new BoardSpace(150, 0, 0,0,"Water Works", "WW", BoardSpace.tileType.Utilities));
        tiles.insertFirst(new BoardSpace(260, 0, 0,0,"Ventnor Avenue", "Ve", BoardSpace.tileType.Yellow));
        tiles.insertFirst(new BoardSpace(260, 0, 0,0,"Atlantic Avenue", "AA", BoardSpace.tileType.Yellow));
        tiles.insertFirst(new BoardSpace(200, 0, 0,0,"B&O Railroad", "BO", BoardSpace.tileType.Railroad));
        tiles.insertFirst(new BoardSpace(240, 0, 0,0,"Illinois Avenue", "Il", BoardSpace.tileType.Red));
        tiles.insertFirst(new BoardSpace(220, 0, 0,0,"Indiana Avenue", "In", BoardSpace.tileType.Red));
        tiles.insertFirst(new BoardSpace(0, 0, 0,0,"Chance", "Ch", BoardSpace.tileType.Chance));
        tiles.insertFirst(new BoardSpace(220, 0, 0,0,"Kentucky Avenue", "KA", BoardSpace.tileType.Red));
        tiles.insertFirst(new BoardSpace(0, 0, 0,0,"Free Parking", "FP", BoardSpace.tileType.FreeParking));
        tiles.insertFirst(new BoardSpace(200, 0, 0,0,"New York Avenue", "NY", BoardSpace.tileType.Orange));
        tiles.insertFirst(new BoardSpace(180, 0, 0,0,"Tennessee Avenue", "TA", BoardSpace.tileType.Orange));
        tiles.insertFirst(new BoardSpace(0, 0, 0,0,"Community Chest", "CC", BoardSpace.tileType.CommunityChest));
        tiles.insertFirst(new BoardSpace(180, 0, 0,0,"St James Place", "SJ", BoardSpace.tileType.Orange));
        tiles.insertFirst(new BoardSpace(200, 0, 0,0,"Pennsylvania Railroad", "PR", BoardSpace.tileType.Railroad));
        tiles.insertFirst(new BoardSpace(160, 0, 0,0,"Virginia Avenue", "Vi", BoardSpace.tileType.Pink));
        tiles.insertFirst(new BoardSpace(140, 0, 0,0,"States Avenue", "SA", BoardSpace.tileType.Pink));
        tiles.insertFirst(new BoardSpace(150, 0, 0,0,"Electric Company", "EC", BoardSpace.tileType.Utilities));
        tiles.insertFirst(new BoardSpace(140, 0, 0,0,"St. Charles Place", "SC", BoardSpace.tileType.Pink));
        tiles.insertFirst(new BoardSpace(0, 0, 0,0,"Jail", "Jl", BoardSpace.tileType.Jail));
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
        String owned = "";
        String owned2 = "";
          System.out.print("\n");
        Link current = tiles.first;
        System.out.println("    _________________________________________________________________________________________");
        for(int i = 0; i <11; i++){
            if(currentPlayer.getCurrentBoardSpace() == (current.data)){
                if(((BoardSpace)(current.data)).getOwner() != null && ((BoardSpace)(current.data)).getOwner().equals(currentPlayer)){
                    owned = "\u001B[42m";
                }
                System.out.print("\t| \u001B[31m" + owned + ((BoardSpace)(current.data)).printName+"\u001B[0m");
                owned = "";
            }
            else{
                if(((BoardSpace)(current.data)).getOwner() != null && ((BoardSpace)(current.data)).getOwner().equals(currentPlayer)){
                    owned = "\u001B[42m";
                }
                System.out.print("\t| " + owned + ((BoardSpace)(current.data)).printName+"\u001B[0m");
                owned = "";
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
                if(((BoardSpace)(current.data)).getOwner() != null && ((BoardSpace)(current.data)).getOwner().equals(currentPlayer)){
                    owned = "\u001B[42m";
                }
                if(((BoardSpace)(current2.data)).getOwner() != null && ((BoardSpace)(current2.data)).getOwner().equals(currentPlayer)){
                    owned2 = "\u001B[42m";
                }
                System.out.print("\t| " + owned2 + ((BoardSpace)(current2.data)).printName +"\u001B[0m\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t| \u001B[31m"+ owned + ((BoardSpace)(current.data)).printName + "\u001B[0m\t|");
                owned = "";
                owned2 = "";
            }
            else if(currentPlayer.getCurrentBoardSpace() == (current2.data)){
                if(((BoardSpace)(current.data)).getOwner() != null && ((BoardSpace)(current.data)).getOwner().equals(currentPlayer)){
                    owned = "\u001B[42m";
                }
                if(((BoardSpace)(current2.data)).getOwner() != null && ((BoardSpace)(current2.data)).getOwner().equals(currentPlayer)){
                    owned2 = "\u001B[42m";
                }
                System.out.print("\t| \u001B[31m" + owned2 + ((BoardSpace)(current2.data)).printName +"\u001B[0m\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t| "+ owned + ((BoardSpace)(current.data)).printName + "\u001B[0m\t|");
                owned = "";
                owned2 = "";
            }
            else{
                if(((BoardSpace)(current.data)).getOwner() != null && ((BoardSpace)(current.data)).getOwner().equals(currentPlayer)){
                    owned = "\u001B[42m";
                }
                if(((BoardSpace)(current2.data)).getOwner() != null && ((BoardSpace)(current2.data)).getOwner().equals(currentPlayer)){
                    owned2 = "\u001B[42m";
                }
                System.out.print("\t| " + owned2 + ((BoardSpace)(current2.data)).printName +"\u001B[0m\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t| "+ owned + ((BoardSpace)(current.data)).printName + "\u001B[0m\t|");
                owned = "";
                owned2 = "";
            }
            current = current.nextLink;
            System.out.print("\n");
        }
        for(int i = 11; i > 0; i--){
            Link current3 = current;
            for(int k = 1; k < i; k++){
                current3 = current3.nextLink;
            }
            if(currentPlayer.getCurrentBoardSpace() == (current3.data)){
                if(((BoardSpace)(current3.data)).getOwner() != null && ((BoardSpace)(current3.data)).getOwner().equals(currentPlayer)){
                    owned = "\u001B[42m";
                }
                System.out.print("\t| \u001B[31m" + owned + ((BoardSpace)(current3.data)).printName + "\u001B[0m");
                owned = "";
            }
            else{
                if(((BoardSpace)(current3.data)).getOwner() != null && ((BoardSpace)(current3.data)).getOwner().equals(currentPlayer)){
                    owned = "\u001B[42m";
                }
                System.out.print("\t| " + owned + ((BoardSpace)(current3.data)).printName + "\u001B[0m");
                owned = "";
            }
        }
        System.out.println("\t|");
        System.out.println("    ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
    }
    public void trade(){
        System.out.println("");
    }
    public void upgrade(Player player){
        for(int i = 0; i < player.completedSets.size(); i++){
            System.out.println( i +": "+ player.completedSets.get(0));
        }
        System.out.println("Which set would you like to upgrade? (use number printed in list):");
        BoardSpace.tileType upgradeSet = player.completedSets.get(Integer.parseInt(in.nextLine()));
        ArrayList<BoardSpace> setSpaces = new ArrayList<BoardSpace>();
        for(int i = 0; i < 40; i++){
            Link current = tiles.first;
            if(((BoardSpace)(current.data)).thisTileType == upgradeSet){
                System.out.println(i+": "+ ((BoardSpace)(current.data)).getPropertyName());
                setSpaces.add((BoardSpace)(current.data));
            }
            current = current.nextLink;
        }
        System.out.println("Which property would you like to upgrade? (use number printed in list): ");
        BoardSpace upgradeTile = setSpaces.get(Integer.parseInt(in.nextLine()));
        if(upgradeTile.getHouseLevel()== 5){
            System.out.println("This property is already maxed out with a hotel.");
        } else if (upgradeTile.getHouseLevel()==4){
            System.out.println("You have paid "+ upgradeTile.getHotelPrice() +" to add a hotel to " + upgradeTile.propertyName);
            player.setMoney(player.getMoney()- upgradeTile.getHotelPrice());
            upgradeTile.setHouseLevel(upgradeTile.getHouseLevel()+1);
        } else {
            player.setMoney(player.getMoney()- upgradeTile.getHousePrice());
            upgradeTile.setHouseLevel(upgradeTile.getHouseLevel()+1);
            if (upgradeTile.getHouseLevel()==3){
                System.out.println("You have paid "+ upgradeTile.getHousePrice() +" to add your fourth house to " + upgradeTile.propertyName);
            }else if (upgradeTile.getHouseLevel()==2){
                System.out.println("You have paid "+ upgradeTile.getHousePrice() +" to add your third house to " + upgradeTile.propertyName);
            }else if (upgradeTile.getHouseLevel()==1){
                System.out.println("You have paid "+ upgradeTile.getHousePrice() +" to add your second house to " + upgradeTile.propertyName);
            }else if (upgradeTile.getHouseLevel()==0){
                System.out.println("You have paid "+ upgradeTile.getHousePrice() +" to add your first house to " + upgradeTile.propertyName);
            }
        }
    }
    public void turn(Player currentPlayer, BoardSpace currentBoardSpace){
        Scanner in = new Scanner(System.in);
        printBoard(currentPlayer);
        currentPlayer.parseForCompletedSets(currentPlayer,tiles);
        System.out.println(currentPlayer.getName()+", you are on "+currentBoardSpace.getPropertyName());
        diceRoll();
        printBoard(currentPlayer);
        System.out.println("\u001B[31m"+currentPlayer.getName()+"\u001B[0m:");
        System.out.println("------------------------------------------------------");
        currentPlayer.printPlayerAttributes();
        System.out.println("------------------------------------------------------");
        currentBoardSpace = currentPlayer.getCurrentBoardSpace();
        System.out.println(currentPlayer.getName()+", now you are on "+currentBoardSpace.getPropertyName());
        System.out.println("------------------------------------------------------");
        currentBoardSpace.printBoardSpaceAttributes();
        System.out.println("------------------------------------------------------");
        if(currentBoardSpace.getOwner() == null && currentBoardSpace.getPrice() > 0){ //Buyable properties have a price, non-buyable properties do not
                System.out.println("Buy for "+currentBoardSpace.getPrice()+"? (n:0, y:1)");
                if(Integer.parseInt(in.nextLine())==1){
                    buyProperty(currentPlayer, currentBoardSpace);
                }
        }
        else if(currentBoardSpace.getOwner() != currentPlayer && currentBoardSpace.getPrice() > 0){
            if(currentPlayer.getMoney() >= currentBoardSpace.getPayment()){
                System.out.println("You paid "+currentBoardSpace.getPayment()+".");
                currentPlayer.setMoney(currentPlayer.getMoney() - currentBoardSpace.getPayment());
            }
            else{
                System.out.println("You can't afford to pay rent, you're out!");
                currentPlayer.setMoney(0);
                playerExit();
            }
        }
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
            else if(currentPlayer.getCurrentBoardSpace().getOwner() != null && currentPlayer.getCurrentBoardSpace().getThisTileType() == BoardSpace.tileType.Railroad){
                int railroadNum = 0;
                for(int i = 0; i < currentPlayer.getCurrentBoardSpace().getOwner().getOwnedProperties().size();i++){
                    if(currentPlayer.getCurrentBoardSpace().getOwner().getOwnedProperties().get(i).getThisTileType().equals(BoardSpace.tileType.Railroad)){ //Looking for railroad spaces owned by the space's owner
                        railroadNum++;
                    }
                }
                railroadNum = (int)(12.5 * Math.pow(2,railroadNum));
                currentPlayer.getCurrentBoardSpace().setPayment(railroadNum);
            }
            else if(currentPlayer.getCurrentBoardSpace().getThisTileType() == BoardSpace.tileType.GoToJail){
                goToJail(currentPlayer);
            }
        }
        else{ //If in jail
            if(matchingDiceRolls){ //If dice are matching
                getOutOfJail(currentPlayer);
            }
            else{ //If dice are not matching, remove one from jail rolls (no matter what, after 3 rolls the player will leave jail)
                currentPlayer.setJailRolls(currentPlayer.getJailRolls()-1);
            }
        }
        return matchingDiceRolls;
    }
    public void move(int spaces){
        currentPlayer.getCurrentBoardSpace().removePlayer(currentPlayer);//Remove player from space
        Link currentLink = tiles.findLink(currentPlayer.getCurrentBoardSpace());
        for(int i = 0; i < spaces; i++){
            currentLink = currentLink.nextLink;
        }
        currentPlayer.setCurrentBoardSpace((BoardSpace)(currentLink.data));//Player's current space updated
        ((BoardSpace)(currentLink.data)).addToCurrentPlayers(currentPlayer);//New space contains player
    }
    public void buyProperty(Player player, BoardSpace property){
        if(property.getOwner() == null && property.getPrice() > 0){
            if(player.getMoney() >= property.getPrice()){
                player.setMoney(player.getMoney() - property.getPrice());
                player.addToOwnedProperties(player,property);
                property.setOwner(player);
            }
            else{
                System.out.println("You can't afford that!");
            }
        }
    }
    public void payPayment(Player player, BoardSpace property){
        if(property.getOwner() != null && property.getOwner() != player){

        }
    }
    public void payTax(Player player, BoardSpace property){

    }
    public void setCurrentPlayer(Player currentPlayer){
        this.currentPlayer = currentPlayer;
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
    public void playerExit(){
        System.out.println(currentPlayer.getName()+" has gone bankrupt!");
        players.deleteLink(currentPlayer);
        Link current = tiles.first;
        for(int i = 0; i < 40; i++){
            if(((BoardSpace)(current.data)).getOwner() == currentPlayer){
                ((BoardSpace)(current.data)).setOwner(null);
            }
            current = current.nextLink;
        }
    }
}
