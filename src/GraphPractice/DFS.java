package GraphPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class DFS {
	public static HashMap<Integer,LinkedList<Integer>> graph = new HashMap<>();
	
	public void DepthFirstSearch(int search) {
		Stack<Integer> st = new Stack<>();
		boolean visited[] = new boolean[graph.size()+1];
		st.push(search);
		visited[search] = true;
		
		while(!st.isEmpty()) {
			Integer popped = st.pop();
			System.out.print(popped+", ");
			LinkedList<Integer> arrayList = graph.get(popped);
			for(int a: arrayList) {
				if(visited[a]!=true) {
					st.push(a);
					visited[a]=true;
				}
			}
		}
	}
	
	public void WidthFirstSearch(int search) {
		Queue<Integer> que = new LinkedList<>();
		boolean visited[] = new boolean[graph.size()+1];
		que.offer(search);
		visited[search] = true;
		
		while(!que.isEmpty()) {
			Integer poll = que.poll();
			System.out.print(poll+", ");
			LinkedList<Integer> arrayList = graph.get(poll);
			for(int a: arrayList) {
				if(visited[a]!= true) {
					que.offer(a);
					visited[a]=true;
				}
			}
		}
	}
	
	//this is the helper class to check cycle in directional graph.
	public boolean cyclecheck(int key,boolean visited[], boolean recstack[]) {
		
		if(recstack[key])
			return true;
		
		if(visited[key])
			return false;
		
		recstack[key] = visited[key] = true;
		
		LinkedList<Integer> linkedList = graph.get(key);
		
		for(int i: linkedList) {
			if(cyclecheck(i,visited, recstack)) {
				return true;
			}
		}
		recstack[key] = false;
		
		return false;
	}
	//this code is for finding cycle in a directional graph
	public boolean cycledirectional() {
		boolean visited[] = new boolean[graph.size()+1];
		boolean recstack[] = new boolean[graph.size()+1];
		
		for(Map.Entry<Integer, LinkedList<Integer>> m: graph.entrySet()) {
			if(cyclecheck(m.getKey(), visited, recstack)) {
				return true;
			}
		}
		return false;
	}
	
	//------------------------------------------------------------------------------------------
	public boolean cyclecheckby(int v, boolean visited[], int parent) {
		//
		if(visited[v] && v != parent) {
			return true;
		}
		
		visited[v] = true;
		LinkedList<Integer> linkedList = graph.get(v);
		for(int i: linkedList) {
			if(i==parent)continue;
			if(cyclecheckby(i,visited,v))
				return true;
			/*
			 * else if(i!=parent) return true;
			 */
		}
		return false;
	}
	
	public boolean cyclebydirectional() {
		boolean visited[] = new boolean[graph.size()+1];
		
		for(Map.Entry<Integer, LinkedList<Integer>> m: graph.entrySet()) {
			if(!visited[m.getKey()])
				if(cyclecheckby(m.getKey(),visited,-1))
					return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		//First initializing vertex. In case value entered == -1 loop breaks.
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter vertex");
		boolean flag = true;
		do {
			int val = sc.nextInt();
			if(val == -1) {
				flag = false;
				continue;
			}
			graph.put(val,new LinkedList<Integer>());
		}while(flag);
		
		
		flag = true;
		//establishing edges between vertexes.
		System.out.println(" bi-directional(Y/N): ");
		char byDir= sc.next().toLowerCase().charAt(0);
		System.out.println("Please Enter Edges");
		do {
			System.out.println("Enter source: ");
			int source = sc.nextInt();
			System.out.println("Enter destination: ");
			int destination = sc.nextInt();
			if(source == -1 && destination ==-1) {
				flag =false;
				continue;
			}
			// If bi-directional is true.
			if(byDir =='y') {
				if(graph.containsKey(source) && graph.containsKey(destination)) {
					graph.get(source).add(destination);
					graph.get(destination).add(source);
					
				}else {
					System.out.println("Vertex is not present. Try again");
				}
			}else {
				if(graph.containsKey(source) && graph.containsKey(destination)) {
					graph.get(source).add(destination);
					
				}else {
					System.out.println("Vertex is not present. Try again");
				}
				
			}
			
		}while(flag);
		
		//prints the generated graph.
		for(Map.Entry<Integer, LinkedList<Integer>> m : graph.entrySet()) {
			System.out.println(m.getKey()+" --> "+m.getValue());
		}
		
		//DFS and BFS execution.
		System.out.println("Initialising Depth first search....");
		System.out.println("Start search from?");
		
		do {
			flag = false;
			int search = sc.nextInt();
			if(graph.containsKey(search)) {
				DFS dp = new DFS();
				dp.DepthFirstSearch(search);
			}else {
				System.out.println("Map do not contain this vertex.");
				flag = true;
			}
		}while(flag);
		
		System.out.println();
		
		System.out.println("Initialising Width first search....");
		System.out.println("Start search from?");
		
		do {
			flag = false;
			int search = sc.nextInt();
			if(graph.containsKey(search)) {
				DFS dp = new DFS();
				dp.WidthFirstSearch(search);
			}else {
				System.out.println("Map do not contain this vertex.");
				flag = true;
			}
		}while(flag);
		
		//--------------------------------------------------------------------------------------------
		//detect cycle in a graph.
		
		if(byDir=='y') {
			DFS dp = new DFS();
			boolean cyclebydirectional = dp.cyclebydirectional();
			System.out.println();
			System.out.println("Presence of cycle in undirected graph: "+cyclebydirectional);
		}else {
			DFS dp = new DFS();
			boolean cycledirectional = dp.cycledirectional();
			System.out.println();
			System.out.println("Presence of cycle in directed graph: "+cycledirectional);
		}
	}
	

}
