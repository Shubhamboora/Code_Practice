package Task;

public class arr {

    public static void main(String[] args) {
        int arr[] = {3, 7, 5, 15, 2, 15, 15};
        int i = 0, j = arr.length - 1, preSum = arr[i], postSum = arr[j];

        while (i < j) {

            if (preSum < postSum) {
                preSum += arr[i];
                ++i;
            } else if (postSum < preSum) {
                postSum += arr[j];
                --j;
            } else {
                if (i + 1 == j - 1) {
                    System.out.println(i + 1);
                    break;
                }
                ++i;
            }
        }

    }

}
