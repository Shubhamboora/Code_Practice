package Task;

public class Multi {

	public static void main(String[] args) {
		Thread even = new Thread(new Even());
		Thread odd = new Thread(new odd());
		
		even.start();
		odd.start();

	}

}
class Even implements Runnable{

	@Override
	public void run() {
		for(int j = 0;j<=10;j++) {
			if(j%2==0) {
				System.out.println("Even : "+j);
			}
		}
		
	}
	
}

class odd implements Runnable{

	@Override
	public void run() {
		for(int i = 0;i<=10;i++) {
			if(i%2!=0) {
				System.out.println("Odd : "+i);
			}
		}
		
	}
	
}