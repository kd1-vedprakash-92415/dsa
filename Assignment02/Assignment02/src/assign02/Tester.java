package assign02;

public class Tester {

	public static void main(String[] args) {
		SinglyCircularList list = new SinglyCircularList();
		list.addFirst(10);
		list.addFirst(20);
		
		list.addLast(40);
		list.addLast(50);
		
		list.addPosition(30,2);
		list.deleteFirst();
		list.deleteLast();
		list.deletePosition(2);
		
		list.display();
	}

}
