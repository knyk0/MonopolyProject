import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    CircularLinkedList<Player> players = new CircularLinkedList<>();
    Player currentPlayer;
    CircularLinkedList<BoardSpace> tiles = new CircularLinkedList<>();
    Scanner in = new Scanner(System.in);


    public Game(){                //nora
        tiles.insertFirst(new BoardSpace(400, 50,200,600,1400,1700,2000, 200,"Boardwalk", "BW", BoardSpace.tileType.Blue));
        tiles.insertFirst(new BoardSpace(0, 75, 0,0,0,0,0,0,"Luxury Tax", "LT", BoardSpace.tileType.LuxuryTax));
        tiles.insertFirst(new BoardSpace(350, 35, 175,500,1100,1300,1500,200,"Park Place", "PP", BoardSpace.tileType.Blue));
        tiles.insertFirst(new BoardSpace(0, 0, 0,0,0,0,0,0,"Chance", "Ch", BoardSpace.tileType.Chance));
        tiles.insertFirst(new BoardSpace(200, 25,0,0,0,0,0, 0,"Short Line", "SL", BoardSpace.tileType.Railroad));
        tiles.insertFirst(new BoardSpace(320, 28, 150,450,1000,1200,1400,200,"Pennsylvania", "PA", BoardSpace.tileType.Green));
        tiles.insertFirst(new BoardSpace(0, 0, 0,0,0,0,0,0,"Community Chest", "CC", BoardSpace.tileType.CommunityChest));
        tiles.insertFirst(new BoardSpace(300, 26,130,390,900,1100,1275, 200,"North Carolina", "NC", BoardSpace.tileType.Green));
        tiles.insertFirst(new BoardSpace(300, 26,130,390,900,1100,1275, 200,"Pacific", "PC", BoardSpace.tileType.Green));
        tiles.insertFirst(new BoardSpace(0, 0,0, 0,0,0,0, 0,"Go To Jail", "TJ", BoardSpace.tileType.GoToJail));
        tiles.insertFirst(new BoardSpace(280, 24, 120,360,850,1025,1200,150,"Marvin Gardens", "MG", BoardSpace.tileType.Yellow));
        tiles.insertFirst(new BoardSpace(150, 10,0,0,0,0,0,0, "Water Works", "WW", BoardSpace.tileType.Utilities));
        tiles.insertFirst(new BoardSpace(260, 22,110,330,800,975,1150, 150,"Ventnor Avenue", "Ve", BoardSpace.tileType.Yellow));
        tiles.insertFirst(new BoardSpace(260, 22,110,330,800,975,1150, 150,"Atlantic Avenue", "AA", BoardSpace.tileType.Yellow));
        tiles.insertFirst(new BoardSpace(200, 25,0,0,0,0,0,0, "B&O Railroad", "BO", BoardSpace.tileType.Railroad));
        tiles.insertFirst(new BoardSpace(240, 20,100,300,750,925,1100, 150,"Illinois Avenue", "Il", BoardSpace.tileType.Red));
        tiles.insertFirst(new BoardSpace(220, 18, 90,250,700,875,1050,150,"Indiana Avenue", "In", BoardSpace.tileType.Red));
        tiles.insertFirst(new BoardSpace(0, 0,0,0,0,0,0,0, "Chance", "Ch", BoardSpace.tileType.Chance));
        tiles.insertFirst(new BoardSpace(220, 18, 90,250,700,875,1050,150,"Kentucky Avenue", "KA", BoardSpace.tileType.Red));
        tiles.insertFirst(new BoardSpace(0, 0,0,0,0,0,0,0, "Free Parking", "FP", BoardSpace.tileType.FreeParking));
        tiles.insertFirst(new BoardSpace(200, 16,80,220,600,800,1000, 100,"New York Avenue", "NY", BoardSpace.tileType.Orange));
        tiles.insertFirst(new BoardSpace(180, 14, 70,200,550,750,950,100,"Tennessee Avenue", "TA", BoardSpace.tileType.Orange));
        tiles.insertFirst(new BoardSpace(0, 0, 0,0,0,0,0,0,"Community Chest", "CC", BoardSpace.tileType.CommunityChest));
        tiles.insertFirst(new BoardSpace(180, 14, 70,200,550,750,950,100,"St James Place", "SJ", BoardSpace.tileType.Orange));
        tiles.insertFirst(new BoardSpace(200, 25,0,0,0,0,0,0, "Pennsylvania Railroad", "PR", BoardSpace.tileType.Railroad));
        tiles.insertFirst(new BoardSpace(160, 12, 60,180,500,700,900,100,"Virginia Avenue", "Vi", BoardSpace.tileType.Pink));
        tiles.insertFirst(new BoardSpace(140, 10, 50,150,450,625,750,100,"States Avenue", "SA", BoardSpace.tileType.Pink));
        tiles.insertFirst(new BoardSpace(150, 10,0,0,0,0,0,0, "Electric Company", "EC", BoardSpace.tileType.Utilities));
        tiles.insertFirst(new BoardSpace(140, 10,50,150,450,625,750, 100,"St. Charles Place", "SC", BoardSpace.tileType.Pink));
        tiles.insertFirst(new BoardSpace(0, 0,0,0,0,0,0,0, "Jail", "Jl", BoardSpace.tileType.Jail));
        tiles.insertFirst(new BoardSpace(120, 40,100,300,450,600,8, 50,"Connecticut Avenue", "CA", BoardSpace.tileType.lightBlue));
        tiles.insertFirst(new BoardSpace(100, 6, 30,90,270,400,550,50,"Vermont Avenue", "Ve", BoardSpace.tileType.lightBlue));
        tiles.insertFirst(new BoardSpace(0, 0,0,0,0,0,0,0, "Chance", "Ch", BoardSpace.tileType.Chance));
        tiles.insertFirst(new BoardSpace(100, 6,30,90,270,400,550, 50,"Oriental Avenue", "Or", BoardSpace.tileType.lightBlue));
        tiles.insertFirst(new BoardSpace(200, 25,0,0,0,0,0,0, "Reading Railroad", "RR", BoardSpace.tileType.Railroad));
        tiles.insertFirst(new BoardSpace(0, 200,0,0,0,0,0,0, "Income Tax", "IT", BoardSpace.tileType.IncomeTax));
        tiles.insertFirst(new BoardSpace(60, 4,20,60,180,320,450, 50,"Baltic Avenue", "BA", BoardSpace.tileType.Brown));
        tiles.insertFirst(new BoardSpace(0, 0,0,0,0,0,0,0, "Community Chest", "CC", BoardSpace.tileType.CommunityChest));
        tiles.insertFirst(new BoardSpace(60, 2,10,30,90,160,250, 50,"Mediterranean", "Me", BoardSpace.tileType.Brown));
        tiles.insertFirst(new BoardSpace(0, 0,0,0,0,0,0,0, "Go", "Go", BoardSpace.tileType.Go));
    }

    public void printListOfBoard(){               //nora   //for testing if the loop with board works, not in final game
        Link current = tiles.first;
        for(int i = 0; i<40; i++){
            System.out.print(((BoardSpace)(current.data)).printName + ", ");
            current = current.nextLink;
        }
    }
    public void printBoard(Player currentPlayer){       //nora/nico
        String owned = "";
        String owned2 = "";
        System.out.print("\n");
        Link current = tiles.first;
        System.out.println("    _________________________________________________________________________________________");
        for(int i = 0; i <11; i++){         //top row (loop through forwards with first 11 board spaces)
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
        for(int i = 0; i < 9; i++){        //middle 9 rows
            Link current2 = current;
            for(int j = 1; j < 29 -2*i; j++){       //algorithm to find what the left side tile will be based on the right side,
                current2 = current2.nextLink;       //and be able to loop over to it (current2 is the left side one)
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
        for(int i = 11; i > 0; i--){       //last row loop (since it is going "backwards" through the loop, going down from 11 with
            Link current3 = current;        //however many more than the current space it is
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
    public void trade(Player player){//nora
        int n = 0;
        Link current = players.first;
        boolean someoneHasProperties = false;//players you can trade with
        boolean canTrade = false;//(must have properties)
        ArrayList<Player> tradePlayers = new ArrayList<Player>();//doing one iteration so next loop can stop at first
        while(n < 2){
            if(current == players.first){
                n++;
                if(n == 2){//then this loop of same thing which can stop at first link
                    break;
                }
            }
            if(((Player)(current.data)).ownedProperties.size() != 0){
                someoneHasProperties = true;
            }
            if(someoneHasProperties && !current.data.equals(player)){
                canTrade = true;
                tradePlayers.add((Player)(current.data));
            }
            current = current.nextLink;
        }
        if(tradePlayers.size() == 1 && tradePlayers.get(0).equals(player)){
            System.out.println("There's no one to trade with!");//must have been able to trade and still have a player to trade with after removing itself
            return;
        }
        if(canTrade){//must have been able to trade and still have a player to trade with after removing itself
            for(int i = 0; i < tradePlayers.size();i++){
                System.out.println(i + ": "+ tradePlayers.get(i).getName());//looping through the players for printing list
            }
            System.out.println("Who would you like to trade with (enter number)");
            Player tradePlayer = tradePlayers.get(Integer.parseInt(in.nextLine()));   //variable for the player you're trading with

            System.out.println ("Would you like to sell a property (0), buy a property (1), or trade property for other property (2)");
            int tradeType = Integer.parseInt(in.nextLine());            //making a trade type based on what they want to do
            if(tradeType==0 && player.ownedProperties.size() > 0){           //selling
                for(int i = 0; i < player.ownedProperties.size();i++){      //looping through properties to print so they can choose
                    System.out.println(i + ": "+player.ownedProperties.get(i).propertyName);
                }
                System.out.println("Which of your properties would you like to sell " + tradePlayer.name + "? (Enter number from list)");
                BoardSpace sellSpace = player.ownedProperties.get(Integer.parseInt(in.nextLine()));  //variable sellSpace for the boardSpace they want to sell
                System.out.println("How much money would you like them to pay?");
                int sellMoney = Integer.parseInt(in.nextLine());            //variable sellMoney for the money they want to sell it for
                System.out.println("\u001B[31m" +  tradePlayer.name +"\u001B[0m, would you like to accept the trade of " + sellSpace.propertyName + " for " + sellMoney + " Dollars? (No:0, Yes:1)");
                if(Integer.parseInt(in.nextLine()) == 1){   //if other player agrees, do everything to swap
                    System.out.println(player.name +" has given " + tradePlayer.name + " " + sellSpace.propertyName + " for " + sellMoney + " dollars.");
                    tradePlayer.setMoney(tradePlayer.getMoney()-sellMoney);
                    player.setMoney(player.getMoney()+sellMoney);
                    player.ownedProperties.remove(sellSpace);
                    tradePlayer.ownedProperties.add(sellSpace);
                    sellSpace.setOwner(tradePlayer);
                } else {
                    System.out.println("The trade has been declined.");
                }
            } else if (tradeType==1 && tradePlayer.ownedProperties.size() > 0){//buying
                for(int i = 0; i < tradePlayer.ownedProperties.size();i++){//looping through to print properties for them to choose
                    System.out.println(i + ": "+tradePlayer.ownedProperties.get(i).propertyName);
                }
                System.out.println("Which property would you like to buy from " + tradePlayer.name + "? (Enter number from list)");
                BoardSpace buySpace = tradePlayer.ownedProperties.get(Integer.parseInt(in.nextLine()));    //space they are buying
                System.out.println("How much money would you like to propose to pay?");
                int buyMoney = Integer.parseInt(in.nextLine());                                       //money buying it for
                System.out.println("\u001B[31m" +  tradePlayer.name +"\u001B[0m, would you like to accept the trade of " + buySpace.propertyName + " for " + buyMoney + " Dollars? (No:0, Yes:1)");
                if(Integer.parseInt(in.nextLine()) == 1){      //if accepted, everything done to swap
                    System.out.println(tradePlayer.name +" has given " + player.name + " " + buySpace.propertyName + " for " + buyMoney + " dollars.");
                    tradePlayer.setMoney(tradePlayer.getMoney()+buyMoney);
                    player.setMoney(player.getMoney()-buyMoney);
                    player.ownedProperties.add(buySpace);
                    tradePlayer.ownedProperties.remove(buySpace);
                    buySpace.setOwner(player);
                } else {
                    System.out.println("The trade has been declined.");
                }

            } else if (tradeType==2 && tradePlayer.ownedProperties.size() > 0 && player.ownedProperties.size() > 0){//trading one property for another
                for(int i = 0; i < tradePlayer.ownedProperties.size();i++){
                    System.out.println(i + ": "+tradePlayer.ownedProperties.get(i).propertyName);
                }
                System.out.println("Which property would you like to get from " + tradePlayer.name + "? (Enter number from list)");
                BoardSpace buySpace = tradePlayer.ownedProperties.get(Integer.parseInt(in.nextLine()));   //property you're getting from the other person

                for(int i = 0; i < player.ownedProperties.size();i++){
                    System.out.println(i + ": "+player.ownedProperties.get(i).propertyName);
                }
                System.out.println("Which of your properties would you like to give to " + tradePlayer.name + "? (Enter number from list)");
                BoardSpace sellSpace = player.ownedProperties.get(Integer.parseInt(in.nextLine()));       //property you're giving up

                System.out.println("\u001B[31m" +  tradePlayer.name +"\u001B[0m, would you like to accept the trade of " + buySpace.propertyName + " for " + sellSpace.propertyName + "? (No:0, Yes:1)");
                if(Integer.parseInt(in.nextLine()) == 1){               //if accepted, everything swapped
                    System.out.println(tradePlayer.name +" has given " + player.name + " " + buySpace.propertyName + " for " + sellSpace.propertyName + ".");
                    player.ownedProperties.add(buySpace);
                    tradePlayer.ownedProperties.remove(buySpace);
                    player.ownedProperties.remove(sellSpace);
                    tradePlayer.ownedProperties.add(sellSpace);
                    buySpace.setOwner(player);
                    sellSpace.setOwner(tradePlayer);
                } else {
                    System.out.println("The trade has been declined.");
                }
            }
            else{
                System.out.println("No trades are possible.");
            }

        } else {
            System.out.println("There aren't any bought properties to trade");
        }
    }
    public void upgrade(Player player){//nora
        ArrayList<BoardSpace.tileType> upgradableSets = new ArrayList<>();
        for(int i = 0; i < player.completedSets.size(); i++){ //first looping through, printing, and asking for which set to upgrade (because must be completed set)
            if(player.completedSets.get(i).equals(BoardSpace.tileType.Railroad) || player.completedSets.get(i).equals(BoardSpace.tileType.Utilities)){
                //Nothing
            }
            else{
                upgradableSets.add(player.completedSets.get(i));
            }
        }
        if(upgradableSets.size() == 0){
            return;
        }
        for(int i = 0; i < upgradableSets.size(); i++){
                System.out.println(i + ": " + upgradableSets.get(i));
        }
        System.out.println("Which set would you like to upgrade? (use number printed in list):");
        BoardSpace.tileType upgradeSet = upgradableSets.get(Integer.parseInt(in.nextLine()));
        ArrayList<BoardSpace> setSpaces = new ArrayList<BoardSpace>();
        Link current = tiles.first;
        int n = 0;
        for(int i = 0; i < 40; i++){        //getting the spaces from board that have the type
            if(((BoardSpace)(current.data)).thisTileType == upgradeSet){
                System.out.println(n+": "+ ((BoardSpace)(current.data)).getPropertyName());
                n++;
                setSpaces.add((BoardSpace)(current.data));
            }
            current = current.nextLink;
        }
        System.out.println("Which property would you like to upgrade? (use number printed in list): ");   //which specific property
        BoardSpace upgradeTile = setSpaces.get(Integer.parseInt(in.nextLine()));
        if(upgradeTile.getHouseLevel()== 5){            //based on the house level already (5 already has hotel, 0 is putting first house on)
            System.out.println("This property is already maxed out with a hotel.");
        } else if (upgradeTile.getHouseLevel()==4){
            System.out.println("You have paid "+ upgradeTile.getHotelPrice() +" to add a hotel to " + upgradeTile.propertyName);
            player.setMoney(player.getMoney()- upgradeTile.getHotelPrice());
            upgradeTile.setHouseLevel(upgradeTile.getHouseLevel()+1);
        } else { //If below the threshold to become a hotel
            player.setMoney(player.getMoney()- upgradeTile.getHousePrice());
            if (upgradeTile.getHouseLevel()==3){
                System.out.println("You have paid "+ upgradeTile.getHousePrice() +" to add your fourth house to " + upgradeTile.propertyName);
            }else if (upgradeTile.getHouseLevel()==2){
                System.out.println("You have paid "+ upgradeTile.getHousePrice() +" to add your third house to " + upgradeTile.propertyName);
            }else if (upgradeTile.getHouseLevel()==1){
                System.out.println("You have paid "+ upgradeTile.getHousePrice() +" to add your second house to " + upgradeTile.propertyName);
            }else if (upgradeTile.getHouseLevel()==0){
                System.out.println("You have paid "+ upgradeTile.getHousePrice() +" to add your first house to " + upgradeTile.propertyName);
            }
            upgradeTile.setHouseLevel(upgradeTile.getHouseLevel()+1); //Add to house Level
        }
    }
    public void turn(Player currentPlayer, BoardSpace currentBoardSpace){     //nico
        Scanner in = new Scanner(System.in);
        Link current = players.first;
        for(int i = 0; i < 2;){
            if(current == players.first){
                i++;
            }
            if(((Player)(current.data)).getMoney() <= 0){
                playerExit(((Player)(current.data)));
            }
            current = current.nextLink;
        }
        if(players.first.nextLink.equals(players.first)){
            System.out.println(((Player)(players.first.data)).getName()+" has won!");
            System.exit(0);
        }
        printBoard(currentPlayer);
        currentPlayer.parseForCompletedSets(currentPlayer,tiles);
        System.out.println(currentPlayer.getName()+", you are on "+currentBoardSpace.getPropertyName());
        boolean matchingDice = diceRoll();
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
        currentPlayer.parseForCompletedSets(currentPlayer,tiles);
        if(currentBoardSpace.getOwner() == null && currentBoardSpace.getPrice() > 0){ //Buyable properties have a price, non-buyable properties do not
            System.out.println("Buy for "+currentBoardSpace.getPrice()+"? (n:0, y:1)");
            if(Integer.parseInt(in.nextLine())==1){
                buyProperty(currentPlayer, currentBoardSpace);
            }
        }
        else if(currentBoardSpace.getOwner() != currentPlayer && currentBoardSpace.getPrice() > 0){
            if(currentPlayer.getMoney() >= currentBoardSpace.getPayment() && (currentBoardSpace.getThisTileType().equals(BoardSpace.tileType.IncomeTax) || currentBoardSpace.getThisTileType().equals(BoardSpace.tileType.LuxuryTax))){
                payTax(currentPlayer, currentBoardSpace);
            } else {
                int respectivePayment;
                if(currentBoardSpace.houseLevel == 5){ respectivePayment = currentBoardSpace.payH; } //Payment scaling with respective house level
                else if (currentBoardSpace.houseLevel == 4){ respectivePayment = currentBoardSpace.pay4; }
                else if (currentBoardSpace.houseLevel == 3){ respectivePayment = currentBoardSpace.pay3; }
                else if (currentBoardSpace.houseLevel == 2){ respectivePayment = currentBoardSpace.pay2; }
                else if (currentBoardSpace.houseLevel == 1){ respectivePayment = currentBoardSpace.pay1; }
                else { respectivePayment = currentBoardSpace.payment; }
                if(currentPlayer.getMoney() >= respectivePayment){
                    System.out.println("You paid "+respectivePayment+".");
                    currentPlayer.setMoney(currentPlayer.getMoney() - respectivePayment);
                    currentBoardSpace.getOwner().setMoney(currentBoardSpace.getOwner().getMoney() + respectivePayment);
                }
                else{
                    System.out.println("You can't afford to pay rent, you're out!");
                    currentPlayer.setMoney(0);
                    playerExit(currentPlayer);
                }
            }
        }
        if(currentPlayer.getMoney() >= currentBoardSpace.getPayment() && (currentBoardSpace.getThisTileType().equals(BoardSpace.tileType.IncomeTax) || currentBoardSpace.getThisTileType().equals(BoardSpace.tileType.LuxuryTax))){
            System.out.println("There's a tax, you paid "+currentBoardSpace.getPayment()+".");
            payTax(currentPlayer, currentBoardSpace);
        }
        else if(currentPlayer.getMoney() < currentBoardSpace.getPayment() && (currentBoardSpace.getThisTileType().equals(BoardSpace.tileType.IncomeTax) || currentBoardSpace.getThisTileType().equals(BoardSpace.tileType.LuxuryTax))){
            System.out.println("You can't afford to pay the tax, you're out!");
            currentPlayer.setMoney(0);
            playerExit(currentPlayer);
        }
        if(matchingDice && currentPlayer.getMoney() > 0){
            System.out.println("Double dice, you get another turn!");
            turn(currentPlayer,currentPlayer.getCurrentBoardSpace());
        }
    }
    public boolean diceRoll(){         //nico
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
                move(firstRoll);
            }
            else{ //If dice are not matching, remove one from jail rolls (no matter what, after 3 rolls the player will leave jail)
                currentPlayer.setJailRolls(currentPlayer.getJailRolls()-1);
            }
        }
        return matchingDiceRolls;
    }
    public void move(int spaces){        //nico
        currentPlayer.getCurrentBoardSpace().removePlayer(currentPlayer);//Remove player from space
        Link currentLink = tiles.findLink(currentPlayer.getCurrentBoardSpace());
        for(int i = 0; i < spaces; i++){
            currentLink = currentLink.nextLink;
        }
        currentPlayer.setCurrentBoardSpace((BoardSpace)(currentLink.data));//Player's current space updated
        ((BoardSpace)(currentLink.data)).addToCurrentPlayers(currentPlayer);//New space contains player
    }
    public void buyProperty(Player player, BoardSpace property){       //nico
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
    public void payTax(Player player, BoardSpace property){ //Pays tax
        player.setMoney(player.getMoney() - property.getPayment());
    }
    public void goToJail(Player player){ //Sends player to jail
        player.setJailRolls(3);
        player.getCurrentBoardSpace().removePlayer(player);
        player.setCurrentBoardSpace(index(10));
        index(10).addToCurrentPlayers(player);
    }
    public BoardSpace index(int n){ //Index function to find specific spot on the board
        Link currentLink = tiles.first;
        for(int i = 0;i < n;i++){
            currentLink = currentLink.nextLink;
        }
        return (BoardSpace)(currentLink.data);
    }
    public void getOutOfJail(Player player){ //Takes player out of jail
        player.setJailRolls(0);
        player.getCurrentBoardSpace().removePlayer(player);
    }
    public void playerExit(Player player){ //Removes player from the game along with their properties
        System.out.println(player.getName()+" has gone bankrupt!");
        players.deleteLink(player);
        player.getCurrentBoardSpace().removePlayer(player);
        Link current = tiles.first;
        for(int i = 0; i < 40; i++){
            if(((BoardSpace)(current.data)).getOwner() == player){
                ((BoardSpace)(current.data)).setOwner(null);
            }
            current = current.nextLink;
        }
    }
}