package assign02;

public class SinglyCircularList {
    static class Node {
        int data;
        Node next;

        Node(int value) {
            data = value;
            next = null;
        }
    }
    private Node tail;
    private int size;

    public SinglyCircularList() {
        tail = null;
    }

    public boolean isEmpty() {
        return tail == null;
    }

    public void display() {
        if (tail == null) {
            return;
        }

        Node trav = tail.next; 
        System.out.print("List: ");
        do {
            System.out.print(trav.data + " ");
            trav = trav.next;
        } while (trav != tail.next);
        System.out.println();
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);

        if (tail == null) {
            tail = newNode;
            newNode.next = newNode;
        } else {
            newNode.next = tail.next; 
            tail.next = newNode;     
        }
        size++;
    }

    public void addLast(int value) {
        Node newNode = new Node(value);

        if (tail == null) {
            tail = newNode;
            newNode.next = newNode;
        } else {
            newNode.next = tail.next; 
            tail.next = newNode;      
            tail = newNode;           
        }
        size++;
    }
    
    public void addPosition(int value, int pos) {
        if (pos < 1 || pos > size + 1) {
            return;
        }

        if (pos == 1) {
            addFirst(value);
        } else if (pos == size + 1) {
            addLast(value);
        } else {
            Node newNode = new Node(value);
            Node trav = tail.next;

            for (int i = 1; i < pos - 1; i++) {
                trav = trav.next;
            }

            newNode.next = trav.next;
            trav.next = newNode;
            size++;
        }
    }
    public void deleteFirst() {
        if (tail == null) { 
            return;
        }

        if (tail.next == tail) { 
            tail = null;
        } else {
            Node head = tail.next;
            tail.next = head.next; 
        }
        size--;        
    }
    
    public void deleteLast() {
        if (tail == null) {
            return;
        }

        if (tail.next == tail) { 
            tail = null;
        } else {
            Node trav = tail.next; 

            while (trav.next != tail) {
                trav = trav.next;
            }

            trav.next = tail.next; 
            tail = trav;           
        }
        size--;
    }
    public void deletePosition(int pos) {
        if (pos < 1 || pos > size) {
            return;
        }

        if (pos == 1) {
            deleteFirst();
            return;
        }

        if (pos == size) {
            deleteLast();
            return;
        }

        Node trav = tail.next; 

        for (int i = 1; i < pos - 1; i++) {
            trav = trav.next;
        }

        Node target = trav.next;      
        trav.next = target.next;     
        size--;
    }
    
    
}

