import java.util.Scanner;
public class BinaryTree {
	
	public static Node Create() {
		int value;
		Scanner sc = new Scanner(System.in);
		Node node;
		System.out.println("Please enter node value");
		value = sc.nextInt();
		if(value == -1) {
			return null;
		}
			
			node = new Node(value);
			System.out.println("Enter Left child of "+ node.data);
			node.left = Create();
			System.out.println("Enter Right child of "+ node.data);
			node.right = Create();
			
			return node;
		
	}
	
	static void inOrder(Node root) {
		
		if(root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data+", ");
		inOrder(root.right);
	}
	
	static void preOrder(Node root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data+", ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	static void postOrder(Node root) {
		if(root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+", ");
	}

	public static void main(String[] args) {
		Node create = Create();
		preOrder(create);
		System.out.println();
		inOrder(create);
		System.out.println();
		postOrder(create);
		
	}

	public static class Node{
		Node left;
		int data;
		Node right;
		
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
					}
	}
}
