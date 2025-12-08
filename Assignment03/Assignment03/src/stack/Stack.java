package stack;
public class Stack {

   public static class Node {
        private int data;
        private Node next;

        public Node(int value) {
            data = value;
            next = null;
        }
    }

    private Node top;

    public Stack() {
        top = null;
    }
   
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        int temp = -1;
        if (isEmpty())
            System.out.println("Stack is empty");
        else {
            temp = top.data;
            top = top.next;
        }
        return temp;
    }

    public int peek() {
        int temp = -1;
        if (isEmpty())
            System.out.println("Stack is empty");
        else
            temp = top.data;
        return temp;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        Node temp = top;
        System.out.print("Stack : ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return top == null;
    }
}
