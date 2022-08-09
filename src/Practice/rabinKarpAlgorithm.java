package Practice;

public class rabinKarpAlgorithm {

	final static int d = 256;
	
	static void FindPattern(String text, String pattern, int q) {
		int t = 0; //Hash value of text.
		int p = 0; // Hash value of pattern.
		int h = 1;
		
		for(int i=0; i<pattern.length();i++) {
			h = (h * d)%q;
		}
		
		for(int i=0;i<pattern.length();i++) {
			p = (d*p + pattern.charAt(i))%q;
			t = (d*t + text.charAt(i))%q;
		}
		
		for(int i=0, j; i <= text.length() - pattern.length();i++) {
			if(p == t) {
				for(j = 0; j < pattern.length() ; j++) 
					if(pattern.charAt(j) != text.charAt(j + i))
						break;
				
				if(j == pattern.length())
					System.out.println("Pattern found at index: "+ (i));
			}else {
				if(i<= text.length() - pattern.length()) {
					t = (d*( t - text.charAt(i)*h) + text.charAt(i + pattern.length()))%q;
					
					if(t<0)
						t += q;
				}
			}
		}
	}
	public static void main(String[] args) {
		String str = "ababbbabbabaababab";
		String search = "abab";
		//String str = "abab";
//		String search = "abab";
		int q = 101;// A prime number.
		rabinKarpAlgorithm.FindPattern(str, search, q);

	}

}
