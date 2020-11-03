package Lab1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.size()); // ska bli 3
        list.add(0,99);
        System.out.println(list.size()); // -> 4
        System.out.println(list.get(0)); // -> 99
        System.out.println(list.get(3)); // -> 3
        list.remove(3);
        System.out.println(list.size()); // -> 3
        System.out.println(list.empty()); // -> false
        System.out.println(list.contains(99));
        Stack stack = new Stack();
        System.out.println("Stack-------");
        stack.push(1);
        stack.push(50);
        stack.push(100);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }
}
