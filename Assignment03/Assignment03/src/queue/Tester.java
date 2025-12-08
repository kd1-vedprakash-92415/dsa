package queue;

import java.util.Scanner;

public class Tester {
public static void main(String[] args) {
		
//		LinearQueue q = new LinearQueue();
//		
//		Scanner sc = new Scanner(System.in);
//		int choice;
//		
//		do {
//			System.out.println("0. Exit\n1. Enqueue\n2. Dequeue\n3. Peek");
//			System.out.print("Enter your choice : ");
//			choice = sc.nextInt();
//			
//			switch(choice) {
//			case 1:
//				System.out.print("Enter data to be pushed : ");
//				int data = sc.nextInt();
//				q.enqueue(data);
//				break;
//			case 2:
//				System.out.println("Popped data : " + q.dequeue());
//				break;
//			case 3:
//				System.out.println("Peeked data : " + q.peek());
//				break;
//			}
//		}while(choice != 0);
//		
//		
//		
//		sc.close();
	
	
	
	CircularQueue q = new CircularQueue();
	
	Scanner sc = new Scanner(System.in);
	int choice;
	
	do {
		System.out.println("0. Exit\n1. Enqueue\n2. Dequeue\n3. Peek");
		System.out.print("Enter your choice : ");
		choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			System.out.print("Enter data to be pushed : ");
			int data = sc.nextInt();
			q.enqueue(data);
			break;
		case 2:
			System.out.println("Popped data : " + q.dequeue());
			break;
		case 3:
			System.out.println("Peeked data : " + q.peek());
			break;
		}
	}while(choice != 0);
	
	
	
	sc.close();
	}
}
