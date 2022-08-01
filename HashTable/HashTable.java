/*
 * Dalton Carter
 * This class implements a hash table using an array and BSTs at every index for
 * separate chaining.
 */
public class HashTable {

    // Array of trees.
    private Tree[] hashArray;
    private int arraySize;

    // Constructor.
    public HashTable(int size) {
        // For smaller numbers it is unnecessary to shrink the hash array.
        if (size > 5)
            // Cut the start of the hash array size to start.
            size *= .75;
        // Get the next lowest number that is prime for arraySize.
        arraySize = getPrime(size);
        // Create array.
        hashArray = new Tree[arraySize];
        // Fill array with trees.
        for (int i = 0; i < arraySize; i++)
            hashArray[i] = new Tree();
    }

    // Return the first available prime number starting at parameter's value and incrementing.
    private int getPrime(int min) {
        // Start at parameter, loop until a prime number is found.
        for (int i = min; true; i++) {
            if (isPrime(i))
                return i;
        }
    }

    // Return true if the parameter is a prime number.
    private boolean isPrime(int n) {
        // Only need to check the first half of multiples.
        for (int i = 2; (i * i <= n); i++) {
            if (n % i == 0)
                // Not a prime number.
                return false;
        }
        // Is a prime number.
        return true;
    }

    // Display all indices of the hash table that are occupied.
    public void displayFilledIndices() {
        // Loop through entire hashArray.
        for (int i = 0; i < arraySize; i++) {
            // Only display if the root of tree at index is not null.
            if (hashArray[i].getRoot() != null)
                System.out.print(i + " ");
        }
        // Extra space for output readability.
        System.out.println();
    }

    // Returns true if the hash array index is empty.
    public boolean isIndexEmpty(int index) {
        return hashArray[index].getRoot() == null;
    }

    // Displays the BST at a specified index.
    public void displayBST(int index) {
        System.out.println("BST at index " + index + ":");
        hashArray[index].displayTree();
    }

    // Returns the load factor of the hash table as a double.
    public double loadFactor(int nItems) {
        return (double)nItems / arraySize;
    }

    // Returns the average size of the BSTs in the hash array.
    public double avgBSTSize(int nItems) {
        int numOccupiedIndices = 0;
        for (int i = 0; i < arraySize; i++) {
            if (hashArray[i].getRoot() != null)
                numOccupiedIndices += 1;
        }
        // Divides the total number of nodes by the number of occupied indices.
        return (double)nItems / numOccupiedIndices;
    }

    // Return int computed using the hash function.
    public int hashFunc(int key)
    { return key % arraySize; }

    // Inserts a node in the tree in the index of the array.
    public void insert(Node newNode) {
        int key = newNode.iData;
        // Hash the key.
        int hashVal = hashFunc(key);
        // Insert at hashVal index using BST rules.
        hashArray[hashVal].insert(newNode);
    }

    // Returns a node within the tree at an index in the array.
    public Node find (int key) {
        // Hash the key.
        int hashVal = hashFunc(key);
        // Return node when found, or null if not found.
        return hashArray[hashVal].find(key);
    }
} // End HashTable class.
