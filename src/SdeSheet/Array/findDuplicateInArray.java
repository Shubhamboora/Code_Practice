package SdeSheet.Array;

public class findDuplicateInArray {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
        System.out.println(findDuplicateWithoutExtraSpace(nums));
    }

    public static int findDuplicate(int[] nums) {

        //Create an array with one bigger size
        //keep adding 1 on same index value which is found in nums array
        //in case value was alrady 1. we found repeating element
        int[] frequency = new int[nums.length+1];

        for (int i = 0; i<nums.length; i++){
            if(frequency[nums[i]] == 0){
                frequency[nums[i]] = frequency[nums[i]]+1;
            }else{
                return nums[i];
            }
        }
        return 0;
    }

    public static int findDuplicateWithoutExtraSpace(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        fast = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
