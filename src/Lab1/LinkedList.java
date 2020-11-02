package Lab1;

public class LinkedList {
    private Node head;

    public int get(int index) {
        // returnerar elementet på position/index i
        int i = 0;
        Node n = head;
        while (i < index) {
            n = n.next;
            i++;
        }
        return n.value;
    }

    public boolean contains(int e) {
        // true om e finns i listan annars false
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
        // Lägger till element e till position/index i,
        // element till "höger" om i flyttar ett steg till höger
        if (head == null) { //If empty creates a new Node for the list
            head = new Node(v);
        } else if (index > size()) {
            throw new IndexOutOfBoundsException("The list isn't this big...");
        } else {
            if (index == size()) { //if the index is "last" we create a new node at the end
                Node n = head;
                while (n.next != null) {
                    n = n.next;
                }
                n.next = new Node(v);
            } else if (index == 0) {
                Node newNodeToAdd = new Node(v);
                newNodeToAdd.next = head;
                head = newNodeToAdd;
            } else {
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
        // ta bort elementet på position/index i
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
        // true om listan är tom, annars false
        return head == null;
    }

    public int size() {
        // antalet element i listan
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

        protected Node(int v) {
            this.value = v;
        }
    }
}
