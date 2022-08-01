/*
 * Dalton Carter
 * This class establishes links to be inserted in linked lists.
 */

public class Link
{
    // Lists will contain chars, and only doubly linked list will use the previous reference.
    public char cData;
    public Link next;
    public Link previous;

    // Constructor of Link class.
    public Link(char cd)
    {
        cData = cd;
    }

    // Displays a Link.
    public void displayLink()
    {
        System.out.print(cData + " ");
    }
} // End of Link class.
