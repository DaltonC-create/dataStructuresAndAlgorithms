import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        // Object to read user input.
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the size of data (no more than 20).");
        // Get data size for data structures.
        int size = scan.nextInt();
        // Object for Item class.
        Item item = new Item(size);

        // Creates random objects and inserts them all into the queue array.
        item.fillQueue();
        // Initiates the sorting algorithm
        item.sortAlgorithm();
    }
}
