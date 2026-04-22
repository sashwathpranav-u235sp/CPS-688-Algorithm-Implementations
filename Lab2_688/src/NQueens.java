import java.util.Arrays;

public class NQueens {
    int numberOfQueens;
    int[][] board; // [column][row]
    int[][] coordinates; // [queenIndex][0=column, 1=row]

    public NQueens(int numberOfQueens) {
        this.numberOfQueens = numberOfQueens;
        board = new int[numberOfQueens][numberOfQueens];
        coordinates = new int[numberOfQueens][2];

        // Initialize board to 0 (empty)
        for (int i = 0; i < numberOfQueens; i++) {
            Arrays.fill(board[i], 0);
        }

        // Initialize starting positions (all in first row)
        for (int i = 0; i < numberOfQueens; i++) {
            coordinates[i][0] = i; // column
            coordinates[i][1] = 0; // row
        }
    }

    public boolean isUnderAttack(int queen) {
        int currentCol = coordinates[queen][0];
        int currentRow = coordinates[queen][1];

        // Check against all previously placed queens
        for (int q = 0; q < queen; q++) {
            int otherCol = coordinates[q][0];
            int otherRow = coordinates[q][1];

            // Same row
            if (currentRow == otherRow) return true;

            // Same diagonal (absolute row and column differences are equal)
            if (Math.abs(currentCol - otherCol) == Math.abs(currentRow - otherRow)) {
                return true;
            }
        }
        return false;
    }

    public boolean run() {
        return placeQueen(0);
    }

    private boolean placeQueen(int col) {
        if (col >= numberOfQueens) {
            return true; // All queens placed successfully
        }

        for (int row = 0; row < numberOfQueens; row++) {
            coordinates[col][1] = row; // Try this row

            if (!isUnderAttack(col)) {
                board[col][row] = 1; // Place queen

                if (placeQueen(col + 1)) { // Recurse to place next queen
                    return true;
                }

                // Backtrack
                board[col][row] = 0;
            }
        }
        return false; // No valid position found in this column
    }

    public void show() {
        for (int row = 0; row < numberOfQueens; row++) {
            for (int col = 0; col < numberOfQueens; col++) {
                System.out.print(board[col][row] + " ");
            }
            System.out.println();
        }
    }


}
