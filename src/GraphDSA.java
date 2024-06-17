import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class GraphDSA {


    //Declaration of array which contains LinkedList
    private LinkedList<Integer> arr[];

    //Constructor which generate first Vertices LinkedList for every vertices.
    public GraphDSA(int v) {
        this.arr = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            arr[i] = new LinkedList<Integer>();
        }
    }


    public void CreateConnection(int s, int d) {
        arr[s].add(d);
        arr[d].add(s);

    }

    public void bfs(int source) {
        boolean visited[] = new boolean[this.arr.length];

        Queue<Integer> que = new LinkedList<>();
        que.add(source);
        visited[source] = true;

        while (!que.isEmpty()) {
            int p = que.poll();
            System.out.print(p + ", ");
            for (int i : arr[p]) {
                if (visited[i] != true) {
                    visited[i] = true;
                    que.add(i);

                }
            }
        }
    }

    public void dfs(int source) {
        boolean visited[] = new boolean[this.arr.length];

        Stack<Integer> stack = new Stack<>();
        stack.add(source);
        visited[source] = true;

        while (!stack.isEmpty()) {
            int p = stack.pop();
            System.out.print(p + ", ");
            for (int i : arr[p]) {
                if (visited[i] != true) {
                    visited[i] = true;
                    stack.add(i);

                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Vertices & Edges: ");
        System.out.println();
        int v = sc.nextInt();
        int e = sc.nextInt();
        GraphDSA graph = new GraphDSA(v);
        System.out.println("Enter Connection: ");
        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            graph.CreateConnection(s, d);
        }
        System.out.println("Enter source for breadth first search");
        int source = sc.nextInt();
        graph.bfs(source);
        System.out.println();
        graph.dfs(source);

    }


}
