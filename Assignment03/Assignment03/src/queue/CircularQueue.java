package queue;

public class CircularQueue {
	    static class Node {
	        private int data;
	        private Node next;

	        public Node(int value) {
	            data = value;
	            next = null;
	        }
	    }

	    private Node front, rear;

	    public CircularQueue() {
	        front = rear = null;
	    }

	    public void enqueue(int data) {

	            Node newNode = new Node(data);

	            if (isEmpty()) {
	                front = rear = newNode;
	                rear.next = front; 
	            }
	            else {
	                rear.next = newNode;
	                rear = newNode;
	                rear.next = front; 
	            }
	        }
	    

	    public int dequeue() {
	        int temp = -1;
	        if (isEmpty())
	            System.out.println("Queue is empty");
	        else {
	            temp = front.data;

	            if (front == rear) {
	                front = rear = null;
	            }
	            else {
	                front = front.next;
	                rear.next = front;
	            }
	        }
	        return temp;
	    }

	    public int peek() {
	        int temp = -1;
	        if (isEmpty())
	            System.out.println("Queue is empty");
	        else {
	            temp = front.data;
	        }
	        return temp;
	    }

	    public boolean isEmpty() {
	        return front == null && rear == null;
	    }
	}


