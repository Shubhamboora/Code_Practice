package SdeSheet.Array;

public class findMissingAndRepeatingNumber {
    public static void main(String[] args) {

        long[] nums = {1,2,3,4,6,7,9,5,9};
        long[] numbers = findNumbers(nums);

        System.out.println("Repeating number: "+numbers[0]);
        System.out.println("missing number: "+numbers[1]);
    }

    public static long[] findNumbers(long[] nums){
        long[] result = new long[2];

        long n = nums.length;
        // formula to find sum of n natural numbers.
        long sumOfNaturalNumbers = (n * (n + 1)) / 2;

        // formula to find sum of the square of n natural numbers.
        long sumOfSquareOfNaturalNumbers = (n * (n + 1) * (2 * n + 1)) / 6;

        long sumOfArray = 0, sumOfSquareOfArray = 0;

        for (int i = 0; i< n; i++){
            sumOfArray += nums[i];
            sumOfSquareOfArray += nums[i] * nums[i];
        }

        // x - y = sumOfArray - sumOfNaturalNumbers      -----------------case1
        long equationOne = sumOfArray - sumOfNaturalNumbers;

        //x^2 - y^2 = sumOfSquareOfArray - sumOfSquareOfNaturalNumbers
        //It will give => ( x + y ) * ( x - y ) = sumOfSquareOfArray - sumOfSquareOfNaturalNumbers
        long equationTwo = sumOfSquareOfArray - sumOfSquareOfNaturalNumbers;

        //dividing difference of squares with difference of sum of numbers.
        // ( x + y ) = sumOfSquareOfArray - sumOfSquareOfNaturalNumbers           ---------- case2
        //          --------------------------------------------------------
        //                               ( x - y )
        /*
        NOW we know that ( x + y ) * ( x - y ) = sumOfSquareOfArray - sumOfSquareOfNaturalNumbers
            will put x, y equation in case 2.
             ( x + y ) =                (x^2 - y^2)     ------- equationTwo
                                  --------------------------
                                           ( x - y )    ------- equationOne
        */
        equationTwo = equationTwo / equationOne; // x + y

        /*
        *  x - y = equationOne  <- |
        *  x + y = equationTwo  <- |  subtracting these equations.
        * ---------------------
        * 2x = equationOne - equationTwo
        *
        * x = ( equationOne - equationTwo ) / 2
        * ----------------------
        * */
        result[0] = ( equationOne + equationTwo ) /2; //repeating number (x)


        /*
        * from case 1:  x - y = equationOne
        *
        * y = equationOne - x ==> x - equationOne
        * */
        result[1] = ( result[0] - equationOne ); //missing number

        return result;
    }
}
