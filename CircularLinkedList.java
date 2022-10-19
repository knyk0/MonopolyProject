public class CircularLinkedList<T> {

    Link first;
    Link last;

    public CircularLinkedList(){
        first = null;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public void insertFirst(T newData){
        if(isEmpty()){
            first = new Link(newData);
            last = new Link(newData);
            first.nextLink = first;
        }
        else {
            Link newLink = new Link(newData);
            newLink.nextLink = first;
            first = newLink;
            last.nextLink = first;
        }
    }
    boolean insertLink(T key, T data){

        return true;
    }
    public void displayList(){
        Link currentLink = first;
        for(int i = 0;i < 10;i++){
            System.out.print(currentLink.data);
            System.out.print(" --> ");
            currentLink = currentLink.nextLink;
        }
        System.out.println();
    }

/*
ublic class SinglyLinkedList<T> {

    public Link first;

    public SinglyLinkedList(){
        first = null;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public void insertFirst(T newData){
        Link newLink = new Link(newData);
        newLink.nextLink = first;
        first = newLink;
    }
    public Link deleteFirst(){
        Link tempLink = first;
        first = first.nextLink;
        return tempLink;
    }
    public Link deleteLink(T targetData){
        if(targetData.equals(first.data)){ //Special case for first link
            return deleteFirst();
        }
        Link currentLink = first;
        while(currentLink.nextLink != null){ //Avoids reference error at end of array
            if(currentLink.nextLink.data.equals(targetData)){ //If target data is found
                Link deletedLink = currentLink.nextLink;
                currentLink.nextLink = currentLink.nextLink.nextLink; //When reference is link, change reference to the link after that link
                return deletedLink;
            }
            currentLink = currentLink.nextLink; //Current link increases as an incrementer
        }
        return null;
    }
    public boolean insertLink(T targetData, Link link){
        Link currentLink = first;
        while(currentLink != null){ //Avoids reference error at end of array
            if(currentLink.data.equals(targetData)){ //If target data is found
                Link tempLink = currentLink.nextLink;
                currentLink.nextLink = link; //Inserts link by changing reference of previous link and changing reference of inserted link
                link.nextLink = tempLink;
                return true;
            }
            currentLink = currentLink.nextLink; //Current link increases as an incrementer
        }
        return false;
    }
    public Link findLink(T targetData){
        Link currentLink = new Link(first.data);
        while(currentLink != null){
            if(currentLink.data.equals(targetData)){
                return currentLink;
            }
            currentLink = currentLink.nextLink;
        }
        return null;
    }
    public void displayList(){
        Link currentLink = first;
        while(currentLink != null){ //Makes sure not to cause an error at the end of the array
            System.out.print(currentLink.data); //Prints the data in the link
            if(currentLink.nextLink != null){ //Makes sure there isn't an arrow printed after the last piece of data
                System.out.print(" --> "); //Arrow Print
            }
            currentLink = currentLink.nextLink; //Current link increases as an incrementer
        }
        System.out.println();
    }
}
 */
}
