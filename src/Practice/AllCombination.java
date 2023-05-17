package Practice;

public class AllCombination {
	public static void CombinationUtil(int[] arr, int[] subArr, int position, int j, int r) {

		// checking git
		if(position == r) {
			for(int i : subArr)
				System.out.print(i+" ");
			System.out.println();
			return;
		}
		
		if(j >= arr.length)return;
		subArr[position] = arr[j];
		CombinationUtil(arr, subArr, position+1, j+1, r);
		CombinationUtil(arr, subArr, position, j+1, r);
	}
	public static void setup(int []arr,int r) {
		int subArr[] = new int[r];
		CombinationUtil(arr, subArr, 0, 0, r);
	}

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5};
		int r = 3;
		AllCombination.setup(arr, r);
		

	}

}
