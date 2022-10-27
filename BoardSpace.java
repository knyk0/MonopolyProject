import java.util.ArrayList;

public class BoardSpace {

    Player owner;
    ArrayList<Player> currentPlayersOnTile = new ArrayList<>();
    int price;
    int payment;
    int housePrice;
    int hotelPrice;
    String propertyName;
    String printName;
    tileType thisTileType;
    int houseLevel;

    public enum tileType{Chance, CommunityChest, Railroad, FreeParking, Jail, GoToJail, Go, LuxuryTax, IncomeTax, Utilities, Red, Orange, Yellow, Green, Blue, lightBlue, Brown, Pink}
                            //0         1           2           3        4        5      6      7           8         9       10     11      12     13    14        15      16    17

    public BoardSpace(int price, int payment, int housePrice, int hotelPrice, String propertyName, String printName, tileType thisTileType){
        this.price = price;
        this.payment = payment;
        this.housePrice = housePrice;
        this.hotelPrice = hotelPrice;
        this.propertyName = propertyName;
        this.printName = printName;
        this.thisTileType = thisTileType;
    }
    public void printBoardSpaceAttributes(){
        if(owner != null){System.out.print("Owner: "+owner.getName());}
        System.out.print("Players: ");
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
    public void setHouseLevel(){
        this.houseLevel = houseLevel;
    }
}
