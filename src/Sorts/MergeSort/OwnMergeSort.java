package Sorts.MergeSort;

import java.util.ArrayList;

public class OwnMergeSort {
    ArrayList<Integer> num = new ArrayList<>();

    OwnMergeSort() {
        addNumbersToArrayList();
        mergeSort();
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

    void mergeSort(){
        // Split whole list in two
        ArrayList<Integer> temp1 = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();
        for (int i = 0; i < num.size(); i ++) {
            if (i < num.size()/2) {
                temp1.add(num.get(i));
            } else {
                temp2.add(num.get(i));
            }
        }

        // Split first half of the list into two
        ArrayList<Integer> temp1_1 = new ArrayList<>();
        ArrayList<Integer> temp1_2 = new ArrayList<>();

        for (int i = 0; i < temp1.size(); i++) {
            if (i < temp1.size()/2) {
                temp1_1.add(temp1.get(i));
            } else {
                temp1_2.add(temp1.get(i));
            }
        }

        // Split second half of the list into two
        ArrayList<Integer> temp2_1 = new ArrayList<>();
        ArrayList<Integer> temp2_2 = new ArrayList<>();

        for (int i = 0; i < temp2.size(); i++) {
            if (i < temp2.size()/2) {
                temp2_1.add(temp2.get(i));
            } else {
                temp2_2.add(temp2.get(i));
            }
        }

        System.out.println("Hela: " + num);
        System.out.println("Del1: " + temp1);
        System.out.println("Del2: " + temp2);
        System.out.println("Del1 av del1: " + temp1_1);
        System.out.println("Del2 av del1: " + temp1_2);
        System.out.println("Del1 av del2: " + temp2_1);
        System.out.println("Del2 av del2: " + temp2_2);

        // Sort for first part of the first part....
        for (int i = 0; i < temp1_1.size(); i++) {
            for (int j = 1; j < temp1_1.size(); j++) {
                if (temp1_1.get(j) < temp1_1.get(j - 1)) {
                    int tmp = temp1_1.get(j);
                    temp1_1.set(j, temp1_1.get(j-1));
                    temp1_1.set(j-1, tmp);
                }
            }
        }

        // Sort for second part of the first part....
        for (int i = 0; i < temp1_2.size(); i++) {
            for (int j = 1; j < temp1_2.size(); j++) {
                if (temp1_2.get(j) < temp1_2.get(j - 1)) {
                    int tmp = temp1_2.get(j);
                    temp1_2.set(j, temp1_2.get(j-1));
                    temp1_2.set(j-1, tmp);
                }
            }
        }

        // Sort for first part of the second part....
        for (int i = 0; i < temp2_1.size(); i++) {
            for (int j = 1; j < temp2_1.size(); j++) {
                if (temp2_1.get(j) < temp2_1.get(j - 1)) {
                    int tmp = temp2_1.get(j);
                    temp2_1.set(j, temp2_1.get(j-1));
                    temp2_1.set(j-1, tmp);
                }
            }
        }

        // Sort for second part of the second part....
        for (int i = 0; i < temp2_2.size(); i++) {
            for (int j = 1; j < temp2_2.size(); j++) {
                if (temp2_2.get(j) < temp2_2.get(j - 1)) {
                    int tmp = temp2_2.get(j);
                    temp2_2.set(j, temp2_2.get(j-1));
                    temp2_2.set(j-1, tmp);
                }
            }
        }

        System.out.println(temp1_1);
        System.out.println(temp1_2);
        System.out.println(temp2_1);
        System.out.println(temp2_2);
    }

    public static void main(String[] args) {

    }
}
