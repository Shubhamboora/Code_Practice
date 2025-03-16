package SdeSheet.Array;

import java.util.ArrayList;

public class findReversePairs {

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 3, 1};

        System.out.println(reversePairs(nums, 0, nums.length-1));
    }


    public static int reversePairs(int[] nums,int low,int high) {
        return mergerSort(nums, low, high);
    }

    private static int mergerSort(int[] nums, int low, int high) {

        int count = 0;
        if (low >= high) return count;

        int mid = (low + high) / 2;

        count += mergerSort(nums, low, mid);
        count += mergerSort(nums, mid + 1, high);
        count += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);

        return count;
    }

    public static int countPairs(int[] nums, int low, int mid, int high) {
        int count = 0, right = mid + 1;

        for (int i = low; i <= mid; i++) {
            while (right <= high && nums[i] > 2 * nums[right]) right++;
            count += (right - (mid + 1));
        }

        return count;
    }

    private static void merge(int[] nums, int low, int mid, int high) {

        ArrayList<Integer> list = new ArrayList<>();
        int left = low, right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                list.add(nums[left++]);
            } else {
                list.add(nums[right++]);
            }
        }

        while (left <= mid) {
            list.add(nums[left++]);
        }

        while (right <= high) {
            list.add(nums[right++]);
        }

        for (int i = low; i <= high; i++) {
            nums[i] = list.get(i - low);
        }
    }
}
