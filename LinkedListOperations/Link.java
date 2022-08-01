/*
 * Dalton Carter
 * This program establishes the links, their data, and the link to the next link.
 */
public class Link
{
    // Integer data.
    public int iData;
    // Character data.
    public char cData;
    // Link to the next link in the list.
    public Link next;

    // Constructor for integer data.
    public Link(int id)
    {
        iData = id;
    }

    // Constructor for character data.
    public Link(char cd)
    {
        cData = cd;
    }

    // Print linked list for integer data.
    public void displayLinkInt()
    {
        System.out.print(iData + " ");
    }

    // Print linked list for character data.
    public void displayLinkChar()
    {
        System.out.print(cData + " ");
    }
}
