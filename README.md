# MonopolyProject
Nicolas Aviles and Nora Doughty - Monopoly Project

Classes:
- Main
   - Input loop
   - Turn
   - Ask about trading
   - Ask about upgrades for any complete sets
- BoardSpace
   - Owner (or Bank)(or Null)    (of Player type)
   - Price (zero if not buyable)
   - Payment (if money needed)
   - HousePrice (zero if n/a)
   - HotelPrice (zero if n/a)
   - enum tileType(Chance, CommunityChest, Railroad, FreeParking, Jail, GoToJail, Go, LuxuryTax, IncomeTax, Utilities, Red, Orange, Yellow, Green, Blue, lightBlue, Brown, Pink)
   - Name of property
- Player
   - Name
   - Money
   - ArrayList of complete sets (of the tileType)
- Link
   - generic type data (will hold boardSpace, or arrayList with boardSpace and player(s))
   - nextLink
- CircularLinkedList
   - first
- Game
   - CircularLinkedList of Players in turn order
   - currentPlayer
   - CircularLinkedList of the BoardSpaces in order
   - methods:
   - Print of board (40 tiles, 11 each side) (also print properties of currentPlayer and their money)
   - Trade method
   - Upgrade method 
   - turn


