public class Main {
    public static void main(String[] args) {



        CircularLinkedList test = new CircularLinkedList();
        test = test.arrayToLinks(new Player[]{new Player("First"),new Player("Second"),new Player("Third")});

        test.displayList();

    }
}
