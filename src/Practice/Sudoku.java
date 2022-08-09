package Practice;

import java.util.HashSet;

public class Sudoku {
	
	public static boolean isValidSudoku(char[][] board) {

        Boolean cellCheck = Sudoku.cellRotating(board);
        Boolean rcCheck = Sudoku.RowColumnCheck(board);
        
        if(rcCheck && cellCheck)
            return true;
    
        return false;
    
    }

	public static boolean cellRotating(char[][] board){
        String [] arr = {"0,0","0,3","0,6","3,0","3,3","3,6","6,0","6.3","6.6"};
        HashSet<Character> set = new HashSet<>();
        
        for(int i = 0;i<arr.length;i++ ){
            int startRow = (int) arr[i].charAt(0) - '0';
            int startCol = (int) arr[i].charAt(arr[i].length()-1) - '0';
            int endRow = startRow + 2, endCol = startCol+2;
            
            while(startRow<=endRow && startCol <= endCol){
                
                for(int j=startCol; j<=endCol;j++){
                    if(board[startRow][j] != '.'){
                        if(!set.add(board[startRow][j]))
                            return false;
                    }
                }
                startRow++;
                
                for(int j=startRow;j<=endRow;j++){
                    if(board[j][endCol] != '.'){
                        if(!set.add(board[j][endCol]))
                            return false;
                    }
                }
                endCol--;
                
                if(startRow<=endRow){
                    for(int j=endCol;j>=startCol;j--){
                    if(board[endRow][j] != '.'){
                        if(!set.add(board[endRow][j]))
                            return false;
                    }
                }
                    endRow--;
                }
                if(startCol<=endCol){
                    for(int j=endRow;j>=startRow;j--){
                    if(board[j][startCol] != '.'){
                        if(!set.add(board[j][startCol]))
                            return false;
                    }
                }
                    startCol++;
                }
                
            }
            set.clear();
        }
        return true;
    }
	
	public static boolean cell(char[][] board){
        String [] arr = {"0,0","0,3","0,6","3,0","3,3","3,6","6,0","6.3","6.6"};
        HashSet<Character> set = new HashSet<>();
        
        
        outer:
        for(int k=0;k<arr.length;k++){
            int i=arr[k].charAt(0) -'0';
            int j=arr[k].charAt(arr[k].length()-1) -'0';
            int check1 = i,check2 = j;
            set.clear();
            int count = 0;
            
            while(i!=check1+2 || j!=check2+2){
                
                if(count ==3){
                    i=i+1;
                    j=j-count;
                    count=0;
                }
                
                if(board[i][j]!='.'){
                    if(set.add(board[i][j])){
                    	j++;
                        count++;
                        continue;
                    }else{
                        return false;
                    }
                }
                j++;
                count++;
            }
            
            if(board[i][j]!='.'){
                if(!set.add(board[i][j]))
                    return false;
                
            }
            
        }
        return true;
    }
	
	public static boolean RowColumnCheck(char[][]board) {
		int i=0,j=0;
		HashSet<Character> set = new HashSet<>();
		while(i<9) {
			for(int x = 0;x<9;x++) {
				if(board[i][x]!='.')
				if(!set.add(board[i][x]))
					return false;
			}
			set.clear();
			i++;
		}
		i=0;
		while(i<9) {
			for(int x = 0;x<9;x++) {
				if(board[x][i]!='.')
				if(!set.add(board[x][i]))
					return false;
			}
			set.clear();
			i++;
		}
		
		return true;
	}
	public static void main(String[] args) {
		char [][]board ={{'.','.','4','.','.','.','6','3','.'}
						,{'.','.','.','.','.','.','.','.','.'}
						,{'5','.','.','.','.','.','.','9','.'}
						,{'.','.','.','5','6','.','.','.','.'}
						,{'4','.','3','.','.','.','.','.','1'}
						,{'.','.','.','7','.','.','.','.','.'}
						,{'.','.','.','5','.','.','.','.','.'}
						,{'.','.','.','.','.','.','.','.','.'}
						,{'.','.','.','.','.','.','.','.','.'}};
		
		boolean cell = Sudoku.isValidSudoku(board);
		System.out.println(cell);

	}

}
