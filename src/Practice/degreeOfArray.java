package Practice;

import java.util.HashMap;

public class degreeOfArray {

    public int degree(int[] arr) {
        int length = 0, degree = 0;
        HashMap<Integer, Integer> firstOccurance = new HashMap<>();
        HashMap<Integer, Integer> frequency = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!firstOccurance.containsKey(arr[i])) firstOccurance.put(arr[i], i);
            frequency.put(arr[i], frequency.getOrDefault(arr[i], 0) + 1);

            if (frequency.get(arr[i]) > degree) {
                degree = frequency.get(arr[i]);
                length = i - firstOccurance.get(arr[i]) + 1;
            }

            if (degree == frequency.get(arr[i])) {
                length = Math.min(length, i - firstOccurance.get(arr[i]) + 1);
            }
        }

        return length;
    }

    public static void main(String[] args) {
        degreeOfArray len = new degreeOfArray();
        int[] arr = {1, 2, 2, 3, 1};
        System.out.println(len.degree(arr));

    }

}
