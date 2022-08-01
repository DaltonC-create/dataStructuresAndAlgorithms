/*
 * Dalton Carter
 * This class establishes a single-ended singly linked list.
 */

public class SinglyLinkedList
{
    // Reference to the first link in the linked list.
    private Link first;

    // Constructor for SinglyLinkedList class.
    public SinglyLinkedList()
    {
        first = null;
    }

    // Insert a link at the first position of the list.
    public void insertFirst(char cd)
    {
        Link newLink = new Link(cd);
        newLink.next = first;
        first = newLink;
    }

    // Returns the link at the first position of the list.
    public Link getFirst()
    { return first;}

    // Displays the list in reverse.
    public void displayBackwards(Link front)
    {
        // Base case.
        if (front == null)
            return;
        // Recursive call.
        displayBackwards(front.next);
        // Print out the link.
        System.out.print(front.cData + " ");
    }
} // End of SinglyLinkedList class.
