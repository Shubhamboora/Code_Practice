package Practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class mergingIntervals {

    public int[][] merge(int[][] arr) {

        Arrays.sort(arr, new Comparator<int[]>() {

            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] interval : arr) {

            if (list.size() < 1 || list.getLast()[1] < interval[0])
                list.add(interval);
            else
                list.getLast()[1] = list.getLast()[1] > interval[1] ? list.getLast()[1] : interval[1];
        }
        ;
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 4}, {2, 5}, {1, 9}, {1, 3}, {2, 6}, {8, 10}, {15, 18}};
        mergingIntervals add = new mergingIntervals();
        int[][] merge = add.merge(arr);

        for (int[] interval : merge) {
            for (int i : interval)
                System.out.print(i + " ");
            System.out.println();
        }

    }

}
