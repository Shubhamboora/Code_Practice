package Practice;

import java.util.ArrayList;

public class DiagonalTraversal {

	static ArrayList<Integer> downwardDigonal(int n, int A[][]) {
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int k=0;k<n;k++) {
			int i = 0;
			int j = k;
			while(j>=0 && i<n) {
				System.out.print(A[j][i]+" ");
				i++;
				j--;
			}
		}
		
		for(int k=1;k<n;k++) {
			int i = n-1;
			int j=k;
			while(j!=n) {
				System.out.print(A[i][j]+" ");
				j++;
				i--;
			}
			
		}
		return list;
	}

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3, 10}
					   ,{ 4, 5, 6, 11}
					   ,{ 7, 8, 9, 12}
					   ,{ 13,14,15,16}};
		//int arr[][] = {{}};
		DiagonalTraversal.downwardDigonal(4, arr);
	}

}
