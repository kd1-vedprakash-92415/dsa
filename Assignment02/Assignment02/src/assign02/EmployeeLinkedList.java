class EmployeeLinkedList {

    static class Node {
        Employee data;
        Node next;
        
        Node(Employee data) {
            this.data = data;
            this.next = null;
        }
    }
    
    Node head;

    // --- A. ADD EMPLOYEE ---
    public void add(Employee emp) {
        Node newNode = new Node(emp);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println(">> Employee added successfully.");
    }

    // --- B. DISPLAY ALL ---
    public void display() {
        if (head == null) {
            System.out.println(">> List is empty.");
            return;
        }
        Node current = head;
        System.out.println("\n--- Employee List ---");
        while (current != null) {
            System.out.println(current.data); 
            current = current.next;
        }
        System.out.println("---------------------");
    }

    // --- C. SEARCH BY NAME ---
    public void searchByName(String name) {
        Node current = head;
        boolean found = false;
        while (current != null) {
            if (current.data.name.equalsIgnoreCase(name)) {
                System.out.println(">> FOUND: " + current.data);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println(">> Employee with name '" + name + "' not found.");
        }
    }

    // --- D. DELETE BY ID ---
    public void deleteById(int id) {
        if (head == null) {
            System.out.println(">> List is empty.");
            return;
        }
        if (head.data.id == id) {
            head = head.next;
            System.out.println(">> Employee " + id + " deleted.");
            return;
        }
        Node current = head;
        Node prev = null;
        
        while (current != null && current.data.id != id) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println(">> Employee ID " + id + " not found.");
        } else {
            prev.next = current.next; 
            System.out.println(">> Employee " + id + " deleted.");
        }
    }

    // --- E. UPDATE SALARY ---
    public void updateSalary(int id, double newSalary) {
        Node current = head;
        while (current != null) {
            if (current.data.id == id) {
                current.data.salary = newSalary;
                System.out.println(">> Salary updated for ID " + id);
                return;
            }
            current = current.next;
        }
        System.out.println(">> Employee ID " + id + " not found.");
    }

    // --- F. SORT BY SALARY (Bubble Sort) ---
    public void sortBySalary() {
        if (head == null || head.next == null) return;

        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.data.salary > current.next.data.salary) {
                    Employee temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println(">> Employees sorted by Salary.");
    }
}