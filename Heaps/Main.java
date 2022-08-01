/*
 * Dalton Carter
 * This program tackles two challenges involving mapping a heap array into a tree.
 *
 * Part 1. Creates a 10 node array with random unique integers for data. Then it
 * creates connections between every parent and its children starting with the last
 * parent, until the first index is reached. It then displays each index of the array
 * using a tree display method using the node in each index as the root each time.
 * Part 2. Accomplishes the same task as part 1, but uses a queue as well to make
 * connections. Every time the child of a node is also a parent, it will be dequeued
 * and connected, then the resulting subtree will be enqueued until the first index is
 * reached.
 */
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int count = 0, arraySize = 10, max = 50, min = 10;
        Random random = new Random();

        // Boolean array to see if a value was already inserted in Node array.
        boolean[] boolArray1 = new boolean[41];
        boolean[] boolArray2 = new boolean[41];

        // Arrays to insert 10 randomly generated unique numbers.
        Node[] arrayOfNodes1 = new Node[arraySize];
        Node[] arrayOfNodes2 = new Node[arraySize];

        // Heap arrays for parts 1 & 2.
        Heap heapArray1 = new Heap(arraySize);
        Heap heapArray2 = new Heap(arraySize);

        // Try to insert random number, as long as it is not already in the list
        // otherwise restart with new random number.
        while (count < 10) {
            // Range of 10-50.
            int n = random.nextInt((max - min) + 1) + min;
            // Check boolean array if a number is already in Node array.
            if (!boolArray1[n - 10]) {
                // Create a node with randomized number & assign it in the next index available.
                arrayOfNodes1[count] = new Node(n);
                // Set index of boolean array to true for quick checking.
                boolArray1[n - 10] = true;
                // Increment count for the array index.
                count++;
            }
        }

        System.out.println("Part 1:");

        // Insert all elements of array into heap and make a proper heap.
        for (Node node : arrayOfNodes1)
            heapArray1.insert(node);

        // Map the heap array to a binary tree.
        heapArray1.mapToTree();

        // Use displayTree method on each element in the heap to print as tree of nodes.
        for (int i = 0; i < arraySize; i++)
            heapArray1.displayHeapArrayTree(heapArray1.getNode(i));

        // Part 2.
        System.out.println("\nPart 2:");
        // Restart count variable at zero for next loop.
        count = 0;

        // Try to insert random number, as long as it is not already in the list
        // otherwise restart with new random number. Same as part 1 with new array.
        while (count < 10) {
            // Range of 10-50.
            int n = random.nextInt((max - min) + 1) + min;
            // Check boolean array if a number is already in Node array.
            if (!boolArray2[n - 10]) {
                // Create a node with randomized number & assign it in the next index available.
                arrayOfNodes2[count] = new Node(n);
                // Set index of boolean array to true for quick checking.
                boolArray2[n - 10] = true;
                // Increment count for the array index.
                count++;
            }
        }

        // Insert each node from array into Heap Array and sort according to Heap rules.
        for (Node node : arrayOfNodes2)
            heapArray2.insert(node);

        // Part 2's algorithm, also prints the queue at each iteration.
        heapArray2.mapToTreePart2();
    }
}
