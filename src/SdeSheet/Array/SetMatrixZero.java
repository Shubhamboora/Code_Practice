package SdeSheet.Array;


import java.util.Arrays;

public class SetMatrixZero {

    public static void main(String[] args) {

        //int[][] arr = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        int[][] arr = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZero(arr);

        Arrays.stream(arr)
                .forEach(row ->{
                    Arrays.stream(row)
                            .forEach(value -> System.out.print(value + " "));
                    System.out.println();
                });
    }

    public static int[][] setZero(int[][] matrix){

        int row = matrix.length;
        int col = matrix[0].length;

        int col1 = 1;

        //Iterate over that 2D matrix
        for (int i = 0; i<row; i++){
            for (int j = 0; j< col; j++){

                // if any value is 0 we will enter below condition
                if (matrix[i][j] == 0){

                    //setting first column to 0 if encountered a 0 int that row
                    matrix[i][0] = 0;

                    /*here we will set first row to 0.
                    in else condition we update col1 variable instead of our matrix.*/
                    if (j !=0 ){
                        matrix[0][j] = 0;
                    }else {
                        col1 = 0;
                    }
                }


            }
        }

        /*start ittration from 1,1 add check if its first row or first column contains 0.
         if it dose mark that cell 0 too*/
        for (int i = 1;i<row; i++){
            for (int j = 1; j<col; j++){
                if (matrix[i][j] != 0)
                    if (matrix[i][0] == 0 || matrix[0][j] == 0)
                        matrix[i][j] = 0;
            }
        }

        //Updating first cell of rows.
        if (matrix[0][0] == 0){
            for (int j = 0; j<col; j++)
                matrix[0][j] = 0;
        }

        //Updating first cell of columns.
        if (col1 == 0){
            for (int i = 0; i<row; i++){
                matrix[i][0] = 0;
            }
        }



        return matrix;
    }
}
