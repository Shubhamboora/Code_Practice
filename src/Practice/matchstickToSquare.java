package Practice;

import java.util.Arrays;

public class matchstickToSquare {

    public static boolean makesquare(int[] matchsticks) {

        Arrays.sort(matchsticks);

        int sum = 0;
        for (int matchstick : matchsticks) sum += matchstick;

        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }

        int target = sum / 4;
        if (matchsticks.length < 4 || sum % 4 != 0 || matchsticks[0] > target) return false;

        return dfs(matchsticks, target, 0, 0, 0, new boolean[matchsticks.length]);

    }

    public static boolean dfs(int[] nums, int target, int curSum, int start, int count, boolean[] used) {

        if (count == 3) return true;

        if (curSum == target) return dfs(nums, target, 0, 0, count + 1, used);

        for (int i = start; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            if (curSum + nums[i] > target) continue;
            used[i] = true;
            if (dfs(nums, target, curSum + nums[i], i + 1, count, used)) return true;
            used[i] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        //int []arr={5,5,5,5,4,4,4,4,3,3,3,3};
        //int []arr={3,3,3,3,4};
        int[] arr = {1, 1, 2, 2, 2};
        //int []arr ={2,2,2,2,2,6};
        //int []arr= {2,2,2,2,2,6};
        boolean makesquare = matchstickToSquare.makesquare(arr);
        System.out.println(makesquare);

    }

}
