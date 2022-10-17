# MonopolyProject
Nicolas Aviles and Nora Doughty - Monopoly Project

Classes:
- Main
- BoardSpace
   - Owner (or Bank)(or Null)    (of Player type)
   - Price (zero if not buyable)
   - Payment (if money needed)
   - enum tileType(Chance, CommunityChest, Railroad, FreeParking, Jail, GoToJail, Go, LuxuryTax, IncomeTax, Utilities, Red, Orange, Yellow, Green, Blue, lightBlue, Brown, Pink)
- Player
   - Name
   - Money
   - Array
- Link
   - generic type data (will hold boardSpace, or arrayList with boardSpace and player(s))
   - nextLink
- CircularLinkedList
   - first
   - 


