package assignment07;

import java.util.Scanner;

import assignment07.BSTDemo.BST;

public class Tester {
	public static void main(String[] args) {
        BST bst = new BST();

        // create BST with initial keys
        double[] keys = {3.2, 1.5, 6.3, 9.8, 2.1, 5.7, 4.5, 7.4, 1.0};
        for (double k : keys) {
            bst.insert(k);
        }

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("--------- BST MENU ---------");
            System.out.println("1. Print all leaf nodes");
            System.out.println("2. Print all non-leaf nodes");
            System.out.println("3. Print count of all full nodes");
            System.out.println("4. Print parent of a node");
            System.out.println("5. Print children of a node");
            System.out.println("6. Print all pairs of siblings");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    bst.printLeafNodes();
                    break;
                case 2:
                    bst.printNonLeafNodes();
                    break;
                case 3:
                    System.out.println("Count of full nodes: " + bst.countFullNodes());
                    break;
                case 4:
                    System.out.print("Enter key: ");
                    double keyForParent = sc.nextDouble();
                    bst.printParent(keyForParent);
                    break;
                case 5:
                    System.out.print("Enter key: ");
                    double keyForChildren = sc.nextDouble();
                    bst.printChildren(keyForChildren);
                    break;
                case 6:
                    bst.printAllSiblingPairs();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            System.out.println();
        } while (choice != 0);
	
        sc.close();
    }
}
