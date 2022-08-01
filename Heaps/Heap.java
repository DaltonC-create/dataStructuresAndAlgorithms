/*
 * Dalton Carter
 * This class implements the code for max heaps from the book, and
 * a few methods created for this particular assignment.
 */
import java.util.Stack;

public class Heap {

    // Underlying data structure for the heap.
    private Node[] heapArray;
    // Variable for the size of the Heap Array.
    private int maxSize;
    // Keep track of the current size of the Heap Array.
    private int currentSize;
    // Variable to represent the halfway point in the Heap Array, the first parent node.
    private int firstParent;
    // Queue used for part 2 of the assignment.
    Queue heapQueue;

    // Constructor.
    public Heap(int max) {
        maxSize = max;
        firstParent = (maxSize - 1) / 2;
        currentSize = 0;
        heapArray = new Node[maxSize];
        // Only need a queue half the size of the Heap Array, only parents get enqueued.
        heapQueue = new Queue(firstParent);
    }

    // Part 1 algorithm.
    // Sets up references to children for the nodes that have children in the Heap Array.
    public void mapToTree() {
        // Start at first parent of the array. Iterate until the beginning of the array.
        for (int i = firstParent; i >= 0; i--) {
            // Variables for the left and right children as indexes.
            int left = (i * 2 + 1), right = (i * 2 + 2);
            // Check if the parent only has a left child.
            if (right >= maxSize)
                // Set up this node's left and only child.
                heapArray[i].leftChild = heapArray[left];
            // Otherwise, the node has two children.
            else {
                // Set up both children. Left child is 2 * current index, right child is one index after.
                heapArray[i].leftChild = heapArray[left];
                heapArray[i].rightChild = heapArray[right];
            }
        }
    }

    // Part 2 algorithm.
    // Does the same as part 1, but uses a queue to create references when a node is a parent.
    public void mapToTreePart2() {
        // Start at first parent of the array. Iterate until the beginning of the array.
        for (int i = firstParent; i >= 0; i--) {
            // Variables for the left and right children as indexes.
            int left = (i * 2 + 1), right = (i * 2 + 2);
            // Check if a right child exists in this array.
            if (right >= maxSize)
                // Assign only left child, right child does not exist.
                heapArray[i].leftChild = heapArray[left];
            // Check if either child is a parent or not.
            else if ((left) > firstParent && (right) > firstParent) {
                // If they are not parents, then use the array to assign children references.
                heapArray[i].leftChild = heapArray[left];
                heapArray[i].rightChild = heapArray[right];
            }
            // Children must be parents, so find them in the queue.
            else {
                // Dequeue each child and set up references with parent node.
                heapArray[i].rightChild = heapQueue.remove();
                heapArray[i].leftChild = heapQueue.remove();
            }
            // Insert node with newly acquired references into the queue.
            heapQueue.insert(heapArray[i]);
            // Print this iteration of the algorithm.
            heapQueue.printQueue();
        }
    }

    // Returns the node at a specified index.
    public Node getNode(int index)
    { return heapArray[index]; }

    // Insert a node and trickle up on each node to follow heap rules.
    public void insert(Node newNode) {
        // Stop if Heap Array is full.
        if (currentSize == maxSize)
            return;
        // Insert node in last available index.
        heapArray[currentSize] = newNode;
        // Get node to follow heap rules and be placed in proper position.
        trickleUp(currentSize++);
    }

    // Moves a node into proper position to follow heap rules.
    public void trickleUp(int index) {
        // Get the index of the parameter's parent.
        int parent = (index - 1) / 2;
        // Node instantiation of parameter.
        Node bottom = heapArray[index];
        // Loop until start of the array, or until the new node is less than its parent.
        while (index > 0 && heapArray[parent].getKey() < bottom.getKey()) {
            // Swapping the parameter with its parent, get index of new parent.
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }
        // Assign index position with node named bottom.
        heapArray[index] = bottom;
    }

    // Displays the target node in a particular cell of the Heap Array as a tree.
    public void displayHeapArrayTree(Node root) {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("------------------------------------------------------");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for(int j = 0; j < nBlanks; j++)
                System.out.print(' ');

            while (globalStack.isEmpty() == false) {
                Node temp = (Node)globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.getKey());
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
        System.out.println("------------------------------------------------------");
    } // End displayTree().
} // End class Heap.
