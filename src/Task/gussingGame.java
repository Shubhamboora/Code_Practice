package Task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class gussingGame {

	public static void main(String[] args) {
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("employee", "0");
		map1.put("manager", "");
		HashMap<String,String> map2 = new HashMap<String,String>();
		map2.put("employee", "1");
		map2.put("manager", "0");
		HashMap<String,String> map3 = new HashMap<String,String>();
		map3.put("employee", "2");
		map3.put("manager", "1");
		List<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
		list.add(map1);
		list.add(map2);
		list.add(map3);
		//System.out.println(list);
		
		HashMap<Integer,Integer> hm = new HashMap<>();
		for(int i=0;i<list.size();i++) {
			int mgr=0;
			int emp=0;
			if((list.get(i).get("manager").equals(""))){
				emp = Integer.parseInt(list.get(i).get("employee"));
			}else {
				mgr = Integer.parseInt(list.get(i).get("manager"));
				emp = Integer.parseInt(list.get(i).get("employee"));
			}
			hm.put(mgr, emp);
		}
		
		

		 int start = (int) hm.keySet().toArray()[0];
		 int init = start;
		 boolean flag = true;
		 while(flag) {
			 if(init == hm.get(init)) {
				 System.out.println("At the top");
				 break;
			 }
			 init = hm.get(init);
			 if(start==init) {
				 System.out.println("Cycle found..");
				 break;
			 }
			 if(!hm.containsKey(init)) {
				 System.out.println("Reached to the bottom..");
				 break;
			 }
		 }
	}
	
}
