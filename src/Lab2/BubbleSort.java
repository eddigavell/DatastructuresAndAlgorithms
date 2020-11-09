package Lab2;

public class BubbleSort {
    /*
    2. Fortsätt med implementationen av ett binärt sökträd
    a) Lägg till metoder för att ta bort ett element, tänk på fallen:
    1. Noden har inga barn
    2. Noden har ett barn
    3. Noden har två barn
    Tänk också på att ni kan behöva hantera fallet där det som skall tas bort ligger i rot-noden.
    b) Lägg till metoder för traversering
    1. pre-order
    2. in-order
    3. reverse in-order
    4. post-order
    För att visa att traverseringen fungerar räcker det att skriva ut värdet i varje nod.
     */
    BubbleSort() {
        int[] num = {3, 6, 65, 11, 5, 1}; //[3,6, 65,11, 5,1] -> [1, 3, 5, 7, 11, 65]
        bubbleSort(num, "l");
        printArray(num, "l");
        bubbleSort(num, "h");
        printArray(num, "h");
    }

    public void printArray(int[] n, String mode) {
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
        } else {
            throw new IllegalArgumentException("Only 'h' or 'l' is allowed.");
        }
    }

    public void bubbleSort(int[] n, String mode) {
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
        } else {
            throw new IllegalArgumentException("Only 'h' or 'l' is allowed.");
        }
    }

    public static void main(String[] args) {
        new BubbleSort();
    }
}
