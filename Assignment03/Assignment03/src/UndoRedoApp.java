import java.util.Scanner;
import java.util.Stack;

class Employee {
    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "[ID: " + id + ", Name: " + name + "]";
    }
}

class Node {
    Employee data;
    Node next;

    Node(Employee data) {
        this.data = data;
        this.next = null;
    }
}

class Action {
    String type; // "ADD" or "DELETE"
    Employee emp;

    public Action(String type, Employee emp) {
        this.type = type;
        this.emp = emp;
    }
}

class LinkedListManager {
    private Node head;

    private Stack<Action> undoStack = new Stack<>();
    private Stack<Action> redoStack = new Stack<>();

    private void internalAdd(Employee emp) {
        Node newNode = new Node(emp);
        newNode.next = head;
        head = newNode;
    }

    private void internalDelete(int id) {
        if (head == null) return;
        if (head.data.id == id) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data.id != id) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void addEmployee(int id, String name) {
        Employee newEmp = new Employee(id, name);
        internalAdd(newEmp);
        undoStack.push(new Action("DELETE", newEmp));
        redoStack.clear();

        System.out.println(">> Added " + newEmp.name);
    }

    public void deleteEmployee(int id) {
        Employee deletedEmp = findEmployee(id);
        if (deletedEmp == null) {
            System.out.println(">> Employee not found!");
            return;
        }

        internalDelete(id);

        undoStack.push(new Action("ADD", deletedEmp));

        redoStack.clear();

        System.out.println(">> Deleted " + deletedEmp.name);
    }


    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println(">> Nothing to Undo.");
            return;
        }
        Action act = undoStack.pop();

        if (act.type.equals("ADD")) {
            internalAdd(act.emp);
            redoStack.push(new Action("DELETE", act.emp));
            System.out.println(">> Undo Successful: Added " + act.emp.name + " back.");
        } 
        else if (act.type.equals("DELETE")) {
            internalDelete(act.emp.id);
            redoStack.push(new Action("ADD", act.emp));
            System.out.println(">> Undo Successful: Removed " + act.emp.name);
        }
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println(">> Nothing to Redo.");
            return;
        }

        Action act = redoStack.pop();

        if (act.type.equals("ADD")) {
            internalAdd(act.emp);
            undoStack.push(new Action("DELETE", act.emp));
            System.out.println(">> Redo Successful: Re-added " + act.emp.name);
        } 
        else if (act.type.equals("DELETE")) {
            internalDelete(act.emp.id);
            undoStack.push(new Action("ADD", act.emp));
            System.out.println(">> Redo Successful: Re-deleted " + act.emp.name);
        }
    }

    private Employee findEmployee(int id) {
        Node current = head;
        while (current != null) {
            if (current.data.id == id) return current.data;
            current = current.next;
        }
        return null;
    }

    public void display() {
        if (head == null) {
            System.out.println(">> List is Empty");
            return;
        }
        Node current = head;
        System.out.print("Current List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class UndoRedoApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListManager list = new LinkedListManager();
        int choice;

        do {
            System.out.println("\n=== UNDO/REDO System===");
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Display List");
            System.out.println("4. UNDO ");
            System.out.println("5. REDO");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    list.addEmployee(id, name);
                    break;
                case 2:
                    System.out.print("Enter ID to Delete: ");
                    int delId = sc.nextInt();
                    list.deleteEmployee(delId);
                    break;
                case 3:
                    list.display();
                    break;
                case 4:
                    list.undo();
                    break;
                case 5:
                    list.redo();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        } while (choice != 0);
        sc.close();
    }
}