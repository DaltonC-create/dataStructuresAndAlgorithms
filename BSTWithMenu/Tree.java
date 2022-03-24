/*
 * Dalton Carter
 * This program creates the tree class, using methods from the book, as well as
 * methods for this particular assignment.
 */
import java.util.Stack;

public class Tree {

    private Node root;

    public Tree()
    { root = null; }

    public Node getRoot()
    { return root; }

    // Prints out left side of tree from leaf to root.
    public void displayLeftSide(Node localRoot) {
        if (localRoot != null) {
            displayLeftSide(localRoot.leftChild);
            System.out.print(localRoot.cData);
        }
    }

    // Displays the leaves of the tree from min to max.
    public void displayLeaves(Node localRoot) {
        if (localRoot != null) {
            displayLeaves(localRoot.leftChild);
            // Only display if node has no children.
            if (localRoot.leftChild == null && localRoot.rightChild == null)
                System.out.print(localRoot.cData);
            displayLeaves(localRoot.rightChild);
        }
    }

    // Displays the sibling subtree of a given node.
    public void siblingSubtree(char key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        // Keep going until current = key or null.
        while (current.cData != key) {
            // Iterate parent.
            parent = current;
            // Go to left child.
            if (key < current.cData) {
                current = current.leftChild;
                isLeftChild = true;
            }
            // Go to right child.
            else {
                current = current.rightChild;
                isLeftChild = false;
            }
            if (current == null)
                break;
        }
        // If current is not null & is the left child of the parent.
        if (current != null && isLeftChild) {
            // Displays the subtree of the parent's right child.
            displayTree(parent.rightChild);
        }
        // If current is not null & is the right child of the parent.
        else if (current != null) {
            // Display the subtree of the parent's left child.
            displayTree(parent.leftChild);
        }
        else
            // Node not found.
            System.out.println("Character node not found in tree. Please try again.");
    }

    public void insert(char cd) {
        Node newNode = new Node();
        newNode.cData = cd;
        if (root == null)
            root = newNode;
        else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (cd < current.cData) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            } // End while loop.
        }
    } // End insert method.

    public void displayTree(Node localRoot) {
        Stack globalStack = new Stack();
        globalStack.push(localRoot);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("*********************************************************");

        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < nBlanks; j++)
                System.out.print(' ');

            while (globalStack.isEmpty() == false) {
                Node temp = (Node)globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.cData);
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
        } // End while isRowEmpty false.

        System.out.println("*********************************************************");

    } // End displayTree

} // End Tree class.
