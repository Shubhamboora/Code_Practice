package Practice;

import java.util.Stack;

public class maximalRectangle {

    public int maximal(char[][] matrix) {
        int opt = 0;
        int arr[] = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0) {
                    arr[j] = Character.getNumericValue(matrix[i][j]);
                } else {
                    arr[j] = matrix[i][j] == '0' ? 0 : Character.getNumericValue(matrix[i][j]) + arr[j];
                }
            }
            opt = Math.max(opt, area(arr));
        }
        return opt;
    }

    static int area(int[] arr) {
        int n = arr.length;
        int max = 0;

        Stack<Integer> stk = new Stack<>();
        int rb[] = new int[n];
        int lb[] = new int[n];

        stk.push(n - 1);
        rb[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            while (stk.size() > 0 && arr[i] <= arr[stk.peek()])
                stk.pop();
            if (stk.size() == 0)
                rb[i] = n;
            else
                rb[i] = stk.peek();
            stk.push(i);
        }

        stk.clear();

        stk.push(0);
        lb[0] = -1;
        for (int i = 1; i < n; i++) {
            while (stk.size() > 0 && arr[i] <= arr[stk.peek()])
                stk.pop();
            if (stk.size() == 0)
                lb[i] = -1;
            else
                lb[i] = stk.peek();
            stk.push(i);
        }

        for (int i = 0; i < n; i++) {
            int area = (rb[i] - lb[i] - 1) * arr[i];
            max = Math.max(max, area);
        }
        return max;
    }

    public static void main(String[] args) {
        maximalRectangle rect = new maximalRectangle();
        char matrix[][] = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        int maximal = rect.maximal(matrix);
        System.out.println(maximal);

    }

}
