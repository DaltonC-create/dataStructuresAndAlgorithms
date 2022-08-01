/*
 * Dalton Carter
 * This program creates and manipulates three linked lists with the help of Link class
 * and LinkList class, one with character data, and the other two with integer data.
 */
public class Main
{
    public static void main(String[] args)
    {
        // Character linked list.
        LinkList charList = new LinkList();
        // Two integer linked lists.
        LinkList intList1 = new LinkList();
        LinkList intList2 = new LinkList();
        // Linked list to contain the merged integer lists.
        LinkList mergedList = new LinkList();

        System.out.println("Part 1:");
        System.out.println("You will enter a string and these instances will be removed:");
        System.out.println("1. Any vowels between consonants.");
        System.out.println("2. The sequence rm and the character following the sequence.");

        // Populate char list with characters from user inputted string.
        charList.populateCharList();
        // Remove instance of rm, and the following character, and vowels between consonants
        charList.deleteRMAndVowels();
        // Print the char linked list.
        charList.displayListChar();

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        System.out.println("Part 2:");
        System.out.println("You will give two lists of sorted numbers (They must be sorted).");
        System.out.println("The lists will be merged and duplicates will be found.");

        // Populate first int list with sorted list provided by user.
        intList1.populateIntList(1);
        intList2.populateIntList(2);

        // Print both linked lists.
        intList1.displayListInt();
        intList2.displayListInt();

        // Merge both int lists and keep ascending order.
        mergedList.mergeLists(intList1, intList2);
        // Print the merged list.
        mergedList.displayListInt();
        mergedList.findDuplicates();
    }
}
