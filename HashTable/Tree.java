/*
 * Dalton Carter
 * This class implements a tree that will have an instance in every index of an array to
 * allow separate chaining in a hash table.
 */
import java.util.Stack;
public class Tree {

    private Node root;

    // Constructor.
    public Tree()
    { root = null; }

    // Returns the root of the tree.
    public Node getRoot()
    { return root; }

    // Returns a node with the same key as the parameter or null if not found.
    public Node find(int key) {
        Node current = root;
        // Extra null check if the start index is null.
        if (current == null) {
            System.out.println("Null.");
            return null;
        }
        // While loop to find node, printing every iteration.
        while (current.iData != key) {
            // Display the nodes as they are found.
            System.out.print(current.iData + " -> ");
            if (key < current.iData)
                current = current.leftChild;
            else
                current = current.rightChild;
            // If the node was not found, return null.
            if (current == null) {
                System.out.print("Null.");
                return null;
            }
        }
        // Print out node at final location.
        System.out.print(current.iData);
        return current;
    } // End Find().

    // Inserts a node into the tree.
    public void insert(Node newNode) {
        if (root == null)
            root = newNode;
        else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                // Go left?
                if (newNode.iData < current.iData) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } // End go left.
                else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                } // End go right.
            } // End while loop.
        } // End else not root.
    } // End insert().

    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("*********************************************");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < nBlanks; j++)
                System.out.print(' ');

            while (globalStack.isEmpty() == false) {
                Node temp = (Node)globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if (temp.leftChild != null || temp.rightChild != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            } // End while globalStack not empty.
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        } // End while isRowEmpty is false.
        System.out.println("*********************************************");
    } // End displayTree().
} // End Tree class.
