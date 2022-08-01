import java.util.Arrays;
import java.util.Random;

public class Item
{
    // Variables for the Item objects.
    private final int key, timeStamp;
    // Size of the data.
    private int size;
    // Output array.
    private Item[] sortedArray;
    // Random object for Item keys.
    Random rand = new Random();
    // Object for Queue.
    Queue que;
    // Objects for each stack.
    StackX stack1, stack2;

    // Constructor to establish data size for each data structure.
    public Item(int size)
    {
        this.size = size;
        key = 0;
        timeStamp = 0;
        sortedArray = new Item[size];
        que = new Queue(size);
        stack1 = new StackX(size);
        stack2 = new StackX(size);
    }

    // Constructor to create items with key:timeStamp format.
    public Item(int num, int time)
    {
        key = num;
        timeStamp = time;
    }

    // Override the toString method to show in key:timeStamp format.
    public String toString()
    {
        return (key + ":" + timeStamp + " ");
    }

    // Generate random numbers and timestamps to fill the queue before sorting.
    public void fillQueue()
    {
        for (int i = 0; i < size; i++)
        {
            int randNum = rand.nextInt(11 - 1) + 1;
            que.insert(new Item(randNum, i + 1));
        }
    }

    // Start of the sorting algorithm.
    public void sortAlgorithm()
    {
        // Variable for index of the output array.
        int arrayIndex = 0;
        // Keep looping until the final item of the output array is no longer null.
        while (sortedArray[size - 1] == null)
        {
            if (que.isEmpty())
            {
                // Pop value from stack1 into the output array.
                sortedArray[arrayIndex++] = stack1.pop();
                // Pop all items from stack1 into the queue until stack1 is empty.
                while (!stack1.isEmpty())
                    que.insert(stack1.pop());
                // Pop all items from stack2 into the queue until stack2 is empty.
                while (!stack2.isEmpty())
                    que.insert(stack2.pop());
            }
            else
            {
                // Assign min to the item at the front of the queue.
                Item min = que.remove();
                // Push to stack1 if stack1 is empty or has a key less than the
                // current top of stack1. Checks time stamps if keys are equal.
                if (stack1.isEmpty() || min.key < stack1.peek().key ||
                        min.key == stack1.peek().key
                        && min.timeStamp < stack1.peek().timeStamp)
                {
                    // Push onto stack 1.
                    stack1.push(min);
                }
                // If key is greater or the time stamp is greater in duplicate scenario.
                else
                {
                    // Push onto stack 2.
                    stack2.push(min);
                }
            }
            // Output stack1.
            stack1.displayStack(1);
            // Output stack2.
            stack2.displayStack(2);
            // Output queue.
            que.displayQueue();
            // Output the final output array.
            System.out.println("\nOutput Array: " + Arrays.toString(sortedArray));
            System.out.println("++++++++++++++++++++++++++++++++++++++++");
        }
    } // End of sort algorithm.
}
