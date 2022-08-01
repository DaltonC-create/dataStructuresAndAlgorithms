import java.util.Stack;

public class Tree {

    private Node root;
    // True if the parent is the left child to find the uncle.
    private boolean parentIsLeftChild;

    public Tree()
    { root = null; }

    // Return the tree's root node.
    public Node getRoot()
    { return root; }

    // Returns true if a vowel can be placed in the tree successfully.
    public boolean insertVowel(char cd) {
        Node newNode = new Node();
        newNode.cData = cd;
        if (root == null)
            root = newNode;
        else {
            Node current = root;
            Node parent;
            Node uncle;
            while (true) {
                parent = current;
                // Go left in the tree.
                if (cd <= current.cData) {
                    current = current.leftChild;

                    // If the new node is a consonant & the same letter as parent.
                    if (!newNode.isVowel() && newNode.cData == parent.cData)
                        return false;

                    // If the current becomes null and the parent is not a vowel, insert & return true.
                    else if (current == null && !parent.isVowel()) {
                        parent.leftChild = newNode;
                        newNode.parent = parent;
                        return true;
                    }
                    // If current becomes null & the parent is a vowel, check uncle.
                    else if (current == null && parent.isVowel()) {

                        // Check if possible to look at grandparent to find uncle.
                        if (parent == root)
                            return false;

                        // Assign the uncle variable
                        uncle = getUncle(parent, parentIsLeftChild);

                        // If the uncle is not null & is a vowel, insert newNode & return true.
                        if (uncle != null && uncle.isVowel()) {
                            parent.leftChild = newNode;
                            newNode.parent = parent;
                            return true;
                        }
                        // If the uncle is not a vowel or null, don't insert & return false.
                        else
                            return false;
                    }
                    // Parent is the left child of the GrandParent.
                    parentIsLeftChild = true;
                } // End if cd <= current

                else {
                    current = current.rightChild;

                    // If current is null, and the parent is a consonant, insert newNode & return true.
                    if (current == null && !parent.isVowel()) {
                        parent.rightChild = newNode;
                        newNode.parent = parent;
                        return true;
                    }
                    // If current is null & parent is a vowel, check uncle.
                    else if (current == null && parent.isVowel()) {

                        // Check if possible to look at grandparent to find uncle.
                        if (parent == root)
                            return false;

                        // Assign the uncle variable.
                        uncle = getUncle(parent, !parentIsLeftChild);

                        // If the uncle is not null & is a vowel, insert newNode & return true.
                        if (uncle != null && uncle.isVowel()) {
                            parent.rightChild = newNode;
                            newNode.parent = parent;
                            return true;
                        }
                        // If the uncle is not a vowel or null, don't insert & return false.
                        else
                            return false;
                    }
                    // Parent is right child of the grandparent.
                    parentIsLeftChild = false;
                }
            } // End while loop
        }
        return true;
    }

    // Returns true if a consonant can be placed in the tree successfully.
    public boolean insertConsonant(char cd) {
        Node newNode = new Node();
        newNode.cData = cd;
        if (root == null)
            root = newNode;
        else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (cd <= current.cData) {
                    current = current.leftChild;

                    // If end of the line insert as parent's left child.
                    if (current == null) {
                        // If the new node is a consonant & the same letter as parent.
                        if (!newNode.isVowel() && newNode.cData == parent.cData)
                            return false;

                        else {
                            parent.leftChild = newNode;
                            return true;
                        }
                    }
                } // End if statement go left.
                else {
                    current = current.rightChild;
                    // If end of the line insert as parent's right child.
                    if (current == null) {
                        parent.rightChild = newNode;
                        return true;
                    }
                } // End else statement go right.
            } // End while loop.
        } // End else statement not root.
        return true;
    } // End insertConsonant()

    // Return the uncle of a node, otherwise null if there is no uncle.
    public Node getUncle(Node parent, boolean isLeftChild) {
        // If parent is the left child & its sibling is not null.
        if (isLeftChild && parent.parent.rightChild != null)
            return parent.parent.rightChild;

        // If parent is the right child and its sibling is not null.
        if (!isLeftChild && parent.parent.leftChild != null)
            return parent.parent.leftChild;

        // Uncle not found, return null.
        return null;
    }

    // Calculate the height of the node passed as a parameter.
    public int calculateHeight(Node localRoot) {
        // If the tree is empty.
        if (localRoot == null)
            return -1;

        // Set up two int variables and return the maximum of the two.
        int leftHeight = calculateHeight(localRoot.leftChild);
        int rightHeight = calculateHeight(localRoot.rightChild);

        // Increment each return statement to get the longest path from node to leaf.
        if (leftHeight > rightHeight)
            return leftHeight + 1;
        else
            return rightHeight + 1;
    }

    // Set the heights of all the nodes currently in the BST.
    public void setHeights(Node localRoot) {
        // If the tree is empty.
        if (root == null)
            return;

        // Assign the node with their height & traverse until node becomes null.
        if (localRoot != null) {
            setHeights(localRoot.leftChild);
            // Call calculateHeight on every node recursively.
            localRoot.height = calculateHeight(localRoot);
            setHeights(localRoot.rightChild);
        }
    }

    // Prints all the nodes in the BST along with their heights.
    public void printNodesWithHeights(Node localRoot) {
        // Base case.
        if (localRoot != null) {
            // Inorder tree traversal.
            printNodesWithHeights(localRoot.leftChild);
            localRoot.displayNode();
            printNodesWithHeights(localRoot.rightChild);
        }
    }

    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("******************************************************");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int i = 0; i < nBlanks; i++)
                System.out.print(' ');

            while(globalStack.isEmpty() == false) {
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
            } // End while globalStack not empty
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        } // End while isRowEmpty false
        System.out.println("******************************************************");
    } // End displayTree()
} // End Tree class
