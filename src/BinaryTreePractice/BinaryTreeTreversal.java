package BinaryTreePractice;

import java.util.Scanner;
import java.util.Stack;

public class BinaryTreeTreversal {
	//to create tree.
	public Node create() {
		Scanner sc = new Scanner(System.in);
		int val = sc.nextInt();
		if(val ==-1) {
			return null;
		}
		Node node  = new Node(val);
		System.out.println("Please enter left child value of "+node.data);
		node.left = create();
		System.out.println("Please enter right child value of "+node.data);
		node.right = create();
		
		return node;
	}
	
	//Inorder traversal of tree using recursion.
	public void inOrderRec(Node root) {
		if(root == null) {
			return ;
		}
		
		inOrderRec(root.left);
		System.out.print(root.data+", ");
		inOrderRec(root.right);
	}
	//Postorder traversal of tree using recursion.
	public void postOrderRec(Node root) {

		if(root == null) {
			return ;
		}
		
		postOrderRec(root.left);
		postOrderRec(root.right);
		System.out.print(root.data+", ");
	}
	//Preorder traversal of tree using recursion.
	public void preOrderRec(Node root) {
		if(root == null) {
			return ;
		}
		System.out.print(root.data+", ");
		preOrderRec(root.left);
		preOrderRec(root.right);
	}
	//Inorder traversal via ittration
	public void inOrderStack(Node root) {
		if(root == null)return;
		Stack<Node> st = new Stack<>();
		Node curr = root;
		//until current node or stack, both are not empty this loop will remain active.
		while(curr!=null || st.isEmpty()!=true) {
			
			//it add all left branch to stack
			while(curr!=null) {
				st.push(curr);
				curr = curr.left;
			}
			//once we reach to left leaf of a branch we pop one node value from stack.
			//and then popped data is printed and its right node is assigned to current. 
			curr = st.pop();
			System.out.print(curr.data+", ");
			
			curr = curr.right;
		}
	}
	//Preorder traversal via ittration
	public void preOrderStack(Node root) {
		if(root == null)return;
		Stack<Node> st = new Stack<>();
		Node curr = root;
		//until current node or stack, both are not empty this loop will remain active.
		while(curr!=null || st.isEmpty()!=true) {
			
			//it add all left branch to stack
			while(curr!=null) {
				st.push(curr);
				//we print data of latest value added to stack.
				System.out.print(curr.data+", ");
				curr = curr.left;
			}
			//once we reach to left leaf of a branch we pop one node value from stack,
			// and its right node is assigned to current. 
			curr = st.pop();
			curr = curr.right;
		}
	}
	//Postorder traversal via ittration.
	public void postOrderStack(Node root) {
		if(root == null)return;
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		
		s1.push(root);
		Node curr = null;
		//Repeat this loop until s1 is not empty.
		while(!s1.isEmpty()) {
			//Push the popped element to s2.
			curr = s1.pop();
			s2.push(curr);
			
			//Push left and right child of popped element into s1.
			if(curr.left!=null)
				s1.push(curr.left);
			if(curr.right!=null)
				s1.push(curr.right);
		}
		
		while(!s2.isEmpty()) {
			Node popped = s2.pop();
			System.out.print(popped.data+", ");
		}
		
		
	}
	public static void main(String arge[]) {
		BinaryTreeTreversal btt = new BinaryTreeTreversal();
		System.out.println("Please enter root node value");
		Node root = btt.create();
		System.out.println();
		System.out.println("InOrder via recursion: ");
		btt.inOrderRec(root);
		System.out.println();
		System.out.println("InOrder via ittration: ");
		btt.inOrderStack(root);
		System.out.println();
		System.out.println("preOrder via recursion: ");
		btt.preOrderRec(root);
		System.out.println();
		System.out.println("PreOrder via ittration: ");
		btt.preOrderStack(root);
		System.out.println();
		System.out.println("postOrder via recursion: ");
		btt.postOrderRec(root);
		System.out.println();
		System.out.println("postOrder via ittration: ");
		btt.postOrderStack(root);
		
		
	}
}

//LinkedList for tree nodes.
class Node{
	int data;
	Node left;
	Node right;
	
	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}