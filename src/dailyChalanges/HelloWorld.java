package dailyChalanges;

class HelloWorld {
    public static void main(String[] args) {
        long m = minimumReplacement(new int[]{1, 2, 5, 10, 3});
        System.out.println(m);
    }


    public static long minimumReplacement(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int prev = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            int noofDeletions = nums[i] / prev;
//             if(nums[i]%prev!=0){
//                 noofDeletions++;
//             }
            if (nums[i] % prev != 0) {
                prev = nums[i] / ++noofDeletions;
            }
            ans += noofDeletions - 1;
        }
        return ans;
    }

}
