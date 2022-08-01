public class Node {

    // Letter in the node
    public char cData;
    // Height of the node.
    public int height = 0;
    // References to both children, and a node's parent.
    public Node parent;
    public Node leftChild;
    public Node rightChild;

    // Displays the current node and their height.
    public void displayNode() {
        System.out.println("Node: " + cData + ", Height: " + height);
    }

    // Returns true if character in node is a vowel.
    public boolean isVowel() {
        return (cData == 'A' || cData == 'E' || cData == 'I' || cData == 'O' || cData == 'U');
    }
} // End of Node class.
