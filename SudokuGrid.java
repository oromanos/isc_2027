public class SudokuGrid {
    public static void main(String[] args) {
        SudokuGrid ob = new SudokuGrid();
        ob.gridPrinter();
    }

    public void gridPrinter() {
        for (int r = 0; r < 9; r++) {
            if (r % 3 == 0) {
                System.out.println("+------+------+-------+");
            }
            for (int c = 0; c < 9; c++) {
                if (c % 3 == 0) {
                    System.out.print("|");
                }
                System.out.print(" .");
            }
            System.out.println(" |");
        }
        System.out.println("+------+------+-------+");
    }

}
