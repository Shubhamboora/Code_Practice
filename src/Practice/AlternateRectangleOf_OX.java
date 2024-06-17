package Practice;

public class AlternateRectangleOf_OX {

    public static char[][] createOX(int row, int column) {
        char[][] mat = new char[row][column];
        int rowStart = 0, rowEnd = mat.length - 1;
        int colStart = 0, colEnd = mat[0].length - 1;
        char c = 'O';

        while (rowStart <= rowEnd && colStart <= colEnd) {
            c = c == 'O' ? 'X' : 'O';
            for (int i = colStart; i <= colEnd; i++) {
                mat[rowStart][i] = c;
            }
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++) {
                mat[i][colEnd] = c;
            }
            colEnd--;

            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    mat[rowEnd][i] = c;
                }
                rowEnd--;
            }

            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    mat[i][colStart] = c;
                }
                colStart++;
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        int row = 5;
        int column = 5;
        char[][] createOX = AlternateRectangleOf_OX.createOX(row, column);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(createOX[i][j] + " ");
            }
            System.out.println();
        }
    }

}
