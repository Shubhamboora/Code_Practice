package SdeSheet.Array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args){

        //Generate single value
        System.out.println(GenerateValueTwo(5, 3));

        System.out.println();

        //Generate row.
        List<Long> row = generateRow(5);
        row.stream().forEach(element -> System.out.print(element + " "));

        //Generate complete triangle
        System.out.println();
        List<List<Long>> pascalsTriangle = printPascatsTriangle(5);
        pascalsTriangle.stream().forEach(list ->{
            list.stream().forEach(element -> System.out.print(element + " "));
                    System.out.println();
        }
        );
    }

    //Generate a particular element whose location is shared.

    public static long GenerateValue(long n, long r){

        n = n-1;
        r = r-1;
        long ans = 1;

        /*Loop will go Until r
         * Formula Used:
         *                n!
         *         ---------------
         *          (r! * (n-r)!)
         *
         * (n-r) value will be eliminated from numerator and denominator  as it is common.
         *
         *  */

        for (int i = 0; i<r; i++){
            ans = ans * (n - i);
            ans = ans / (i+1);
        }


        return ans;
    }

    //Generate a particular element whose location is shared.

    public static long GenerateValueTwo(long n, long r){

        long ans = 1;

        for (int i = 1; i<r; i++){
            ans = ans * (n - i);
            ans = ans / (i);
        }


        return ans;
    }



    //Generate a particular row where row number is shared.
    public static List<Long> generateRow(long n){
        List<Long> row = new ArrayList<>();

        long ans = 1;
        row.add(ans);

        /*Loop will go Until n
         * Formula Used:
         *                n!
         *         ---------------
         *          (r! * (n-r)!)
         *
         * (n-r) value will be eliminated from numerator and denominator  as it is common.
         *  ittration starts from 1
         *  */
        for (int i = 1; i<n; i++){
            ans = ans * (n - i);
            ans = ans / (i);

            row.add(ans);
        }

        return row;

    }


    //Generate complete pascale triangle.
    public static List<List<Long>> printPascatsTriangle(long n){
        List<List<Long>> result = new ArrayList<>();

        for (int i = 1; i <= n ; i++){
            result.add(generateRow(i));
        }

        return result;
    }
}
