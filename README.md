# MonopolyProject
Nicolas Aviles and Nora Doughty - Monopoly Project

Classes:
- Main
   - Ask for players (names, amount)
   - If they're in jail -> roll, if double, out, if not, tally to three ang get them out
   - Otherwise:
   - Take their turn (roll dice, land on space, show attributes of space, if it has owner pay payment, if can buy ask if they want to buy, if not buyable pay payement           if needed)
   - Ask about trading (if yes, ask who, print list of their properties, propose property for trade, ask other person if they will take the offer, otherwise loop back)
   - Ask about upgrading property for any completed sets
- BoardSpace
   - Instance Variables:
   - Player owner (or Bank)(or Null)
   - ArrayList<Player> currentPlayersOnTile
   - String propertyName
   - String printName (two digits code for printing board)
   - Int price (zero if not buyable)
   - Int payment (if money needed)
   - Int housePrice (zero if n/a)
   - Int hotelPrice (zero if n/a)
   - payments for each of the number of houses/hotels. (pay1, pay2, pay3, pay4, payH)
   - enum tileType(Chance, CommunityChest, Railroad, FreeParking, Jail, GoToJail, Go, LuxuryTax, IncomeTax, Utilities, Red, Orange, Yellow, Green, Blue, lightBlue, Brown, Pink)
- Player
   - String name
   - int money
   - ArrayList<BoardSpace> ownedProperties
   - ArrayList<BoardSpace.tileType> completedSets
   - BoardSpace currentBoardSpace
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
   - void goToJail()
   - void getOutOfJail()                         (rolling stuff, getting out on third turn if not)
   - void index()
   - void playerExit ()
   - anything else we're forgetting...


