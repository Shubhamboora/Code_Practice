import java.util.Scanner;

public class CircularQ {

	public int f = 0;
	 public int r = 0,n=5;
	 int arr[] = new int[n];
	 
	 public CircularQ() {
		 this.f = -1;
		 this.r = -1;
	 }
	 
	 public void enque(int data) {
		 if(f== -1 && r==-1) {
			 f= r= 0;
			 arr[f] = data;
		 }else if(f == 0 && r==n-1) {
			 System.out.println("Queue is full");
		 }else if(f>=0 && r==f-1){
			 System.out.println("Queue is full");
		 }
		 else {
		 
			 if(r == n-1) {
				 r = 0;
			 }else {
				 r=r+1;
			 }
			 arr[r]=data;
		 }
			 
			 
		 }
	 
	
	 public void deque() {
		 if(f == -1 && r == -1) {
			 System.out.println("Queue is already empty");
		 }else if(f == r) {
			 f= r = -1;
		 }else {
			 if(f==n-1) {
				 f=0;
			 }else {
				 f=f+1;
			 }
			 
		 }
	 }

	 public void display() {
		 
		 if(f==-1) {
			 System.out.println("Queue is empty...");
		 }
		 
			 int i =f;
			 System.out.println("__________________________________________");
				while(i!=r) {
					
					System.out.print("|"+arr[i]+"|");
					
					if(i==n-1) {
						i=-1;
					}
					++i;
				}
				System.out.print("|"+arr[i]+"|");
				System.out.println();
				System.out.println("__________________________________________");
		 
	 }
	 public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		CircularQ que = new CircularQ();
		int action = 0;
		do {
			System.out.println("press 1 to enque");
			System.out.println("press 2 to deque");
			System.out.println("press 3 to display complete que");
			System.out.println("press 9 to exit");
			System.out.println("Front: "+que.f+", Rare: "+que.r);
			if(sc.hasNextInt()) {
				action = sc.nextInt();
			}
			
			switch(action) {
			case 1:{
				System.out.println("Enter the data you want to add");
				action = sc.nextInt();
				que.enque(action);
				break;
			}
			case 2:{
				que.deque();
				break;
			}
			
			case 3:{
				que.display();
				break;
			}
			case 9:{
				sc.close();
				System.exit(1);
				break;
			}
			default:{
				System.out.println("Please choose number from given choice");
				System.out.println("Let's try again");
			}
			}
			
		}while(1>0);

	}

}
