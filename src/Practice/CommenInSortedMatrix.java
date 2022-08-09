package Practice;

public class CommenInSortedMatrix {
	
	public static int findCommon(int [][]mat) {
		
		int row = mat.length;
		int col = mat[0].length;
		
		int column[] = new int[row];
		
		int min_row = 0;
		for(int i=0;i<row;i++)
			column[i] = col-1;

		while(column[min_row]>=0) {
			
			for(int i=0;i<row;i++) {
				if(mat[i][column[i]]<mat[min_row][column[min_row]])
					min_row = i;
			}
			
			int equ = 0;
			
			for(int i =0;i<row;i++) {
				if(mat[i][column[i]]>mat[min_row][column[min_row]]) {
					if(column[i]==0)
						return -1;
					
					column[i] = column[i]-1;
				}else {
					equ++;
				}
			}
			if(equ == row)
				return mat[min_row][column[min_row]];
		}
		
		return -1;
	}

	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 3, 4, 5 },
                		{ 2, 4, 5, 8, 10 },
                		{ 3, 5, 7, 9, 11 },
                		{ 1, 3, 5, 7, 9 } };
		int result = findCommon(mat);
		if (result == -1)
			System.out.print("No common element");
		else
			System.out.print("Common element is " + result);

	}

}
