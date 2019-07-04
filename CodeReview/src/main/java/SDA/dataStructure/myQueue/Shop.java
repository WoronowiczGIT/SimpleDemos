package SDA.dataStructure.myQueue;

public class Shop {
    private Client[] clients = new Client[2];
    private int nextClientIndex = 0;

    public void addClient(Client client){
        enlargeQueue();
        clients[nextClientIndex] = client;
        nextClientIndex++;
    }
    public Client pool(){
        if(isEmpty()) return null;
        Client chosenOne = clients[0];

        for (int i = 1; i < nextClientIndex; i++) {
            clients[i-1] = clients [i];
        }
        nextClientIndex--;
        shrinkQueue();
        return chosenOne;
    }

    public boolean isEmpty(){
        return nextClientIndex == 0;
    }

    private void enlargeQueue(){
        if(nextClientIndex == clients.length-1){
           changeSize(clients.length*2);
        }
    }
    private void shrinkQueue(){
        if(nextClientIndex < clients.length/4){
            changeSize(clients.length/2);
        }
    }
    private void changeSize(int newSize){
        Client[] newList = new Client[newSize];
        for (int i = 0; i < nextClientIndex; i++) {
            newList[i] = clients[i];
        }
        clients = newList;
    }
}
class Client{
    private String shoppingList;
    Client(String whatToBuy){
        shoppingList = whatToBuy;
    }
    public String getShoppingList(){
    return shoppingList;
    }
}
