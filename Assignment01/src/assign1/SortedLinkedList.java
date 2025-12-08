
public class SortedLinkedList {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    Node head;

    public void sortedInsert(int newData) {
        Node newNode = new Node(newData);

        if (head == null || head.data >= newData) {
            newNode.next = head;
            head = newNode;
            System.out.println("Inserted " + newData + " at the Head.");
            return;
        }

        Node current = head;

        while (current.next != null && current.next.data < newData) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
        System.out.println("Inserted " + newData + " after " + current.data);
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SortedLinkedList list = new SortedLinkedList();

        System.out.println("--- Building Sorted List ---");

        // 1. Insert into empty list
        list.sortedInsert(20); 
        list.display();

        // 2. Insert at the end (Biggest number)
        list.sortedInsert(40); 
        list.display();

        // 3. Insert in the middle (Between 20 and 40)
        list.sortedInsert(30); 
        list.display();

        // 4. Insert at the Head (Smallest number)
        list.sortedInsert(10); 
        list.display();
    }
}