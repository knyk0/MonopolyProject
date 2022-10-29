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
    boolean insertLink(T key, T data){
        Link newLink = new Link(data);
        Link foundLink = findLink(key);
        newLink.nextLink = foundLink.nextLink;
        foundLink.nextLink = newLink;
        return false;
    }
    public void displayList(){
        Link currentLink = first;
        for(int i = 0;i < 10;i++){
            if(currentLink.data instanceof Player){
                System.out.print(((Player) currentLink.data).getName());
            }
            else{System.out.print(currentLink.data);}
            System.out.print(" --> ");
            currentLink = currentLink.nextLink;
        }
        System.out.println();
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
    public CircularLinkedList arrayToLinks(Object[] arr){
        CircularLinkedList list = new CircularLinkedList();
        for(int i = arr.length-1;i > -1;i--){
            list.insertFirst(arr[i]);
        }
        return list;
    }
}
