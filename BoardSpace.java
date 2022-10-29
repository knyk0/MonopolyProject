import java.util.ArrayList;

public class BoardSpace {

   Player owner;
    ArrayList<Player> currentPlayersOnTile = new ArrayList<>();
    int price;      //to buy
    int payment;   //base payment when landed on
    int pay1;      //payment with one house
    int pay2;      //payment with two houses
    int pay3;      //so on...
    int pay4;
    int payH;      //payment with hotel
    int housePrice;
    int hotelPrice;
    String propertyName;
    String printName;     //two digit code
    tileType thisTileType;
    int houseLevel;        //0-5 where 0 is no houses, 5 is hotel, and in between are number of houses

    public enum tileType{Chance, CommunityChest, Railroad, FreeParking, Jail, GoToJail, Go, LuxuryTax, IncomeTax, Utilities, Red, Orange, Yellow, Green, Blue, lightBlue, Brown, Pink}
    //0         1           2           3        4        5      6      7           8         9       10     11      12     13    14        15      16    17

    public BoardSpace(int price, int payment, int pay1, int pay2, int pay3, int pay4, int payH, int housePrice, String propertyName, String printName, tileType thisTileType){
        this.price = price;
        this.payment = payment;
        this.pay1 = pay1;
        this.pay2 = pay2;
        this.pay3 = pay3;
        this.pay4 = pay4;
        this.payH = payH;
        this.housePrice = housePrice;
        this.hotelPrice = housePrice;  //apparently house prices and hotel prices are the same :)
        this.propertyName = propertyName;
        this.printName = printName;
        this.thisTileType = thisTileType;
    }

    public void printBoardSpaceAttributes(){                                    //nico
        if(owner != null){System.out.println("Owner: "+owner.getName());}        //printing boardSpace info (owner, players on tile, price, name)
        System.out.print("Players on this tile: ");
        for(int i = 0;i < currentPlayersOnTile.size();i++){
            if(i < currentPlayersOnTile.size()-1){
                System.out.print(currentPlayersOnTile.get(i).getName()+", ");
            }
            else{System.out.print(currentPlayersOnTile.get(i).getName());}
        }
        System.out.println();
        if(owner == null && (thisTileType == BoardSpace.tileType.Red || thisTileType == BoardSpace.tileType.Orange || thisTileType == BoardSpace.tileType.Yellow || thisTileType == BoardSpace.tileType.Green || thisTileType == BoardSpace.tileType.Blue || thisTileType == BoardSpace.tileType.lightBlue || thisTileType == BoardSpace.tileType.Brown || thisTileType == BoardSpace.tileType.Pink || thisTileType == BoardSpace.tileType.Utilities || thisTileType == BoardSpace.tileType.Railroad)){
            System.out.println("Price: "+price);
        }
        else{
            System.out.println("Price: N/A");
        }
        System.out.println("Property Name: "+propertyName);
    }
    public Player getOwner() {
        return owner;
    }
    public void setOwner(Player owner) {
        this.owner = owner;
    }
    public void addToCurrentPlayers(Player player){
        currentPlayersOnTile.add(player);
    }
    public void removePlayer(Player player){
        currentPlayersOnTile.remove(player);
    }
    public int getHotelPrice() {
        return hotelPrice;
    }

    public int getHousePrice() {
        return housePrice;
    }

    public int getPayment() {
        return payment;
    }
    public void setPayment(int payment){
        this.payment = payment;
    }
    public String getPrintName() {
        return printName;
    }

    public int getPrice() {
        return price;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public tileType getThisTileType() {
        return thisTileType;
    }
    public int getHouseLevel(){
        return houseLevel;
    }
    public void setHouseLevel(int houseLevel){
        this.houseLevel = houseLevel;
    }
    
}
