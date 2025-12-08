package assign1;

import assign1.LinkedList1.Node;

public class LinkedList2 {
	static class Node{
		private int data;
		private Node next;
		public Node(int value){
			data = value;
			next = null;
		}
	}
	public Node head;
	
	public LinkedList2() {
		head  = null;
	}
	public boolean isEmpty(){
		return head == null;
	}
	
		public void add(int value) {
			Node newNode = new Node(value);
			if(head == null || value < head.data) {
				newNode.next = head;
				head = newNode;
				return;
			}
		Node current = head ;
		while (current.next != null && current.next.data < value) {
			current = current.next;
		}
		newNode.next = current.next;
		current.next = newNode;

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
