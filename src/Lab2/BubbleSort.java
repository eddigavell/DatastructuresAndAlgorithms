package Lab2;

public class BubbleSort {
    BubbleSort() {
        int[] num = {3, 6, 65, 11, 5, 1}; //[3, 6, 65, 11, 5, 1] -> [1, 3, 5, 6, 11, 65]
        bubbleSort(num, "l");
        printArray(num, "l");
        bubbleSort(num, "h");
        printArray(num, "h");
    }

    private void printArray(int[] n, String mode) {
        if (mode.equals("l")) {
            System.out.println();
            System.out.println("Low mode: ");
            for (int v: n) {
                System.out.print(v + ", ");
            }
        } else if (mode.equals("h")) {
            System.out.println();
            System.out.println("High mode: ");
            for (int v: n) {
                System.out.print(v + ", ");
            }
        }
    }

    private void bubbleSort(int[] n, String mode) {
        if (mode.equals("h")) {
            for (int i = 0; i<n.length; i++) {
                for (int j=0; j<n.length; j++) {
                    if (n[i] >= n[j]) {
                        int temp = n[i];
                        n[i] = n[j];
                        n[j] = temp;
                    }
                }
            }
        } else if (mode.equals("l")) {
            for (int i = 0; i<n.length; i++) {
                for (int j=0; j<n.length; j++) {
                    if (n[i] <= n[j]) {
                        int temp = n[i];
                        n[i] = n[j];
                        n[j] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new BubbleSort();
    }
}
