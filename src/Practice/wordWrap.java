package Practice;

public class wordWrap {

	final int max = Integer.MAX_VALUE;
	static int sum = 0;
	 int print(int []p,int n,int lc[][]) {
		int k;
		 if(p[n]==1)
			 k=1;
		 else
			 k = print(p, p[n]-1,lc)+1;
		 
		 System.out.println("Line number" + k + ": from word no."+ p[n] + " to " + n);
		 wordWrap.sum +=lc[p[n]][n];
		 return k;
	}
	public static void main(String[] args) {
		wordWrap w = new wordWrap();
        int l[] = {3,2,2,5};
        int n = l.length;
        int M = 6;
        w.solveWordWrap (l, n, M);
        System.out.println("Number: "+w.sum);

	}

	private void solveWordWrap(int[] l, int n, int m) {
		
		int [][]extra = new int[n+1][n+1];
		int [][]lc = new int[n+1][n+1];
		int []c = new int[n+1];
		int []p = new int[n+1];
		
		//Filling extra array
		for(int i=1;i<=n;i++) {
			extra [i][i] = m-l[i-1];
			for(int j = i+1;j<=n;j++) {
				extra[i][j] = extra[i][j-1] - l[j-1] -1;
			}
		}
		
		//filling lc array
		for(int i=1;i<=n;i++) 
		{
			for(int j=i;j<=n;j++) 
			{
				if(extra[i][j]<0) {
					lc[i][j]=max;
				}else if(j==n && extra[i][j]>=0) {
					lc[i][j] = 0;
				}else {
					lc[i][j] = extra[i][j] * extra[i][j];
				}
			}
		}
		
		c[0]=0;
		
		for(int j=1;j<=n;j++) {
			c[j]=max;
			for(int i=1;i<=j;i++) {
				if(c[i-1]!=max && lc[i][j] != max && (c[i-1] +lc[i][j] <c[j])) {
					c[j] = c[i-1] +lc[i][j];
					p[j] = i;
				}
			}
		}
		
		print(p,n,lc);
	}

}
