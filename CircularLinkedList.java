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
        Link newLink = new Link(newData);
        if(isEmpty()){
            first = newLink;
            last = newLink;
            newLink.nextLink = first;
        }
        else {
            newLink.nextLink = first;
            first = newLink;
            last.nextLink = first;
        }
    }
    public Link findLink(T targetData){
        int i = 0;
        Link currentLink = first;
        while(i < 2){
            if(currentLink == first){i++;}
            if(currentLink.data == targetData){
                return currentLink;
            }
            currentLink = currentLink.nextLink;
        }
        return null;
    }
    public void deleteLink(T key){
        int i = 0;
        Link currentLink = first;
        while(i < 2){
            if(currentLink == first){i++;}
            if(currentLink.nextLink.data == key){
                currentLink.nextLink = currentLink.nextLink.nextLink;
                break;
            }
            currentLink = currentLink.nextLink;
        }
    }
}
