import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Upgrade and Trade was our extra functionality
        Game newGame = new Game();
        Scanner in = new Scanner(System.in); //Main Prompting Section
        System.out.println("Note: Red Text on Board = Your location, Green Square on Board = Property you Own\n");
        System.out.println("Please enter the name of your first player:");
        Player player1 = new Player(in.nextLine(),newGame.tiles);
        newGame.players.insertFirst(player1);
        System.out.println("Please enter the name of your second player:");
        Player player2 = new Player(in.nextLine(),newGame.tiles);
        newGame.players.insertFirst(player2);
        System.out.println("Would you like to add another player? (n:0, y:1)");
        if(Integer.parseInt(in.nextLine()) == 1){
            System.out.println("Please enter the name of your third player:");
            Player player3 = new Player(in.nextLine(),newGame.tiles);
            newGame.players.insertFirst(player3);
            System.out.println("Would you like to add another player? (n:0, y:1)");
            if(Integer.parseInt(in.nextLine()) == 1){
                System.out.println("Please enter the name of your fourth player:");
                Player player4 = new Player(in.nextLine(),newGame.tiles);
                newGame.players.insertFirst(player4);
                System.out.println("Would you like to add another player? (n:0, y:1)");
                if(Integer.parseInt(in.nextLine()) == 1){
                    System.out.println("Please enter the name of your fifth player:");
                    Player player5 = new Player(in.nextLine(),newGame.tiles);
                    newGame.players.insertFirst(player5);
                    if(Integer.parseInt(in.nextLine()) == 1){
                        System.out.println("Please enter the name of your sixth player:");
                        Player player6 = new Player(in.nextLine(),newGame.tiles);
                        newGame.players.insertFirst(player6);
                    }
                }
            }
        }

        boolean gameOn = true;
        Link currentPlayerLink = newGame.players.first; //Starting Point
        newGame.currentPlayer = (Player)(currentPlayerLink.data);

        while(gameOn){ //Central Game Loop

                newGame.currentPlayer = (Player)(currentPlayerLink.data);
                newGame.turn(((Player)(currentPlayerLink.data)),((Player)(currentPlayerLink.data)).currentBoardSpace);
                if(newGame.currentPlayer.getJailRolls() <= 0 && newGame.currentPlayer.getMoney() > 0){
                    System.out.println("Would you like to propose a trade? (n:0, y:1)");
                    if(Integer.parseInt(in.nextLine())==1){
                        newGame.trade(newGame.currentPlayer);
                    }
                    if(!((Player)(currentPlayerLink.data)).completedSets.isEmpty()){ //If completed sets is not empty, prompt for upgrade
                        System.out.println("Would you like to upgrade (add houses/hotels to) any of your completed sets? (n:0, y:1)");
                        if(Integer.parseInt(in.nextLine())== 1){
                            newGame.upgrade(((Player)(currentPlayerLink.data)));
                        }
                    }
                }


            currentPlayerLink = currentPlayerLink.nextLink; //Increment
        }
       
    }
}
