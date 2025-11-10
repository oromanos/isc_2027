import java.util.*;

public class SudokuMain {
    static int ghost[][];
    static int grid[][];
    static int solutionCount;

    public static void main(String[] args) {
        int i, j;

        grid = new int[9][9];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 0 for blank!");
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                System.out.println("Enter a number for (Row :" + (i + 1) + " Column :" + (j + 1) + " )");
                grid[i][j] = sc.nextInt();
                if (grid[i][j] < 0 || grid[i][j] > 9) {
                    System.out.println("Invalid input! (Numbers should only be between 0-9 )");
                    return;
                }
            }
        }
        SudokuCheck ob = new SudokuCheck();
        ghost = grid;
        if (!ob.validGrid(grid)) {

            System.out.println("Invalid grid ");
            return;
        }
        gridPrinter(grid);
        gridSolve();
        System.out.println("The puzzle can be solved in : " + solutionCount);
    }

    public static boolean isValid(int row, int col, int num) {
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        int j, i;
        for (j = 0; j < 9; j++) {
            if (grid[row][j] == num) {
                return false;
            }
        }
        for (i = 0; i < 9; i++) {
            if (grid[i][col] == num) {
                return false;
            }
        }
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (grid[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }
        return true;

    }

    public static void gridSolve() {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (ghost[r][c] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(r, c, num)) {
                            ghost[r][c] = num;
                            gridSolve();
                            ghost[r][c] = 0;
                        }
                    }
                    return;
                }
            }
        }

        solutionCount++;
        gridPrinter(ghost);
    }

    public static void gridPrinter(int arr[][]) {
        for (int r = 0; r < 9; r++) {
            if (r % 3 == 0) {
                System.out.println("+---------+---------+----------+");
            }
            for (int c = 0; c < 9; c++) {
                if (c % 3 == 0) {
                    System.out.print("|");
                }
                System.out.print(" " + arr[r][c] + " ");
            }
            System.out.println(" |");
        }
        System.out.println("+---------+---------+----------+");
    }
}