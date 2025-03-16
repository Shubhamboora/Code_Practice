package SdeSheet.Array;

import java.util.Arrays;

public class mergeSortedArray {
    public static void main(String[] args) {
        int[] num1 = {6,7,8,0,0,0};
        int[] num2 = {2,5,6};
        merge(num1, 3, num2, 3);

        Arrays.stream(num1).forEach( value -> System.out.println(value));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
