package assign1;

public class Tester {
	public static void main(String [] args) {
//		LinkedList1 list = new LinkedList1();
//		 list.addFirst(10);
//		 list.addFirst(20);
//		 list.addFirst(30);
//		 list.addLast(40);
//		 list.addLast(50);
//		 list.addLast(60);
		
//		LinkedList2 list = new LinkedList2();
//		list.add(20);
//		list.add(10);
//		list.add(60);
//		list.add(30);
//		list.add(40);
//		list.add(50);
		
		LinkedList4 list = new LinkedList4();
		list.addLast(10);
		list.addLast(20);
		list.addFirst(5);
		list.addFirst(30);
		
		
		 list.display();
		 list.deleteFirst();
		 list.display();
		 
		
	}
}
