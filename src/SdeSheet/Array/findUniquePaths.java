package SdeSheet.Array;

import java.util.HashMap;

public class findUniquePaths {

    public static void main(String[] args) {
        int row = 2, column = 3;

        System.out.println(uniquePaths( row, column ));

    }

    public static long uniquePaths(int row, int column){
        HashMap<String, Long> map = new HashMap<>();
        long totalPaths= paths(row, column, 0,0,map);
        return totalPaths;
    }

    private static long paths(int row, int column, int i, int j, HashMap<String, Long> map) {

        String key = i + "," + j;

        //for faster search. In case we reach a point we already calculated.
        if ( map.containsKey(key) ) return map.get(key);

        //In case i or j move out of the matrix.
        if ( i >= row || j >= column ) return 0;

        //In case we reach in last row or last column. we will definitely find a way if if move right or down respectively.
        if ( i == row - 1 || j == column - 1 ) return 1;

        //moving in down and right direction and adding the sum.
        long sum = paths(row, column, i + 1, j, map) + paths(row, column, i, j + 1, map);

        //making entry in map for this path so that next time do not need to trace complete route again.
        map.put(key, sum);

        return sum;

    }
}
