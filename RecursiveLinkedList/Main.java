/*
 * Dalton Carter
 * This project has three parts:
 * Part 1: display a single-ended singly linked list backwards.
 * Part 2: check if a double-ended doubly linked list of chars is a palindrome.
 * Bonus: indirect recursive function to simulate the exponent operation through addition.
 */

import java.util.Scanner;

public class Main
{
    // Returns the product of two numbers using addition.
    public static int multiply(int a, int b)
    {
        // Any number to the power of 0 is 1.
        if (b == 0)
            return 1;
        // Any number to the power of one is itself.
        if (b == 1)
            return a;
        // 0 to the power of any number is 0.
        if (a == 0)
            return 0;
        // Recursive call for multiply method.
        return (a + multiply(a, b-1));
    }

    // Returns a number(x) to the power of another number(y) by indirect recursion.
    public static int power(int x, int y)
    {
        // Any number raised to the power of 0 is 1.
        if (y == 0)
            return 1;
        // Indirect recursive call to both methods.
        return multiply(x, power(x, y-1));
    }

    public static void main(String[] args)
    {
        // Scanner to take input.
        Scanner sc = new Scanner(System.in);
        // Start of Part 1 of assignment.
        System.out.println("Part 1:");
        System.out.println("Please enter a word and it will be displayed backwards:");

        // Instantiation of single ended singly linked list.
        SinglyLinkedList singleList = new SinglyLinkedList();

        // Take input for singly linked list.
        String reverse = sc.nextLine();

        // Insert each char in string into linked list at first.
        for (int i = reverse.length() - 1; i >= 0; i--)
            singleList.insertFirst(reverse.charAt(i));

        // Link object set to the first link in the list.
        Link front = singleList.getFirst();

        // Display the single-ended singly linked list in reverse.
        System.out.print("List (Last -> first): ");
        singleList.displayBackwards(front);

        // Start of Part 2.
        System.out.println("\n\nPart 2:");
        System.out.println("Please enter a string of characters to see if it is a palindrome or not:");
        // Instantiation of double-ended doubly linked list.
        DoublyLinkedList doubleList = new DoublyLinkedList();
        // Take input for doubly linked list.
        String palindrome = sc.nextLine();

        // Insert each char in the list at last position.
        for (int i = 0; i < palindrome.length(); i++)
            doubleList.insertLast(palindrome.charAt(i));

        // Links to represent the first and last links of the list.
        Link head = doubleList.getFirst();
        Link tail = doubleList.getLast();

        // Show the list forward and backwards to see if it is a palindrome.
        doubleList.displayForward();
        doubleList.displayBackward();

        // Output to signify if it is a palindrome or not.
        if (doubleList.isPalindrome(head, tail))
            System.out.println(palindrome + " is a Palindrome.");
        else
            System.out.println(palindrome + " is not a Palindrome.");

        // Start of bonus section.
        System.out.println("\nBonus:");
        System.out.println("Please type in two numbers, each followed by enter " +
                "to find the first number to the power of the second:");

        // Take in user input for each variable to be calculated.
        System.out.print("x: ");
        int x = sc.nextInt();
        System.out.print("y: ");
        int y = sc.nextInt();
        // Function call and printing of result.
        System.out.println(x + "^" + y + " = " + power(x, y));
    }
}
