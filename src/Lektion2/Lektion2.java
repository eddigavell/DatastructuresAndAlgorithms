package Lektion2;

import java.util.ArrayList;

public class Lektion2 {
    ArrayList<Integer> num = new ArrayList<>();
    Lektion2() {
        addNumbersToArrayList();
        bubbleSort();
        serialStreamSort();
        parallelStreamSort();
        //mergeSort();
    }

    void addNumbersToArrayList() {
        num.add(38);
        num.add(27);
        num.add(43);
        num.add(3);
        num.add(9);
        num.add(82);
        num.add(10);
        System.out.println("Oformaterad: " + num);
    }

    void serialStreamSort() {
        long start = System.currentTimeMillis();
        num.stream().sorted().forEach(result -> System.out.print(result + ", "));
        long stopp = System.currentTimeMillis();
        long res = stopp-start;
        System.out.println("Serial stream: " + res + "ms");
    }

    void parallelStreamSort() {
        long start = System.currentTimeMillis();
        num.parallelStream().sorted().forEach(result -> System.out.print(result + ", "));
        long stopp = System.currentTimeMillis();
        long res = stopp-start;
        System.out.println("Parallel stream: " + res + "ms");
    }

    void bubbleSort() {
        long start = System.currentTimeMillis();

        //Bubblesort
        for (int i = 0; i < num.size(); i++) {
            for (int j = 1; j < num.size(); j++) {
                if (num.get(j) < num.get(j - 1)) {
                    int tmp = num.get(j);
                    num.set(j, num.get(j-1));
                    num.set(j-1, tmp);
                }
            }
        }
        long stopp = System.currentTimeMillis();
        long res = stopp-start;
        System.out.print(num + " Bubble sort: " + res + "ms\n");
    }

    public static void main(String[] args) {
        new Lektion2();
    }
}
