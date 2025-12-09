package assignment07;
import java.util.Scanner;

class BSTDemo {

    // --------- Node definition ----------
    static class Node {
        double data;
        Node left, right;

        Node(double data) {
            this.data = data;
            left = right = null;
        }
    }

    // --------- BST implementation ----------
    static class BST {
        private Node root;

        public BST() {
            root = null;
        }

        // Insert a key into BST
        public void insert(double value) {
            root = insertRec(root, value);
        }

        private Node insertRec(Node root, double value) {
            if (root == null) {
                return new Node(value);
            }
            if (value < root.data)
                root.left = insertRec(root.left, value);
            else
                root.right = insertRec(root.right, value);
            return root;
        }

        // 1. Print all leaf nodes
        public void printLeafNodes() {
            System.out.print("Leaf nodes: ");
            printLeafNodesRec(root);
            System.out.println();
        }

        private void printLeafNodesRec(Node root) {
            if (root == null) return;

            if (root.left == null && root.right == null) {
                System.out.print(root.data + " ");
            }
            printLeafNodesRec(root.left);
            printLeafNodesRec(root.right);
        }

        // 2. Print all non-leaf nodes
        public void printNonLeafNodes() {
            System.out.print("Non-leaf nodes: ");
            printNonLeafNodesRec(root);
            System.out.println();
        }

        private void printNonLeafNodesRec(Node root) {
            if (root == null) return;

            if (root.left != null || root.right != null) {
                System.out.print(root.data + " ");
            }
            printNonLeafNodesRec(root.left);
            printNonLeafNodesRec(root.right);
        }

        // 3. Count of all full nodes (having both children)
        public int countFullNodes() {
            return countFullNodesRec(root);
        }

        private int countFullNodesRec(Node root) {
            if (root == null) return 0;

            int count = 0;
            if (root.left != null && root.right != null)
                count = 1;

            return count + countFullNodesRec(root.left)
                         + countFullNodesRec(root.right);
        }

        // 4. Print parent of user-entered node
        public void printParent(double key) {
            if (root == null) {
                System.out.println("Tree is empty.");
                return;
            }
            if (root.data == key) {
                System.out.println("The node " + key + " is root, it has no parent.");
                return;
            }

            Node parent = findParent(root, null, key);
            if (parent == null)
                System.out.println("Key " + key + " not found in BST.");
            else
                System.out.println("Parent of " + key + " is: " + parent.data);
        }

        private Node findParent(Node current, Node parent, double key) {
            if (current == null) return null;

            if (current.data == key) return parent;

            if (key < current.data)
                return findParent(current.left, current, key);
            else
                return findParent(current.right, current, key);
        }

        // 5. Print children of user-entered node
        public void printChildren(double key) {
            Node node = search(root, key);
            if (node == null) {
                System.out.println("Key " + key + " not found in BST.");
                return;
            }

            if (node.left == null && node.right == null) {
                System.out.println("Node " + key + " has no children (it is a leaf).");
                return;
            }

            System.out.print("Children of " + key + ": ");
            if (node.left != null)
                System.out.print(node.left.data + " ");
            if (node.right != null)
                System.out.print(node.right.data + " ");
            System.out.println();
        }

        private Node search(Node root, double key) {
            if (root == null) return null;
            if (root.data == key) return root;
            if (key < root.data) return search(root.left, key);
            else return search(root.right, key);
        }

        // 6. Print all pairs of siblings
        public void printAllSiblingPairs() {
            System.out.println("Sibling pairs (left, right):");
            printAllSiblingPairsRec(root);
        }

        private void printAllSiblingPairsRec(Node root) {
            if (root == null) return;

            if (root.left != null && root.right != null) {
                System.out.println("(" + root.left.data + ", " + root.right.data + ")");
            }
            printAllSiblingPairsRec(root.left);
            printAllSiblingPairsRec(root.right);
        }
    }


    
}

