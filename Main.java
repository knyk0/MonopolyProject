public class Main {
    public static void main(String[] args) {


        Player bob = new Player("Bob");
        Player joe = new Player("Joe");
        Player jim = new Player("Jim");


        Game newGame = new Game();
        newGame.players.insertFirst(bob);bob.setCurrentBoardSpace((BoardSpace)(newGame.tiles.first.data));
        newGame.players.insertFirst(joe);joe.setCurrentBoardSpace((BoardSpace)(newGame.tiles.first.data));
        newGame.players.insertFirst(jim);jim.setCurrentBoardSpace((BoardSpace)(newGame.tiles.first.data));
        newGame.currentPlayer = (Player)(newGame.players.first.data);
        newGame.printBoard(jim);
        ((BoardSpace)(newGame.tiles.first.data)).addToCurrentPlayers(jim);
        ((BoardSpace)(newGame.tiles.first.data)).addToCurrentPlayers(bob);
        ((BoardSpace)(newGame.tiles.first.data)).printBoardSpaceAttributes();
        newGame.diceRoll();
        newGame.printBoard(bob);
        bob.getCurrentBoardSpace().printBoardSpaceAttributes();
    }
}
