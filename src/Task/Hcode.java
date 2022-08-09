package Task;

import java.util.Arrays;

public class Hcode {
	public static int maxThree(int[] l) {
		int sum = 0, rem = 0, output = 0, n = l.length;
		for (int i : l) {
			sum += i;
		}
		Hcode.sortArr(l, n);
		// java.util.Arrays.sort(l);
		rem = sum % 3;
		if (rem != 0) {
			int[] removeExtra = Hcode.removeExtra(l, rem, sum, n);
			if (removeExtra[0] == -1 && removeExtra[1] == -1) {
				return 0;
			} else {
				if (removeExtra[0] != -1)
					l[removeExtra[0]] = -1;

				if (removeExtra[1] != -1)
					l[removeExtra[1]] = -1;
			}
		}
		for (int i = n - 1; i >= 0; i--) {
			if (l[i] > -1) {
				if (output == 0)
					output += l[i];
				else {
					output *= 10;
					output += l[i];
				}
			}
		}
		return output;
	}

	public static int[] removeExtra(int []l, int rem,int sum,int n) {
		 
		int arr[] = new int[2];
		arr[0] = -1;
		arr[1] = -1;

		if (rem == 1) {
			for (int i = 0; i < n; i++) {
				// If first number is found with reminder 1 pass its index
				if (l[i] % 3 == 1) {
					arr[0] = i;
					return arr;
				}
				// If both numbers found with reminder 2 before 1 pass there index
				if (l[i] % 3 == 2) {
					if (arr[0] == -1) {
						arr[0] = i;
					} else {
						arr[1] = i;
						return arr;
					}
				}
			}
		} else if (rem == 2) {
			for (int i = 0; i < n; i++) {
				// If first number is found with reminder 2 pass its index
				if (l[i] % 3 == 2) {
					arr[0] = i;
					return arr;
				}
				
			}
				// If both numbers found with reminder 1 before 2 pass there index
			for (int i = 0; i < n; i++) {
				if (l[i] % 3 == 1) {
					if (arr[0] == -1) {
						arr[0] = i;
					} else {
						arr[1] = i;
						return arr;
					}
				}
			}
		}
		return arr;
	 }

	static void sortArr(int arr[], int n) {
// Store count of all elements
		int[] count = new int[10];
		for (int i = 0; i < n; i++) {
			count[arr[i]]++;
		}

// Store
		int index = 0;
		for (int i = 0; i < 10; i++) {
			while (count[i] > 0) {
				arr[index++] = i;
				count[i]--;
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = { 3, 1, 4, 1, 5, 9 };
		int maxThree = Hcode.maxThree(arr);
		System.out.println(maxThree);

	}

}
