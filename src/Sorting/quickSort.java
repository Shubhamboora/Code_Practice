package Sorting;

public class quickSort {


    int partition(int arr[], int start, int end) {
        int pivot = arr[end];


        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                int t = arr[start];
                arr[start] = arr[i];
                arr[i] = t;
                start++;
            }
        }
        int t = arr[start];
        arr[start] = arr[end];
        arr[end] = t;
        return start;
    }

    void quick(int arr[], int start, int end) {
        if (start < end) {
            int p = partition(arr, start, end);
            quick(arr, start, p - 1);
            quick(arr, p + 1, end);

        }
    }

    public static void main(String[] args) {
        int arr[] = {10, 15, 2, 21, 6, 56, 4, 44, 74};
        //int arr[] = {10,50,30,70,20};

        quickSort s = new quickSort();
        s.quick(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
