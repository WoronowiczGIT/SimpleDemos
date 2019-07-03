package SDA.dataStructure.myQueue;

public class Shop {
    private Client[] clients = new Client[2];
    private int lastClientIndex = 0;

    public void addClient(Client client){
        enlargeQueue();
        clients[lastClientIndex] = client;
        lastClientIndex++;
    }
    public Client pool(){
        Client chosenOne = lastClientIndex != 0 ? clients[0] : null;
        for (int i = 1; i < lastClientIndex; i++) {
            clients[i-1] = clients [i];
        }
        if(lastClientIndex != 0)lastClientIndex--;
        shrinkQueue();
        return chosenOne;
    }

    private void enlargeQueue(){
        if(lastClientIndex == clients.length-1){
           changeSize(clients.length*2);
        }
    }
    private void shrinkQueue(){
        if(lastClientIndex < clients.length/4){
            changeSize(clients.length/2);
        }
    }
    private void changeSize(int newSize){
        Client[] newList = new Client[newSize];
        for (int i = 0; i < lastClientIndex; i++) {
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
