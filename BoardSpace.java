public class BoardSpace {

    Player owner;
    int price;
    int payment;
    int housePrice;
    int hotelPrice;
    String propertyName;
    String printName;
    tileType thisTileType;

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
}
