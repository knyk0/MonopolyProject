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
    public void printBoard(){

    }
    public void trade(){

    }
    public void upgrade(){

    }
    public void turn(){

    }
    public void buyProperty(){

    }
    public void payPayment(){

    }
    public void payTax(){

    }
    public void goToJail(){

    }
    public void getOutOfJail(){

    }
}
