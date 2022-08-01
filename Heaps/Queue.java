/*
 * Dalton Carter
 * This class implements the code for queues from the book, and
 * a couple methods created for this particular assignment.
 */
import java.util.Stack;

public class Queue {

    private int maxSize;
    private Node[] queArray;
    private int front;
    private int rear;
    private int nItems;

    // Constructor.
    public Queue(int s) {
        maxSize = s;
        queArray = new Node[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    // Inserts a node into the queue.
    public void insert(Node j) {
        if (rear == maxSize - 1)
            rear = -1;
        queArray[++rear] = j;
        nItems++;
    }

    // Returns a node that has been removed from the queue.
    public Node remove() {
        Node temp = queArray[front++];
        if (front == maxSize)
            front = 0;
        nItems--;
        return temp;
    }

    // Prints all elements from the queue.
    public void printQueue() {
        // 3 lines will indicate another iteration of the algorithm.
        System.out.println("------------------------------------------------------");
        // Loop displays each node in a tree format from front to back.
        for (int i = front; i <= rear; i++) {
            displayHeapQueueTree(queArray[i]);
        }
    }

    // Displays the target node in a particular cell of the Heap Queue as a tree.
    public void displayHeapQueueTree(Node root) {
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
}
