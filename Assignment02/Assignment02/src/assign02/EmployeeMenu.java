import java.util.Scanner;

public class EmployeeMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeLinkedList list = new EmployeeLinkedList();
        int choice;

        do {
            System.out.println("\n=== EMPLOYEE MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All");
            System.out.println("3. Search by Name");
            System.out.println("4. Delete by ID");
            System.out.println("5. Update Salary");
            System.out.println("6. Sort by Salary");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double sal = sc.nextDouble();
                    list.add(new Employee(id, name, sal));
                    break;
                case 2:
                    list.display();
                    break;
                case 3:
                    System.out.print("Enter Name to Search: ");
                    sc.nextLine(); 
                    String searchName = sc.nextLine();
                    list.searchByName(searchName);
                    break;
                case 4:
                    System.out.print("Enter ID to Delete: ");
                    int delId = sc.nextInt();
                    list.deleteById(delId);
                    break;
                case 5:
                    System.out.print("Enter ID to Update: ");
                    int upId = sc.nextInt();
                    System.out.print("Enter New Salary: ");
                    double newSal = sc.nextDouble();
                    list.updateSalary(upId, newSal);
                    break;
                case 6:
                    list.sortBySalary();
                    list.display(); 
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 0);
        
        sc.close();
    }
}