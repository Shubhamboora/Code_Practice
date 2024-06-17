package Sorting;

public class mergeSort {

    public static long divide(int arr[], int start, int end) {
        if (start >= end) {
            return 0;
        }
        long count = 0L;

        int mid = start + ((end - start) / 2);
        count += divide(arr, start, mid);
        count += divide(arr, mid + 1, end);

        count += conquer(arr, start, mid, end);

        return count;
    }

    public static long conquer(int arr[], int start, int mid, int end) {
        long count = 0;

        int merger[] = new int[end - start + 1];

        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                merger[k++] = arr[i++];
            } else {
                merger[k++] = arr[j++];
                count += mid - i + 1;
            }
        }

        while (i <= mid) {
            merger[k++] = arr[i++];
        }
        while (j <= end) {
            merger[k++] = arr[j++];
        }

        for (int z = 0, x = start; z < merger.length; z++, x++) {
            arr[x] = merger[z];
        }
        return count;
    }

    public static void main(String args[]) {
        int arr[] = {2, 1, 3, 1, 2};
        long inv = mergeSort.divide(arr, 0, arr.length - 1);
        System.out.println("Number of inversions: " + inv);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
