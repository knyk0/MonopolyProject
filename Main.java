public class Main {
    public static void main(String[] args) {


        Player bob = new Player("Bob");
        Player joe = new Player("Joe");
        Player jim = new Player("Jim");


        Game newGame = new Game();
        newGame.players.insertFirst(bob);
        newGame.players.insertFirst(joe);
        newGame.players.insertFirst(jim);
        newGame.printBoard();

    }
}
