import java.util.Scanner;
public class StackImp {
	
	class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
		
	}

	Node head=null;
	
	public void push(int insert) {
		Node node = new Node(insert); 
		
		if(head == null) {
			head = node;
		}else {
			node.next = head;
			head = node;
		}
		
	}
	
	public void display() {
		if(head == null) {
			System.out.println("No Elemrnt Found!    Stack is empty....");
		}else {
			Node itt = head;
			while(itt != null) {
				System.out.println("|"+itt.data+"|");
				System.out.println(" __");
				itt = itt.next;
			}
		}
	}
	
	public void peek() {
		if(head==null) {
			System.out.println("Stack is empity, There is no top to display...");
		}else {
			System.out.println("Top: "+head.data);
		}
		
	}
	
	public void pop() {
		if(head == null) {
			System.out.println("Stack is already empty");
		}else {
			if(head.next == null) {
				head = null;
			}else {
				head = head.next;
			}
		}
		
	}
	public static void main(String[] args) {
		
		StackImp Stack = new StackImp();
		do {
			System.out.println("Press 1 to push element");
			System.out.println("Press 2 to display stack");
			System.out.println("Press 3 to peek stack");
			System.out.println("Press 4 to pop stack");
			System.out.println("Press 9 to exit");
			
			Scanner sc = new Scanner(System.in);
			int action = 0,insert=0;

				action = sc.nextInt();

			
			switch (action) {
			case 1: {
				System.out.println("Enter the number you want to add in Stack...");
				insert = sc.nextInt();
				Stack.push(insert);
				break;
			}
			case 2:{
				Stack.display();
				break;
			}
			case 3:{
				Stack.peek();
				break;
			}
			case 4:{
				Stack.pop();
				break;
			}
			case 9:{
				sc.close();
				System.exit(0);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + action);
			}
		}while(1>0);
		
	}

	

}
