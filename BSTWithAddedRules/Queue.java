public class Queue {

    private final int maxSize;
    private final Node[] queOfNodes;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int s) {
        maxSize = s;
        queOfNodes = new Node[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    // Put item at the rear of queue.
    public void insert(char c) {
        Node node = new Node();
        node.cData = c;
        // Deal with wraparound.
        if (rear == maxSize - 1)
            rear = -1;
        queOfNodes[++rear] = node;
        nItems++;
    }

    public void insertNode(Node node) {
        // Deal with wraparound.
        if (rear == maxSize - 1)
            rear = -1;
        queOfNodes[++rear] = node;
        nItems++;
    }

    // Take item from the queue.
    public Node remove() {
        Node temp = queOfNodes[front++];
        if (front == maxSize)
            front = 0;
        nItems--;
        return temp;
    }

    // True if queue is empty.
    public boolean isEmpty() {
        return (nItems == 0);
    }

    // Displays the queue without having to remove items.
    public void displayQueue() {
        for (int i = 0; i < nItems; i++) {
            System.out.print("{" + queOfNodes[i].cData + "} ");
        }
    }
} // End Queue class.
