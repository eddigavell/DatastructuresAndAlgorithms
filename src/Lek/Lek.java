package Lek;

public class Lek {
    static int i = 0;

    public static int test(int x) {
        int[] num = {1, 2, 3 , 4, 5, 6, 7, 8, 9, 10};

        if (x != num[i]) {
            i++;
            test(x);
        }
        return num[i];
    }

    public static void main(String[] args) {
        System.out.println(test(5));
    }
}
