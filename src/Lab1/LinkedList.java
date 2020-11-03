package Lab1;

public class LinkedList {
    private Node head;

    public int get(int index) {
        // returns element on index
        int i = 0;
        Node n = head;
        while (i < index) {
            n = n.next;
            i++;
        }
        return n.value;
    }

    public boolean contains(int e) {
        // true if 'e' exists in the list, otherwise false
        if (head == null) {
            return false;
        } else {
            int i = 0;
            Node n = head;
            while (n.next != null) {
                n = n.next;
                if(e == get(i)) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    public void add(int index, int v) {
        //Adds element on index, everything after moves to the "right".
        if (head == null) { //If empty creates a new Node for the list
            head = new Node(v);
        } else if (index > size()) { //If index is out of bounds throw a exception
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
        } else {
            if (index == size()) { //if the index is "last" we create a new node at the end
                Node n = head;
                while (n.next != null) {
                    n = n.next;
                }
                n.next = new Node(v);
            } else if (index == 0) { //If index is at the start add the node there and push everything to "right"
                Node newNodeToAdd = new Node(v);
                newNodeToAdd.next = head;
                head = newNodeToAdd;
            } else { //If index is somewhere else add the new node between two existings and push everything after to the "right"
                Node n = head;
                Node newNodeToAdd = new Node(v);
                for (int i = 0; i < index-1; i++) {
                    n = n.next;
                }
                newNodeToAdd.next = n.next;
                n.next = newNodeToAdd;
            }
        }
    }

    public void add(int v) {
        add(size(), v);
    }

    public void remove(int index) {
        // remove elements on index/position of index
        if (index == 0) {
            head = head.next;
        } else if (index > size()-1) {
            throw new IndexOutOfBoundsException("This index does not exist");
        } else {
            Node n = head;
            int i;
            for (i = 0; i < index-1; i++) {
                n = n.next;
            }
        n.next = n.next.next;
        }
    }

    public boolean empty() {
        // true if the list is empty otherwise false
        return head == null;
    }

    public int size() {
        // Length of the list
        if(head == null) {
            return 0;
        } else {
            int i= 1;
            Node n = head;
            while(n.next != null) {
                n = n.next;
                i++;
            }
            return i;
        }
    }

    class Node {
        Node next;
        int value;

        Node(int v) {
            this.value = v;
        }
    }
}
