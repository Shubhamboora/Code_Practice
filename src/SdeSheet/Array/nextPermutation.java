package SdeSheet.Array;

import java.util.Arrays;

public class nextPermutation {

    public static void main(String[] args){
        int[] nums = {1,3,4,5,2,0,0};
        nextPermutation next = new nextPermutation();
        next.nextPermutationOrder(nums);
        Arrays.stream(nums).forEach( num -> System.out.print(num + " "));
    }

    public void nextPermutationOrder(int[] nums){

        int index = -1;

        //First we need to find a value whose next value is greater then itself.
        // value on index  i is smaller then value on (i + n)
        for (int i = nums.length-2; i>=0; i--){
            if (nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }
        //if index is -1 that means array is in decending order and there is no next permuitation.
        //in that case we will sort it in asc order and return.
        if (index == -1){
            Arrays.sort(nums);
            return;
        }

        //Second we need to find a value which occur after the occurrence of (i+n) in that array but is smaller then i.
        for (int i = nums.length-1; i>index; i--){
            if (nums[i] > nums[index]){
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                break;
            }
        }

        //reverse the array after index i.
        for (int i = index+1, j = nums.length-1; i < j; i++, j--){
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }
}
