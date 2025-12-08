package queue;

public class LinearQueue {
	    static class Node {
	        private int data;
	        private Node next;

	        public Node(int value) {
	            data = value;
	            next = null;
	        }
	    }

	    private Node front, rear;

	    public LinearQueue() {
	        front = rear = null;
	    }

	    public void enqueue(int data) {
	            Node newNode = new Node(data);

	            if (isEmpty()) {
	                front = rear = newNode;
	            } else {
	                rear.next = newNode;
	                rear = newNode;
	            }
	        }
	    

	    public int dequeue() {
	        int temp = -1;
	        if (isEmpty())
	            System.out.println("Queue is empty");
	        else {
	            temp = front.data;
	            front = front.next;

	            if (front == null)
	                rear = null;
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
	        return front == null;
	    }

	}

