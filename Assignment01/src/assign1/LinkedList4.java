package assign1;

public class LinkedList4 {
	static class Node{
		private int data;
		private Node next;
		public Node(int value) {
			data = value ;
			next = null;			
		}
	}
	private Node head;
	private Node tail;
	public LinkedList4() {
		head = null;
		tail = null;	
	}
	public boolean isEmpty() {
		return head == null;
	}		
		public void addLast(int value) {
			Node newNode =new Node(value);
			
			if(head == null) {
				head = tail = newNode;
			}
			else {
				tail.next = newNode;
				tail = newNode;
			}
			
		}
		public void addFirst(int value) {
			Node newNode = new Node(value);
			if(head == null)
				head = tail = newNode;
			else {
				newNode.next = head;
				head =newNode;
			}
		}
		public void deleteFirst() {
			if(head == null) {
				System.out.println("List is Empty");
			return;
			
		}
		head = head.next;
		if(head == null)
			tail = null;
		}
		public void display() {
			Node trav = head;
			System.out.print("List: ");
			while(trav != null) {
				System.out.println(" "+ trav.data);
			trav = trav.next;
		}
			System.out.println("");
		}
	}

