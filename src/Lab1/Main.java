package Lab1;

public class Main {

    static void printList(LinkedList list) {
        for (int i=0; i < list.size(); i++) {
            System.out.println("Plats " + i +": "+list.get(i));
        }
        System.out.println("List size: " + list.size());
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        //Lägg till
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);


        list.add(0,99);
        list.add(5,1000);
        list.add(12,666);
        list.add(11,777);

        list.add(13,888);
        printList(list);
        /*
        l.add(1)
        l.add(2)
        l.add(3)
        l.size() -> 3
        l.add(0,99)
        l.size() -> 4
        l.get(0) -> 99
        lg.get(3) -> 3
        l.remove(3)
        l.size() -> 3
        l.empty() -> false
         */
    }
}
