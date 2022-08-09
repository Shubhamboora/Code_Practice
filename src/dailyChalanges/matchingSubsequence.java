package dailyChalanges;

import java.util.HashMap;

public class matchingSubsequence {
	
	public static int numMatchingSubseq(String s, String[] words) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String str : words)
            map.put(str, map.getOrDefault(str,0)+1);
        int n = words.length;
        int i=0,count = 0;;
        for(String str: map.keySet()){
            String check = str;
            for(int j=0,k=0;j<s.length() && k<check.length();j++){
                if(s.charAt(j)==check.charAt(k))k++;
                if(k==check.length())count+=map.get(str);
            }
        }
        return count;
    }

	public static void main(String[] args) {
		String s = "dsahjpjauf";
		String words[] = {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
		
		int subseq = matchingSubsequence.numMatchingSubseq(s, words);
		System.out.println(subseq);

	}

}
