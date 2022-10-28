import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Game newGame = new Game();
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter the name of your first player:");
        Player player1 = new Player(in.nextLine(),newGame.tiles);
        newGame.players.insertFirst(player1);
        System.out.println("Please enter the name of your second player:");
        Player player2 = new Player(in.nextLine(),newGame.tiles);
        newGame.players.insertFirst(player2);
        System.out.println("Would you like to add another player? (n:0, y:1)");
        if(Integer.parseInt(in.nextLine()) == 1){
            Player player3 = new Player(in.nextLine(),newGame.tiles);
            newGame.players.insertFirst(player3);

            System.out.println("Would you like to add another player? (n:0, y:1)");
            if(Integer.parseInt(in.nextLine()) == 1){
                Player player4 = new Player(in.nextLine(),newGame.tiles);
                newGame.players.insertFirst(player4);

                System.out.println("Would you like to add another player? (n:0, y:1)");
                if(Integer.parseInt(in.nextLine()) == 1){
                    Player player5 = new Player(in.nextLine(),newGame.tiles);
                    newGame.players.insertFirst(player5);
                    if(Integer.parseInt(in.nextLine()) == 1){
                        Player player6 = new Player(in.nextLine(),newGame.tiles);
                        newGame.players.insertFirst(player6);
                    }
                }
            }
        }

        boolean gameOn = true;
        Link currentPlayerLink = newGame.players.first;
        newGame.currentPlayer = (Player)(currentPlayerLink.data);

        while(gameOn){
                newGame.currentPlayer = (Player)(currentPlayerLink.data);
                newGame.turn(((Player)(currentPlayerLink.data)),((Player)(currentPlayerLink.data)).currentBoardSpace);
                if(newGame.currentPlayer.getJailRolls() <= 0 && newGame.currentPlayer.getMoney() > 0){
                    System.out.println("Would you like to propose a trade? (n:0, y:1)");
                    if(Integer.parseInt(in.nextLine())==1){
                        newGame.trade();
                    }
                    if(!((Player)(currentPlayerLink.data)).completedSets.isEmpty()){
                        System.out.println("Would you like to upgrade (add houses/hotels to) any of your completed sets? (n:0, y:1)");
                        if(Integer.parseInt(in.nextLine())== 1){
                            newGame.upgrade(((Player)(currentPlayerLink.data)));
                        }
                    }
                }


            currentPlayerLink = currentPlayerLink.nextLink;
        }
       
    }
}
