/*
 * Dalton Carter
 * This program implements a Binary Search Tree with specified rules.
 * 1. No vowel parent can have a vowel child unless the parent's sibling is also a vowel.
 * 2. No consonant parent can have a duplicate value as a child i.e. the parent & a child
 * cannot be the same consonant letters. This only applies to consonants, not vowels.
 * 2.1 legal duplicates shall be the left child of its duplicate ancestor.
 * 3. Letters not inserted in part 1 will be put on hold & inserted in proper order in
 * part 2.
 * 4. Display a height attribute for each node in the tree at the end of Part 1.
 * Part 2 will populate the tree in each 1st available space with the left-over letters
 * using binary tree rules, not BST rules.
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a series of upper-case characters with " +
                "no space to build a Binary Search Tree:");
        // Make sure input is uppercase.
        String input = scan.next().toUpperCase();

        // Queue for the extra letters that violate the rules of part one.
        Queue overflowQueue = new Queue(input.length());
        // Queue for the tree in part two to decide where overflow letters go.
        Queue treeQueue = new Queue(input.length());
        // Tree for both parts.
        Tree tree = new Tree();

        // Loop through string to input in either the tree or queue for overflow.
        for (int i = 0; i < input.length(); i++) {
            // Letter is a vowel.
            if (isVowel(input.charAt(i))) {
                // Insert using insertVowel(), otherwise insert in queue.
                if (!tree.insertVowel(input.charAt(i)))
                    overflowQueue.insert(input.charAt(i));
            }
            // Letter is a consonant.
            else {
                // Insert using insertConsonant(), otherwise insert in queue.
                if (!tree.insertConsonant(input.charAt(i)))
                    overflowQueue.insert(input.charAt(i));
            }
        }
        // Display the tree & queue after part 1 of the assignment
        tree.displayTree();
        if (overflowQueue.isEmpty())
            System.out.println("All characters were properly inserted in the tree.");
        else {
            System.out.print("Overflow Characters: ");
            overflowQueue.displayQueue();
            // New line to start the output of the nodes with their heights.
            System.out.println();
        }

        System.out.println("\nNodes with their heights:");

        // Set the heights of all the nodes, and then print each node with their height.
        tree.setHeights(tree.getRoot());
        tree.printNodesWithHeights(tree.getRoot());

        // Loop to insert overflow queue into tree until overflow queue is empty.
        while (!overflowQueue.isEmpty()) {
            // Start at the root of the tree.
            if (treeQueue.isEmpty())
                treeQueue.insertNode(tree.getRoot());

            // Enqueue node from tree to check if it has null children for the overflow queue.
            Node treeNode = treeQueue.remove();

            // If the left child is null.
            if (treeNode.leftChild == null) {
                // Dequeue the first node from the overflowQueue.
                Node leftNode = overflowQueue.remove();

                // Insert the node with proper references.
                treeNode.leftChild = leftNode;
                leftNode.parent = treeNode;

                // Insert the new node in the treeQueue to continue inserting till overflowQueue is empty.
                treeQueue.insertNode(treeNode.leftChild);

                // Check if overflowQueue becomes empty after inserting left node.
                if (overflowQueue.isEmpty())
                    break;
            }
            // The left child is not null, enqueue it.
            else
                treeQueue.insertNode(treeNode.leftChild);

            // If the right child is null.
            if (treeNode.rightChild == null) {
                // Dequeue the first node from the overflowQueue.
                Node rightNode = overflowQueue.remove();

                // Insert the node with the proper references.
                treeNode.rightChild = rightNode;
                rightNode.parent = treeNode;

                // Insert the new node in the treeQueue to continue inserting till overflowQueue is empty.
                treeQueue.insertNode(treeNode.rightChild);
            }
            // The right child is not null, enqueue it.
            else
                treeQueue.insertNode(treeNode.rightChild);
        }

        // Display the tree for part 2.
        tree.displayTree();
    }

    // Returns true if the letter is a vowel.
    public static boolean isVowel(char cd) {
        return (cd == 'A' || cd == 'E' || cd == 'I' || cd == 'O' || cd == 'U');
    }
}
