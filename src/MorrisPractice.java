
class Node{
	int data;
	Node left;
	Node right;
	
	public Node(int data) {
		this.data = data;
		left = right=null;
	}
}
public class MorrisPractice {

	Node root;
	
	
	public void MorrisTraverse(Node root) {
		
		if(root == null) {
			return;
		}
		
		Node current, prev;
		current = root;
		while(current != null) {
			
			if(current.left == null) {
				System.out.print(current.data+" ");
				current = current.right;
			}
			else {
				prev = current.left;
				
				while(prev.right != null && prev.right!=current) {
					prev = prev.right;
				}
				
				if(prev.right == null) {
					prev.right = current;
					current = current.left;
				}else {
					prev.right = null;
					System.out.print(current.data + " ");
					current = current.right;
				}
			}
		}
	}
	
	public static void main(String args[]) {
		
		MorrisPractice tree = new MorrisPractice();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
  
        tree.MorrisTraverse(tree.root);
	}
}
