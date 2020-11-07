package Sorts.QuickSort;

public class QuickSort {

    QuickSort() {
        int[] num = {5,1,8,6,2,4,3,7,10,9};
        long start = System.currentTimeMillis();
        quickSort(num, 0, 9);
        long stop = System.currentTimeMillis();
        for (int v: num) {
            System.out.print(v + " ");
        }
        System.out.println();
        Runtime test = Runtime.getRuntime();
        System.out.println("Minne som används: " + (test.totalMemory() - test.freeMemory()));
        System.out.println("QuickSort took " + (stop-start) + "ms");
    }

    public void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;
        return i+1;
    }

    public static void main(String[] args) {
       new QuickSort();
    }
}
