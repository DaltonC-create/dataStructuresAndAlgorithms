/*
 * Dalton Carter
 * This program takes an input string and builds a binary search tree out of it,
 * then it takes the BST and maps it to either a directed or undirected graph.
 * Next it uses a loop to display a menu of 5 options involving the graph, and
 * 1 option involving the BST.
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Flag for while loop.
        boolean continueLooping = true;
        int graphChoice, loopChoice, option4Int, option5Int, option6Int;
        char option4Char, option5Char, option6Char;

        // Object initializations.
        Scanner scan = new Scanner(System.in);
        Tree tree = new Tree();
        Graph BSTGraph = new Graph();

        System.out.println("To build a Binary Search Tree please enter a word in all CAPS less than 20 characters:");
        String input = scan.nextLine().toUpperCase();
        // Input validation to only allow a string of 1-20 characters.
        while (input.length() > 20 || input.length() < 1) {
            System.out.println("Sorry that is not the right amount of characters, try again.");
            System.out.println("To build a Binary Search Tree please enter a word in " +
                                "all CAPS less than 20 characters:");
            input = scan.nextLine().toUpperCase();
        }

        // Insert characters into BST.
        for (int i = 0; i < input.length(); i++)
            tree.insert(input.charAt(i));
        // Create either a directed or undirected graph.
        System.out.println(
                "Map the BST into: (1 or 2)" +
                "\n1. Directed Graph" +
                "\n2. Undirected Graph");
        graphChoice = scan.nextInt();
        // Input validation for the choice of graph.
        while (graphChoice < 1 || graphChoice > 2) {
            System.out.println("That is not a valid choice. Please try again.");
            System.out.println(
                    "Map the BST into: (1 or 2)" +
                    "\n1. Directed Graph" +
                    "\n2. Undirected Graph");
            graphChoice = scan.nextInt();
        }

        // Creating the graph chosen by the user.
        if (graphChoice == 1)
            BSTGraph.BSTMapToDirectedGraph(null, tree.getRoot());
        else
            BSTGraph.BSTMapToUndirectedGraph(null, tree.getRoot());

        // Menu of options on the graph and tree.
        while (continueLooping) {
            System.out.println(
                    "\nPlease select one option: (1-7)" +
                    "\n1. Display the BST in a tree format." +
                    "\n2. Display the Vertex array." +
                    "\n3. Display the Adjacency Matrix." +
                    "\n4. Given a vertex: Display ALL possible separate paths starting with that " +
                            "vertex in a Depth First Search pattern:" +
                    "\n5. Given a vertex: Display ALL its adjacent vertices (one edge apart):" +
                    "\n6. Given a vertex: Display ALL the vertices that are two edges away from it:" +
                    "\n7. Exit.");

            loopChoice = scan.nextInt();
            switch(loopChoice) {
                // Display the tree.
                case 1:
                    tree.displayTree();
                    break;
                // Display the list of vertices in the graph.
                case 2:
                    BSTGraph.displayVertexList();
                    break;
                // Display the adjacency matrix of the graph.
                case 3:
                    BSTGraph.displayAdjMatrix();
                    break;
                // Display all possible paths from a particular vertex.
                case 4:
                    System.out.println("Enter the letter:");
                    option4Char = Character.toUpperCase(scan.next().charAt(0));
                    option4Int = BSTGraph.getCharIndex(option4Char);
                    // Char given by the user is not in the graph.
                    if (option4Int == -1) {
                        System.out.println("Sorry that is not a valid choice, choose option 4 to try again.");
                        break;
                    }
                    BSTGraph.dfsDisplayAllPaths(option4Int);
                    break;
                // Display all adjacent vertices one edge away from given vertex.
                case 5:
                    System.out.println("Enter the letter:");
                    option5Char = Character.toUpperCase(scan.next().charAt(0));
                    option5Int = BSTGraph.getCharIndex(option5Char);
                    // Char given by the user is not in the graph.
                    if (option5Int == -1) {
                        System.out.println("Sorry that is not a valid choice, choose option 5 to try again.");
                        break;
                    }
                    BSTGraph.displayOneEdgeAdj(option5Int);
                    break;
                // Display all adjacent vertices two edges away from given vertex.
                case 6:
                    System.out.println("Enter the letter:");
                    option6Char = Character.toUpperCase(scan.next().charAt(0));
                    option6Int = BSTGraph.getCharIndex(option6Char);
                    // Char given by the user is not in the graph.
                    if (option6Int == -1) {
                        System.out.println("Sorry that is not a valid choice, choose option 6 to try again.");
                        break;
                    }
                    BSTGraph.displayTwoEdgeAdj(BSTGraph.getCharIndex(option6Char));
                    break;
                // Quit the program.
                case 7:
                    continueLooping = false;
                    break;
                // User input an invalid option.
                default:
                    System.out.println("Sorry that is not a correct choice, try again.");
            } // End Switch statement.
        } // End while continueLooping.
    } // End main function.
} // End class main.
