package Task;

import java.util.LinkedList;


public class linkedListSum {
	
	public int sum(LinkedList<Integer> l1,LinkedList<Integer> l2) {
		int one =0;
		int two = 0,j=0,i=0,carry=0;
		String output = "";
		int arr[] = new int[l1.size()];
		int arr2[] = new int[l2.size()];
		for(int k: l1) {
			arr[j] = k;
			j++;
		}
		j=0;
		for(int k: l2) {
			arr2[j] = k;
			j++;
		}
		
		for(i= arr.length-1,j= arr2.length-1; i>=0||j>=0; i--,j--) {
			one = arr[i] +arr2[j]+carry;
			output += one%10;
			carry = one/10;
			
		}
		if(carry>0)output +=carry;
		for(int s=output.length()-1;s>=0;s--) {
			System.out.print(output.charAt(s));
		}
		
		return one+two;
	}

	public static void main(String[] args) {
		LinkedList<Integer> l1 = new LinkedList<>();
		LinkedList<Integer> l2 = new LinkedList<>();
		//initialising first linkedlist.
		l1.add(1);
		l1.add(3);
		l1.add(5);
		//initialising second linkedlist.
		l2.add(9);
		l2.add(0);
		l2.add(6);
		
		linkedListSum ss = new linkedListSum();
		ss.sum(l1, l2);


	}

}
