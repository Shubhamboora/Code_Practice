package Practice;

import java.util.Arrays;

public class Sit {
    public static int searchInsert(int[] nums, int target) {
        int opt = Sit.binarySearch(nums,0,nums.length-1,target);
        if(opt>-1){
            return opt;
        }else{
            while(target>=0){
                opt = Sit.binarySearch(nums,0,nums.length-1,target);
                if(opt>-1)return opt+1;
                target--;
            }
            return 0;
        }
        
    }
    
    public static int binarySearch(int []nums,int start, int end,int target){
        
        int mid = start + ((end-start)/2);
        
        if(start>end){
            
            return -1;
        }
        
        if(nums[mid] == target){
            return mid;
        }
        
        if(target<nums[mid])
            return binarySearch(nums, start,mid-1,target);
        else
            return binarySearch(nums, mid+1,end,target);
        
    }
    
    public static void main(String[] args) {
		int nums[]= {-1,3,5,6};
		//int nums[]= {3,2,2,3};
		int duplicates = Sit.searchInsert(nums,0);
			System.out.println(duplicates);
		
	}
}


	


