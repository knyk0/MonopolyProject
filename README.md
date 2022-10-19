# MonopolyProject
Nicolas Aviles and Nora Doughty - Monopoly Project

Classes:
- Main
   - Input loop
   - Turn
   - Ask about trading
   - Ask about upgrades for any complete sets
- BoardSpace
   - Instance Variables:
   - Player owner (or Bank)(or Null)
   - Int price (zero if not buyable)
   - Int payment (if money needed)
   - Int housePrice (zero if n/a)
   - Int hotelPrice (zero if n/a)
   - enum tileType(Chance, CommunityChest, Railroad, FreeParking, Jail, GoToJail, Go, LuxuryTax, IncomeTax, Utilities, Red, Orange, Yellow, Green, Blue, lightBlue, Brown, Pink)
   - String propertyName
- Player
   - String name
   - int money
   - ArrayList<BoardSpace> completedSets
- Link
   - generic type data T (will hold boardSpace, or arrayList with boardSpace and player(s))
   - Link nextLink
- CircularLinkedList
   - Link first
   - void insertFirst(T data)
   - boolean insertAt(T key, T data)
   - Link delete(T key)
   - Link findLink(T key)
- Game
   - CircularLinkedList of Players in turn order
   - Player currentPlayer
   - CircularLinkedList of the BoardSpaces in order
   - methods:
   - void printBoard()                          (40 tiles, 11 each side) (also print properties of currentPlayer and their money)
   - void trade()
   - void upgrade()
   - void turn()                                 (go through switch statement if not in jail, otherwise roll for out of jail)
   - (helper methods for turn):
   - void buyProperty()
   - void payPayment()
   - void payTax()
   - void goToJail()
   - void getOutOfJail()                         (rolling stuff, getting out on third turn if not)
   - ...we'll see if we're forgetting anything


