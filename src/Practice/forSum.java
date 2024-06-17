package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class forSum {

//	public static List<List<Integer>> kSum(int[] nums, int target) {
//		List<List<Integer>> list = new ArrayList<>();
//	}

    public static List<List<Integer>> utility(int[] nums, long target, int k, int start, int end) {
        List<List<Integer>> list = new ArrayList<>();
        if (start > end) return list;

        long avg = target / k;

        if (nums[start] > avg || nums[end] < avg) return list;

        if (k == 2) {
            return forSum.twoSum(nums, target, start, end);
        }

        for (int i = start; i <= end; i++) {
            if (i == start || nums[i] != nums[i - 1]) {
                for (List<Integer> set : utility(nums, target - nums[i], k - 1, i + 1, end)) {
                    list.add(new ArrayList<>(Arrays.asList(nums[i])));
                    list.get(list.size() - 1).addAll(set);
                }
            }
        }
        return list;
    }

    public static List<List<Integer>> twoSum(int[] nums, long target, int start, int end) {
        List<List<Integer>> list = new ArrayList<>();
        int low = start, high = end;

        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum < target || (low > start && nums[low] == nums[low - 1])) {
                low++;
            } else if (sum > target || (high < end && nums[high] == nums[high + 1])) {
                high--;
            } else {
                list.add(Arrays.asList(nums[low++], nums[high--]));
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        Arrays.sort(nums);

        List<List<Integer>> twoSum = forSum.utility(nums, target, 3, 0, nums.length - 1);
        for (int i = 0; i < twoSum.size(); i++) {
            for (int j = 0; j < twoSum.get(i).size(); j++) {
                System.out.print(twoSum.get(i).get(j) + " ");
            }
            System.out.println();
        }


    }

}
