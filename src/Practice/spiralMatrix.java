package Practice;

public class spiralMatrix {
    //Print in sperical order
    static void display(int[][] matrix) {
        int check = 0;
        int i = 0, j = 0;
        int row = matrix.length;
        int column = matrix[0].length;
        int itt = row * column;
        int k = 0;
        outer:
        while (itt > 0) {
            k = column;
            while (k - check > 0) {
                if (itt == 0) break outer;
                System.out.print(matrix[i][j++] + " ");
                k--;
                itt--;
            }
            j--;
            i++;
            k = row;

            while (k - check - 1 > 0) {
                if (itt == 0) break outer;
                System.out.print(matrix[i++][j] + " ");
                itt--;
                k--;
            }
            i--;
            j--;

            check = check + 1;
            k = column;
            while (k - check > 0) {
                if (itt == 0) break outer;
                System.out.print(matrix[i][j--] + " ");
                itt--;
                k--;
            }
            j++;
            i--;
            k = row;
            while (k - check - 1 > 0) {
                if (itt == 0) break outer;
                System.out.print(matrix[i--][j] + " ");
                itt--;
                k--;
            }
            i++;
            j++;
            check = check + 1;

        }
    }

    //Rotate matrix
    static int[][] rotate(int[][] matrix) {

        int check = 0;
        int i = 0, j = 0;
        int row = matrix.length;
        int column = matrix[0].length;
        int itt = row - 1;
        int k = 0;
        int temp = 0;
        boolean flag = true;

        outer:
        while (itt > 0) {
            k = column;
            while (k - check > 0) {
                if (itt == 0) break outer;
                if (flag) {
                    temp = matrix[i][j++];
                    flag = false;
                    k--;
                    continue;
                }
                int rep = matrix[i][j];
                matrix[i][j++] = temp;
                temp = rep;
                k--;
            }
            j--;
            i++;
            k = row;

            while (k - check - 1 > 0) {
                if (itt == 0) break outer;
                int rep = matrix[i][j];
                matrix[i++][j] = temp;
                temp = rep;
                k--;
            }
            i--;
            j--;

            check = check + 1;
            k = column;
            while (k - check > 0) {
                if (itt == 0) break outer;
                int rep = matrix[i][j];
                matrix[i][j--] = temp;
                temp = rep;
                k--;
            }
            j++;
            i--;
            k = row;
            while (k - check - 1 > 0) {
                if (itt == 0) break outer;
                int rep = matrix[i][j];
                matrix[i--][j] = temp;
                temp = rep;
                k--;
            }

            int rep = matrix[i][j];
            matrix[i++][j++] = temp;
            temp = rep;
            check = check + 1;
            itt--;
            flag = true;

        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};
        spiralMatrix.display(matrix);
        int[][] arr = spiralMatrix.rotate(matrix);
        System.out.println();
        spiralMatrix.display(arr);
    }

}
