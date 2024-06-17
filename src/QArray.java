import java.util.Scanner;

public class QArray {
    int size = 10;
    int arr[] = new int[size];
    int front = -1;
    int rare = -1;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QArray que = new QArray();
        int action = 0;
        do {
            System.out.println("press 1 to enque");
            System.out.println("press 2 to deque");
            System.out.println("press 3 to display complete que");
            System.out.println("press 9 to exit");
            System.out.println("Front: " + que.front + ", Rare: " + que.rare);
            if (sc.hasNextInt()) {
                action = sc.nextInt();
            }

            switch (action) {
                case 1: {
                    System.out.println("Enter the data you want to add");
                    action = sc.nextInt();
                    que.enque(action);
                    break;
                }
                case 2: {
                    que.deque();
                    break;
                }

                case 3: {
                    que.display();
                    break;
                }
                case 9: {
                    sc.close();
                    System.exit(1);
                    break;
                }
                default: {
                    System.out.println("Please choose number from given choice");
                    System.out.println("Let's try again");
                }
            }

        } while (1 > 0);

    }


    private void display() {
        System.out.println("__________________________________________");
        for (int i = front; i <= rare; i++) {
            System.out.print("|" + arr[i] + "|");
        }
        System.out.println();
        System.out.println("__________________________________________");

    }


    private void deque() {
        if ((front < 0) && (rare < 0)) {
            System.out.println("que is already Empty");
        } else if (((front == rare) && (rare == size - 1)) || ((front == rare) && (rare >= 0))) {
            System.out.println("Done..");
            front = rare = -1;

        } else {
            front = ++front;
        }

    }


    private void enque(int data) {
        if ((front < 0) && (rare < 0)) {
            front = rare = 0;
            arr[front] = data;
        } else if ((front == rare) && (rare == size - 1)) {
            System.out.println("Can not add more data que is full...");
        } else {
            rare = rare + 1;
            arr[rare] = data;
        }

    }

}
