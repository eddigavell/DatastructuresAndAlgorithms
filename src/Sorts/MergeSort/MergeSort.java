package Sorts.MergeSort;

public class MergeSort {
    MergeSort() {
        int[] num = {1, 4, 5, 2, 3, 8, 22, 34, 33, 2, 1, 0, 1000, 2000, 3000, 55555, 23, 9, 40, 0, 2};

        long start = System.currentTimeMillis();
        mergeSort(num);
        long stop = System.currentTimeMillis();

        for (int v: num) {
            System.out.print(v + " ");
        }

        System.out.println();
        Runtime test = Runtime.getRuntime();
        System.out.println("Minne som används: " + (test.totalMemory() - test.freeMemory()));
        System.out.println("MergeSort took " + (stop-start) + "ms");
    }

    public void mergeSort(int[] num) {
        if (num.length < 2) {
            return;
        }

        int numMiddle = num.length/2;
        int[] one = new int[numMiddle];
        int[] two = new int[num.length-numMiddle];

        int k = 0;
        int l = 0;
        for (int i = 0; i < num.length; i++) {
            if (i < numMiddle) {
                one[k++] = num[i];
            } else {
                two[l++] = num[i];
            }
        }

        mergeSort(one);
        mergeSort(two);
        merge(num, one, two);
    }

    public void merge(int[] num, int[] one, int[] two) {
        int numFirstHalf = num.length/2;
        int numSecondHalf = num.length-num.length/2;
        int i = 0;
        int j = 0;
        int k = 0;
        int x = num.length;

        while (x > 0) {
            if (i < numFirstHalf && j < numSecondHalf) {
                if (one[i] <= two[j]) {
                    num[k++] = one[i++];
                } else {
                    num[k++] = two[j++];
                }
            } else if (i < numFirstHalf) {
                num[k++] = one[i++];
            } else if (j < numSecondHalf) {
                num[k++] = two[j++];
            }
            x--;
        }
        /*
        while (i < numFirstHalf && j < numSecondHalf) {
            if (one[i] <= two[j]) {
                num[k++] = one[i++];
            } else {
                num[k++] = two[j++];
            }
        }

        while (i < numFirstHalf) {
            num[k++] = one[i++];
        }

        while (j < numSecondHalf) {
            num[k++] = two[j++];
        }

         */
    }

    public static void main(String[] args) {
        new MergeSort();
    }
}
