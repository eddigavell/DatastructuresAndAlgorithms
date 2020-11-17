package Lab3;

public class Sudoku {
    private int[][] board = {{0, 0, 0, 8, 0, 4, 9, 3, 7},
                             {0, 7, 4, 1, 0, 0, 0, 8, 0},
                             {8, 3, 2, 0, 0, 0, 4, 0, 0},
                             {2, 0, 5, 3, 0, 0, 7, 4, 0},
                             {0, 0, 0, 0, 0, 0, 0, 1, 6},
                             {1, 4, 3, 0, 0, 0, 2, 0, 0},
                             {0, 0, 7, 0, 9, 0, 6, 0, 0},
                             {0, 2, 1, 7, 5, 6, 8, 9, 0},
                             {6, 5, 9, 2, 3, 0, 0, 7, 4}};

    private Sudoku() {
        printBoard();
        if (solve(board)) {
            System.out.println();
            System.out.println("Sudoku solved with simple BT");
            printBoard();
        } else {
            System.out.println();
            System.out.println();
            System.out.println("Unsolvable");
        }
    }

    private void printBoard() {
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j < 8) {
                    System.out.print(board[i][j] + " ");
                } else {
                    System.out.print(board[i][j]);
                }
            }
            System.out.println();
        }
    }

    private boolean possible(int x, int y, int value){
        for(int i = 0; i < 9; i++) { // kontrollera rad och kolumn
            if(board[x][i] == value || board[i][y] == value){
                return false;
            }
        }
        int x0 = x - x % 3; // kontrollera rutan
        int y0 = y - y % 3;
        for (int i = x0; i < x0+3; i++) {
           for (int j = y0; j < y0+3; j++) {
               if(board[i][j] == value) {
                   return false;
               }
           }
        }
        return true;
    }

    private boolean solve(int[][] board){
        for (int i = 0; i<9; i++) { // Loopa igenom alla rader och kolumner
            for (int j = 0; j<9; j++) {
                if (board[i][j] == 0) { // Kolla om det är en nolla på aktuell pos
                    for (int k = 1; k < 10; k++) {  // Loopa igenom alla värden från 1 till 9
                        if (possible(i, j, k)) { // Kolla om man kan placera aktuellt värd på aktuell position
                            board[i][j] = k; // Om ja, placera aktuellt värde
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = 0;  // Ta bort aktuellt värde
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true; // Gör return
    }

    public static void main(String[] args) {
        new Sudoku();
    }
}
