package SdeSheet.Array;

public class searchingInSorted2DMatrix {

    public static void main(String[] args) {
        searchingInSorted2DMatrix searching = new searchingInSorted2DMatrix();
        int arr[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        System.out.println(searching.findRow(arr, 13));

    }

    public boolean binerySearch(int arr[][], int target, int row){
        int low = 0, high = arr[0].length-1;


        while(low <= high){

            int mid = (low + high)/2;
            if (arr[row][mid] == target) return true;
            else if(arr[row][mid] > target){
                high = mid;
            }else{
                low = mid + 1;
            }
        }

        return false;
    }

    public boolean findRow(int arr[][], int target){
        int low = 0, high = arr[0].length-1;

        for(int i = 0; i<arr.length; i++){
            if(arr[i][0] <= target && arr[i][high] >= target){
                if (binerySearch(arr, target, i))return true;
            }
        }
        return false;
    }
}
