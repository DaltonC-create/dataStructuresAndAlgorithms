/*
 * Dalton Carter
 * This class establishes the BST used in this assignment, using code from the book.
 */
import java.util.Stack;

public class Tree {

    private Node root;

    // Constructor.
    public Tree()
    { root = null; }

    // Return the root of the tree.
    public Node getRoot()
    { return root; }

    // Inserts a node into the root with char parameter as attribute.
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
        System.out.println("---------------------------------------------");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int i = 0; i < nBlanks; i++)
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
                for (int i = 0; i < nBlanks * 2 - 2; i++)
                    System.out.print(' ');
            } // End while globalStack not empty.
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        } // End while isRowEmpty is false.
        System.out.println("---------------------------------------------");
    } // End displayTree().
}
