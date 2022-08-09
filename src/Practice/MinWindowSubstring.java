package Practice;

import java.util.HashMap;

public class MinWindowSubstring {
	
	public static String window(String s, String t) {
		if(t.length() > s.length())return "";
		int start=0, end=0, count = 0, desired = t.length();
		HashMap<Character, Integer> str = new HashMap<>();
		HashMap<Character, Integer> target = new HashMap<>();
		String opt = "";
		for(char c: t.toCharArray())
			target.put(c, target.getOrDefault(c, 0) + 1);
		
		while(true) {
			boolean flag1 = false;
			boolean flag2 = false;
			while(end < s.length() && count < desired) {
				char c = s.charAt(end);
				str.put(c, str.getOrDefault(c, 0) + 1);
				if(target.getOrDefault(c,0) >= str.getOrDefault(c,0)) {
					count++;
				}
				end++;
				flag1 = true;
			}
			
			while(start < end && count >= desired) {
				String subString = s.substring(start, end);
				if(opt.length()==0 || opt.length() > subString.length()) {
					opt = subString;
				}
				
				char c = s.charAt(start++);
				
				if(str.get(c)>1)
					str.put(c, str.get(c)-1);
				else
					str.remove(c);
				
				if(target.getOrDefault(c, 0)>str.getOrDefault(c, 0))
					count--;
				
				flag2 = true;
			}
			
			if(flag1 == false && flag2 == false)
				break;
		}
		
		return opt;
	}

	public static void main(String[] args) {
		String s = "ADOBECODEBANC", t = "ABC";
		String window = window(s, t);
		System.out.println(window);
	}

}
