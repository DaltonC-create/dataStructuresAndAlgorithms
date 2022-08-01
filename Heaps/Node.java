/*
 * Dalton Carter
 * This class represents the nodes that will be used in the array, heap array, and queue.
 */
public class Node {

    private int iData;
    public Node leftChild;
    public Node rightChild;

    // Constructor.
    public Node(int key)
    { iData = key; }

    // Returns the integer data key for a node.
    public int getKey()
    { return iData; }
}