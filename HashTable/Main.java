/*
 * Dalton Carter
 * This program implements a Hash Table, and separate chaining utilizing a binary search tree.
 * 1. Take user input for the number of area codes that will be randomized in the range 100-999.
 * 2. Insert in the hash table, making sure there are no duplicates.
 * 3. Display the load factor and average size of the occupied BSTs.
 * 4. Display non-empty indices of the hash table & display the BST of a user defined index.
 * 5. Search for a user-defined area code within the range & display the sequence of nodes visited.
 */
import java.util.Random;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        int numOfAreaCodes, randNum;
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        // Array to see if a value has already been inserted in the hash table.
        boolean[] tallyArray = new boolean[900];

        // Input validation to ensure a correct number was inputted by user.
        while (true) {
            System.out.println("How many area codes should be inserted?");
            numOfAreaCodes = scan.nextInt();
            if (numOfAreaCodes > 320 || numOfAreaCodes < 1) {
                System.out.println("Sorry the number must be between 1 and 320.");
            } else
                break;
        }

        // Instantiate hash table that is an array of binary trees.
        HashTable hashTable = new HashTable(numOfAreaCodes);

        // Process to insert numbers in hash table.
        for (int i = 0; i < numOfAreaCodes; i++) {
            // Generate random number between 100-999.
            randNum = random.nextInt(900) + 100;

            // If number is not already in hash table, insert as a node.
            if (!tallyArray[randNum - 100]) {
                // Instantiate a node with the random number and insert it.
                Node newNode = new Node(randNum);
                hashTable.insert(newNode);
                // Set index of random number in tally array to true.
                tallyArray[randNum - 100] = true;
            }
        }

        // Output load factor & average size of the BSTs in occupied indices.
        // Output a double formatted to two decimal places.
        System.out.format("Load Factor: %.2f", hashTable.loadFactor(numOfAreaCodes));
        System.out.format("\nAverage size of BSTs in occupied indices: %.2f", hashTable.avgBSTSize(numOfAreaCodes));

        // Output the indices that are not empty in the hash table.
        System.out.println("\nNon-empty indices of the Hash Table:");
        hashTable.displayFilledIndices();

        // Input validation to make sure the user only selects an index listed as non-empty.
        int tableIndex;
        while (true) {
            System.out.println("\nPick a number to see the tree contained within that index:");
            tableIndex = scan.nextInt();

            if (tableIndex < 0 || tableIndex >= numOfAreaCodes || hashTable.isIndexEmpty(tableIndex))
                System.out.println("Sorry that index is incorrect.");
            else
                break;
        }

        // Display the BST contained in the user specified index.
        hashTable.displayBST(tableIndex);

        // Input validation to search for an area code within the hash table.
        int searchCode;
        while (true) {
            System.out.println("\nEnter a 3 digit area code to search for it:");
            searchCode = scan.nextInt();

            // Only allow possible valid area codes to increase chance of finding user's number.
            if (searchCode < 100 || searchCode > 999)
                System.out.println("Sorry that is not a valid area code.");
            else
                break;

        }

        // Display the sequence of the search through the hash table.
        System.out.println("Sequence of Search: ");
        // Output if the node was found or not.
        if (hashTable.find(searchCode) == null)
            System.out.println("\nNode " + searchCode + " was not found.");
        else
            System.out.println("\nNode " + searchCode + " was found.");
    }
}
