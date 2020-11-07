package Lektion1;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Lektion1 {
    Lektion1() {
        linkedList();
    }

    void linkedList() {
        List<Integer> list = new LinkedList<>();
        //Lägg till 1, 2, 3, 4
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(0,99);

        for (Integer v: list) {
            System.out.print(v);
            System.out.print("->");
        }
    }

    void stack() {
        Stack<Integer> intStack = new Stack<>();
    }

    public static void main(String[] args) {
        new Lektion1();

        System.out.println("Done");
    }
}
