package Lab1;

public class Que extends LinkedList{
    public void enqueue(int i) {
        //enqueue(i) för att lägga till ett element i i slutet av kön
        add(i);
    }

    public int dequeue() {
        //dequeue() för att hämta det första elementet och ta bort det från kön
        int temp = get(0);
        remove(0);
        return temp;
    }

    public int peek() {
        //peek() som dequeue fast elementet blir kvar i kön
        return get(0);
    }
}
