/*
 * Dalton Carter
 * This program takes user input and creates a BST out of the characters.
 * It then utilizes a menu-driven section to:
 * 1. Display the tree.
 * 2. display the left side of the tree (recursively).
 * 3. display the leaves of the tree (recursively).
 * 4. display a sibling subtree of a node specified by the user.
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean continueMenu = true;
        Tree tree = new Tree();
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a series of characters with no space to build a Binary Search Tree:");

        String input = scan.next().toUpperCase();

        for (int i = 0; i < input.length(); i++) {
            tree.insert(input.charAt(i));
        }

        do {
            displayMenu();
            int menuChoice = scan.nextInt();
            if (menuChoice < 1 || menuChoice > 5) {
                System.out.println("Sorry that choice is invalid. Please try again.");
                continue;
            }

            switch (menuChoice) {
                case 1:
                    tree.displayTree(tree.getRoot());
                    break;
                case 2:
                    tree.displayLeftSide(tree.getRoot());
                    System.out.println();
                    break;
                case 3:
                    tree.displayLeaves(tree.getRoot());
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Please enter the desired character:");
                    char node = scan.next().charAt(0);
                    char key = Character.toUpperCase(node);
                    tree.siblingSubtree(key);
                    break;
                default:
                    continueMenu = false;
                    break;
            }
        } while (continueMenu);
    }

    public static void displayMenu() {
        System.out.println("\nPlease choose an option:" +
                "\n1.  Display the tree" +
                "\n2.  Display the word built out of the characters on the left side of this tree" +
                "\n3.  Display the word built out of the characters that form the leaves of this tree" +
                "\n4.  Display the sibling subtree of a character node" +
                "\n5.  Exit");
    }
}
