package SDA.dataStructure.myList;

public class MyList<T extends Comparable<T>> {

    private int firstEmptyIndex = 0;
    private Element<T>[] list = new Element[2];

    public void addToList(T t){
        if(list[list.length - 1] != null)
            enlargeArray();
        list[firstEmptyIndex] = new Element<>(t, firstEmptyIndex);
        firstEmptyIndex++;
    }

    private void enlargeArray(){
        Element<T>[] newList = new Element[list.length*2];
        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }
        list = newList;
    }
    private void checkScope(int index){
        if(index > firstEmptyIndex || index < 0) throw new ArrayIndexOutOfBoundsException();
    }

    public int getLength() {
        return firstEmptyIndex - 1;
    }

    public T get(int index){
        checkScope(index);
        return list[index].getT();
    }

    public boolean isEmpty(){
        return firstEmptyIndex == 0;
    }

   public T getMax(){

        T max  = list[0].getT();
        for (int i = 0; i < firstEmptyIndex; i++){
            if(list[i].getT().compareTo(max) > 0) max = list[i].getT();
        }
        return max;
   }

    public T getMin(){

        T min  = list[0].getT();
        for (int i = 0; i < firstEmptyIndex; i++){
            if(list[i].getT().compareTo(min) < 0) min = list[i].getT();
        }
        return min;
    }
}

class Element<T extends Comparable<T>>{
    private int index;
    private T t;

    Element(T t, int index){
        this.t = t;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }



}
