package Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class abstraction {

	public static void main(String[] args) {
		int arr[] = {1,2,4,3,6,5,7,8};
		//Arrays.stream(arr).sorted((x,y)->x).forEach(System.out::println);
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(7);
		list.add(6);
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.stream().sorted((x,y)->y.compareTo(x)).map(i->i*i).forEach(System.out::println);
		
		
	}

}
