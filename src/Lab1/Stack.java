package Lab1;

public class Stack extends LinkedList {
    public void push(int i) {
        //push(i) för att lägga till i på toppen av stacken
        add(i);
    }

    public int pop() {
        //pop() för att plocka ut det översta elementet
        int temp = get(size()-1);
        remove(size()-1);
        return temp;
    }

    public int peek() {
        //peek() för att få tag i det översta elementet men lämna det på stacken.
        return get(size()-1);
    }
}
