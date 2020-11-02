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
            } else {
                int i = 0;
                int tempValue = 0;
                int tempValue2 = 0;
                Node n = head;
                while (n.next != null) {
                    if (i == index) {
                        tempValue = n.value;
                        n.value = v;
                    } else if (i>index) {
                        tempValue2 = n.value;
                        n.value = tempValue;
                        tempValue = tempValue2;
                        tempValue2 = n.next.value;
                    }
                    i++;
                    n = n.next;
                }
                System.out.println(v + " ADDED");
                System.out.println("tempvalue: " + tempValue);
                System.out.println("tempValue2: " + tempValue2);
                System.out.println("--------------------------");

                if (tempValue != 0) {
                    n.value = tempValue;
                }
                if (tempValue2 != 0) {
                    n.next = new Node(tempValue2);
                }

                /*
                int i = 0;
                int size = size();
                int tempValue = 0;
                int tempValue2 = 0;
                Node n = head;
                while (n.next != null) {
                    if (i == index) {
                        tempValue = n.value;
                        n.value = v;
                    } else if (i>index) {
                        tempValue2 = n.value;
                        n.value = tempValue;
                        tempValue = tempValue2;
                        tempValue2 = n.next.value;
                    }
                    i++;
                    n = n.next;
                }
                if (tempValue != 0) {
                    n.value = tempValue;
                }
                if (tempValue2 != 0) {
                    n.next = new Node(tempValue2);
                }

                 */
            }
        }
        /* -Original head med bara värde-
        if (head == null) {
            head = new Node(v);
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = new Node(v);
        }
         */
    }

    public void add(int v) {
        add(size(), v);
    }

    public void remove(int index) {
        // ta bort elementet på position/index i
        Node n = head;
        for (int i = 0; i < size(); i++) {
            int tempValue;
            if (i < index) {
                n = n.next;
            } else if (i == index) {
                System.out.println("YAY");
                n.value = 99;
                n = null;
                System.out.println(n);
            }
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
