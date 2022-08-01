/*
 * Dalton Carter
 * This class establishes a double-ended doubly linked list.
 */

public class DoublyLinkedList
{
    // References to the first and last links in the list.
    private Link first;
    private Link last;

    // Constructor for the DoublyLinkedList class.
    public DoublyLinkedList()
    {
        first = null;
        last = null;
    }

    // Return boolean of if the list is empty.
    public boolean isEmpty()
    {
        return first == null;
    }

    // Insert a link at the last position of the list.
    public void insertLast(char cd)
    {
        Link newLink = new Link(cd);
        if(isEmpty())
            first = newLink;
        else
        {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
    }

    // Display the list in order.
    public void displayForward()
    {
        System.out.print("List (first -> last): ");
        Link current = first;
        while(current != null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println(" ");
    }

    // Display the list in reverse order.
    public void displayBackward()
    {
        System.out.print("List (last -> first): ");
        Link current = last;
        while(current != null)
        {
            current.displayLink();
            current = current.previous;
        }
        System.out.println("");
    }

    // Returns the first link in the list.
    public Link getFirst()
    { return first; }

    // Returns the last link in the list.
    public Link getLast()
    { return last; }

    // Returns boolean of if the list contains a palindrome.
    public boolean isPalindrome(Link head, Link tail)
    {
        // Base case.
        if (head == null)
            return true;
        // If the recursive call ever becomes false, return false.
        if (!isPalindrome(head.next, tail.previous))
            return false;
        // Return if the char at head and the char at tail are equal.
        return head.cData == tail.cData;
    }
} // End of DoublyLinkedList class.
