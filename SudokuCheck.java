
public class SudokuCheck {

    public boolean validGrid(int arr[][]) {

        int i, j, g, sum;

        // checking row

        for (i = 0; i < 9; i++) {
            sum = 0;
            for (j = 0; j < 9; j++) {
                if (arr[i][j] == 0)
                    continue;
                else if ((sum & (int) Math.pow(2, arr[i][j])) != 0) {
                    return false;
                }
                sum += (int) Math.pow(2, arr[i][j]);
            }

        }

        // checking cols

        for (j = 0; j < 9; j++) {
            sum = 0;
            for (i = 0; i < 9; i++) {
                if (arr[i][j] == 0)
                    continue;
                else if ((sum & (int) Math.pow(2, arr[i][j])) != 0) {
                    return false;
                }
                sum += (int) Math.pow(2, arr[i][j]);
            }

        }

        // checking 3*3

        for (g = 0; g < 9; g++) {

            sum = 0;

            for (i = (g / 3) * 3; i < (g / 3 + 1) * 3; i++) {

                for (j = (g % 3) * 3; j < (g % 3 + 1) * 3; j++) {

                    if (arr[i][j] == 0)
                        continue;
                    else if ((sum & (int) Math.pow(2, arr[i][j])) != 0) {
                        return false;
                    }
                    sum += (int) Math.pow(2, arr[i][j]);
                }

            }

        }
        return true;
    }

}
