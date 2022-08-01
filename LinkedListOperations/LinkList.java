/*
 * Dalton Carter
 * This program creates all the methods to manipulate each linked list in the
 * main program.
 */

import java.util.Scanner;

public class LinkList
{
    // Reference to the first link in the list.
    private Link first;
    // Scanner object for user input.
    Scanner scan = new Scanner(System.in);

    // Constructor for empty linked list.
    public LinkList()
    {
        first = null;
    }

    // Check if the list is empty.
    public boolean isEmpty()
    {
        return first == null;
    }

    // Populate char linked list with characters from inputted string.
    public void populateCharList()
    {
        System.out.println("Please enter any word: ");
        // Store inputted string in word.
        String word = scan.nextLine();
        // Keep track of previous link while traversing list.
        Link previous = first;
        // Loop to the end of the inputted string.
        for (int i = 0; i < word.length(); i++)
        {
            // Object to form a new link in the list with character.
            Link newLink = new Link(word.charAt(i));

            // Set newLink as first if list is empty.
            if (isEmpty())
            {
                first = newLink;
            }
            else
            {
                // Put newLink after the previous link.
                previous.next = newLink;
            }
            // Set previous to newLink.
            previous = newLink;
        }
    }

    // Delete instance of rm, the third character, and any vowels between consonants.
    public void deleteRMAndVowels()
    {
        // Keep track of current link while traversing.
        Link current = first;
        // Keep track of previous link while traversing.
        Link previous = first;
        while (current.next != null)
        {
            // Stop loop if linked list is empty.
            if (isEmpty())
                break;
            // If the current char is a vowel and the previous and next chars are consonants.
            if (isVowel(current.cData) && !isVowel(previous.cData) && !isVowel(current.next.cData))
            {
                // Remove vowel from linked list.
                previous.next = current.next;
                // Reset current and previous to first.
                current = first;
                previous = first;
            }

            // If the current char is r and the next char is m, regardless of case.
            else if ((current.cData == 'r' || current.cData == 'R')
                    && (current.next.cData == 'm' || current.next.cData == 'M'))
            {
                // Null the list if it contains only 'r' 'm' and nothing else.
                if (previous == current && current.next.next == null)
                {
                    first = null;
                    break;
                }

                // If rm is at the end of the list.
                else if (current.next.next == null)
                {
                    // Remove rm and set previous to null.
                    previous.next = null;
                    // Exit the loop because the list has been exhausted.
                    break;
                }

                // If rm is at the beginning of the list.
                else if (current == first)
                {
                    // Set first to teh third link to remove rm and third char link.
                    first = current.next.next.next;
                }

                // Any other scenario of finding rm in the linked list.
                else
                {
                    // Set previous.next to three links after to remove rm and third char link.
                    previous.next = current.next.next.next;
                    // Reset current and previous to first link.
                    current = first;
                    previous = first;
                }
                // Print linked list for progress.
                displayListChar();
            }

            // If current char is not a vowel or r preceding an m.
            else
            {
                // Iterate through the list with current and previous.
                previous = current;
                current = current.next;
            }
        }
    }

    // Check if character is a vowel or consonant.
    public boolean isVowel(char letter)
    {
        return (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u'
                || letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U');
    }

    // Populate int linked list with sorted set provided by user.
    public void populateIntList(int num)
    {
        System.out.println("How many numbers in set " + num + "?");
        // Size of the set of numbers.
        int size = scan.nextInt();
        System.out.println("Please enter " + size + " numbers separated by spaces or enter");
        // Keep track of previous while traversing the list.
        Link previous = first;
        for (int i = 0; i < size; i++)
        {
            // Object to form a new link in the int linked list.
            Link newLink = new Link(scan.nextInt());

            // Set newLink as first if list is empty.
            if (isEmpty())
            {
                first = newLink;
            }
            else
            {
                // Put newLink after previous link.
                previous.next = newLink;
            }
            // Set previous to newLink.
            previous = newLink;
        }
    }

    // Merge both of the int linked lists into one.
    public void mergeLists(LinkList list1, LinkList list2)
    {
        // References to the first links in each int linked list.
        Link current1 = list1.first;
        Link current2 = list2.first;
        // If first of list 1 is less than first of list 2.
        if (current1.iData < current2.iData)
        {
            // Make first of list 1 first of merged list and iterate.
            first = current1;
            current1 = current1.next;
        }
        else
        {
            // Make first of list 2 first of merged list and iterate.
            first = current2;
            current2 = current2.next;
        }

        // Keep track of previous link while traversing the list.
        Link previous = first;
        while (current1 != null && current2 != null)
        {
            // Temporary link for which link will be added to merged list next.
            Link tempLink;
            // If the current of list 1 is less than the current of list two.
            if (current1.iData < current2.iData)
            {
                // Temp link becomes the current link of list 1.
                tempLink = current1;
                // Increment the current link of list 1.
                current1 = current1.next;
            }
            else
            {
                // Temp link becomes the current link of list 2.
                tempLink = current2;
                // Increment the current link of list 2.
                current2 = current2.next;
            }
            // Add tempLink in front of previous
            previous.next = tempLink;
            // Make the new link previous.
            previous = tempLink;
        }

        // If the current link of list 1 is not at the end.
        if (current1 != null)
            // Add to the merged list.
            previous.next = current1;
        else
            // Add current link of list 2 to the merged list.
            previous.next = current2;
        System.out.print("Merged ");
    }

    // Find any duplicates in the merged list.
    public void findDuplicates()
    {
        System.out.println("Sublists of duplicates:");
        // References to current and previous link while traversing the list.
        Link current = first;
        Link previous = first;
        // Boolean variable if duplicates were found.
        boolean duplicates = false;
        while (current.next != null)
        {
            // If the current int equals the next int.
            if (current.iData == current.next.iData)
            {
                // Print the current link's data.
                System.out.print(current.iData + " ");
                // Duplicates were found.
                duplicates = true;
            }

            // If the current link's data is the last of duplicates for the current int.
            else if (current.iData == previous.iData && current != first)
            {
                // Print the current link's data and end the line.
                System.out.println(current.iData);
                // Duplicates were found.
                duplicates = true;
            }
            // Iterate the previous and current references.
            previous = current;
            current = current.next;
        }

        // If the last link's data is a duplicate and the last link in the list.
        if (current.iData == previous.iData)
        {
            System.out.println(current.iData);
            duplicates = true;
        }

        // Output message if no duplicates were found.
        if (!duplicates)
            System.out.println("No duplicates found.");
    }

    // Display the linked list that contains integers.
    public void displayListInt()
    {
        System.out.print("List (first -> last): ");
        Link current = first;
        while(current != null)
        {
            current.displayLinkInt();
            current = current.next;
        }
        System.out.println(" ");
    }

    // Display the linked list that contains characters.
    public void displayListChar()
    {
        System.out.print("List (first -> last): ");
        Link current = first;
        while(current != null)
        {
            current.displayLinkChar();
            current = current.next;
        }
        System.out.println(" ");
    }
}
