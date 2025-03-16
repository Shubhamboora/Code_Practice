package SdeSheet.Array;

import java.util.ArrayList;

public class inversionOfArray {
    public static void main(String[] args) {
        int arr[] = {1,3,4,7,2,6,5};

        int count = numberOfInversions(arr, arr.length);

        System.out.println(count);
    }

    private static int numberOfInversions(int[] arr, int length) {

        return mergeSort(arr,0, length-1);
    }

    private static int mergeSort(int[] arr,int low, int high) {

        int count = 0;
        if(low >= high) return count;
        int mid = (low + high)/2;

        //split array on left
        count += mergeSort(arr, low, mid);

        //split array on right
        count += mergeSort(arr, mid+1, high);

        //sort and combine
        count += merge(arr, low, mid, high);

        return count;
    }

    private static int merge(int[] arr, int low, int mid, int high) {

        int count = 0,
         left = low,  //starting point of first array.
         right = mid+1;  //starting point of second array.


        ArrayList<Integer> list = new ArrayList<>();

        //keep iterating until we reach end of one of the array.
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                list.add(arr[left++]);
            }else{
                //because both array are sorted and if one element is found greater all next elements will also be greater
                //for ex: left{5,6,7}  right[1,8,9] => if 1 is smaller then 5 it is smaller then 6 and 7 also.
                count += (mid-left) + 1;
                list.add(arr[right++]);
            }
        }

        //leftovers of left array
        while(left <= mid ){
            list.add(arr[left++]);
        }

        //leftovers of right array
        while(right <= high ){
            list.add(arr[right++]);
        }

        //copy sorted list into array.
        for( int i = low; i <= high; i++ ){
            arr[i] = list.get(i-low);
        }

        return count;
    }
}
