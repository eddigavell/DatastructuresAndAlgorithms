package Lab3;

class Sudoku {
    private final int[][] board = {
     {0, 0, 0, 8, 0, 4, 9, 3, 7},
     {0, 7, 4, 1, 0, 0, 0, 8, 0},
     {8, 3, 2, 0, 0, 0, 4, 0, 0},
     {2, 0, 5, 3, 0, 0, 7, 4, 0},
     {0, 0, 0, 0, 0, 0, 0, 1, 6},
     {1, 4, 3, 0, 0, 0, 2, 0, 0},
     {0, 0, 7, 0, 9, 0, 6, 0, 0},
     {0, 2, 1, 7, 5, 6, 8, 9, 0},
     {6, 5, 9, 2, 3, 0, 0, 7, 4}
    };

    private Sudoku() {
        printBoard();
        if (solve()) {
            System.out.println("Solved...");
            printBoard();
        } else {
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
        System.out.println();
    }

    private boolean possible(int x, int y, int value){
        for(int i = 0; i < 9; i++) { // Check row and column
            if(board[x][i] == value || board[i][y] == value){
                return false;
            }
        }
        //Check 3x3 box
        int x0 = x - x % 3; // (x/3) * 3
        int y0 = y - y % 3; // (y/3) * 3
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + x0][j + y0] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean solve(){
        for (int i = 0; i<9; i++) { // Loop through all the rows
            for (int j = 0; j<9; j++) { // Loop through all the columns
                if (board[i][j] == 0) { // Check if the specific position is 0
                    for (int k = 1; k < 10; k++) {  // Loop through 1-9
                        if (possible(i, j, k)) { // Check if possible to add the value
                            board[i][j] = k; // If yes, place the number
                            if (solve()) {
                                return true;
                            } else {
                                board[i][j] = 0;  // If no, remove the value
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Sudoku();
    }
}
