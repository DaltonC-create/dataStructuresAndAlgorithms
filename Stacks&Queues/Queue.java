public class Queue
{
    // Variable for the size of the queue.
    private final int maxSize;
    // First item, last item, and the number of items.
    private int front, rear, numItems;
    private final Item[] queueArray;

    // Constructor.
    public Queue(int s)
    {
        maxSize = s;
        queueArray = new Item[maxSize];
        front = 0;
        rear = -1;
        numItems = 0;
    }

    // Add item to the queue.
    public void insert(Item i)
    {
        // Wraparound.
        if (rear == maxSize - 1)
            rear = -1;
        // Increment the rear and add item at the rear.
        queueArray[++rear] = i;
        // Increment the number of items.
        numItems++;
    }

    // Remove item to the queue.
    public Item remove()
    {
        // Temp variable to hold and return the front item.
        Item temp = queueArray[front++];
        // Wraparound.
        if (front == maxSize)
            front = 0;
        // Decrement the number of items.
        numItems--;
        return temp;
    }

    // Return true if the queue is empty.
    public boolean isEmpty()
    {
        return (numItems == 0);
    }

    // Return item at index num.
    public Item peekN(int num)
    {
        return queueArray[num];
    }

    // Output the queue.
    public void displayQueue()
    {
        System.out.print("\nQueue (front -> rear): ");
        // Loop from front to rear, printing each item.
        for (int i = front; i <= rear; i++)
        {
            System.out.print(peekN(i));
            System.out.print(' ');
        }
    }
}
