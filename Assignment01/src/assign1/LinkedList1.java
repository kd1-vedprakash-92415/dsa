package assign1;

public class LinkedList1 {
	static class Node{
		private int data;
		private Node next;
		public Node(int value) {
			data = value;
			next = null;
		}
	}
	private Node head;
	
	public LinkedList1() {
		head = null;		
	}
	public boolean isEmpty() {
		return head == null;
	}
	
	public void addFirst(int value) {
		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;
	}
	
	public void addLast(int value) {
		Node newNode = new Node(value);
		if(head == null)
			head = newNode;
		else {
			Node trav = head;
			while(trav.next != null)
				trav = trav.next;
			trav.next = newNode;
		}
	}
	
	public void display() {
		Node trav = head;
		System.out.println("List: ");
		while(trav != null) {
			System.out.print(" "+trav.data);
			trav = trav.next;
		}
		System.out.println("");
	}

}
