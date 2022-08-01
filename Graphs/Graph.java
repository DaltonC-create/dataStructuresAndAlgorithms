/*
 * Dalton Carter
 * This class establishes a graph, using code from the textbook,
 * as well as code created specifically for this assignment.
 */
public class Graph {

    private final int MAX_VERTS = 20;
    private final Vertex[] vertexList;
    private final int[][] adjMat;
    private int nVerts;
    private final StackX theStack;

    // Constructor.
    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];

        nVerts = 0;
        // Set all values in adjacency matrix to zero.
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++)
                adjMat[i][j] = 0;
        }
        theStack = new StackX();
    }

    // Add a vertex to the vertexList.
    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    // Add edges to the adjacency matrix in an undirected graph.
    public void addEdgeUndirected(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    // Adds an edge to the adjacency matrix in a directed graph.
    public void addEdgeDirected(int start, int end) {
        adjMat[start][end] = 1;
    }

    // Displays an individual vertex.
    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    // Displays the list of vertices.
    public void displayVertexList() {
        for (int i = 0; i < nVerts; i++)
            System.out.print(vertexList[i].label + " ");
    }

    // Resets wasVisited for every vertex in the vertexList.
    public void resetWasVisited() {
        for (int i = 0; i < nVerts; i++)
            vertexList[i].wasVisited = false;
    }

    // Displays the adjacency matrix formatted.
    public void displayAdjMatrix() {
        // Add space for top row.
        System.out.print("     ");
        // Prints all the characters of the vertices for the top row.
        for (int l = 0; l < nVerts; l++)
            System.out.printf("%5c", vertexList[l].label);

        System.out.println();
        // Goes through adjacency matrix printing out all integers, starting with that row's character.
        for (int i = 0; i < nVerts; i++) {
            System.out.printf("%5c", vertexList[i].label);
            for (int j = 0; j < nVerts; j++) {
                System.out.printf("%5d", adjMat[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    // Depth-First Search Algorithm that displays all possible paths from the parameter.
    public void dfsDisplayAllPaths(int vertexIndex) {
        // Set initial vertex to wasVisited and push on the stack.
        vertexList[vertexIndex].wasVisited = true;
        theStack.push(vertexIndex);
        // String to keep track of the path for output.
        String path = "";
        // Boolean to only print out a full path.
        boolean fullPath = false;

        while (!theStack.isEmpty()) {
            // Get an unvisited vertex adjacent to the vertex on top of the stack.
            int v = getAdjUnvisitedVertex(theStack.peek());

            // It is the first vertex, so include it in path variable.
            if (theStack.peek() == vertexIndex && path.isEmpty()) {
                path += vertexList[vertexIndex].label;
            }

            // There is no adjacent unvisited vertex to the current vertex.
            if (v == -1) {
                theStack.pop();
                // If this is a full path, display it.
                if (fullPath)
                    System.out.println(path);
                // After removing a vertex, it is no longer a full path.
                fullPath = false;
                // Remove the last character from the string.
                path = removeLastCharacter(path);
            }
            // There is an adjacent unvisited node found.
            else {
                vertexList[v].wasVisited = true;
                theStack.push(v);
                path += vertexList[v].label;
                // Next time an unvisited adjacent vertex is not found, we will print.
                fullPath = true;
            }
        } // End while loop.

        // Stack is empty, so we're done, reset all visited flags to false.
        resetWasVisited();
    } // End dfsDisplayAllPaths().

    // Returns a substring of parameter without the final character of the string.
    public String removeLastCharacter(String str) {
        return str.substring(0, str.length() - 1);
    }

    // Returns the index of an adjacent unvisited vertex one edge away.
    public int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < nVerts; i++) {
            if (adjMat[v][i] == 1 && !vertexList[i].wasVisited)
                return i;
        }
        return -1;
    }

    // Gets the index of a specified character from the vertex list.
    public int getCharIndex(char letter) {
        for (int i = 0; i < nVerts; i++) {
            if (vertexList[i].label == letter)
                return i;
        }
        return -1;
    }

    // Returns the index of an adjacent unvisited vertex two edges away from parameter.
    public int getTwoEdgeAdjVertex(int v) {
        int i, j;
        // Find adjacent vertex one edge away from parameter.
        for (i = 0; i < nVerts; i++) {
            if (adjMat[v][i] == 1 && !vertexList[i].wasVisited) {
                break;
            }
        }
        // Check to avoid out of bounds exception from variable i.
        if (i > 19)
            return -1;
        // Find adjacent vertex two edges away from parameter.
        for (j = 0; j < nVerts; j++) {
            if (adjMat[i][j] == 1 && !vertexList[j].wasVisited)
                return j;
        }
        // Check if the entire row of single edge adjacent vertices was exhausted.
        if (i < nVerts && j == nVerts)
            // -2 means to set adjacent vertex one edge away wasVisited to true, to continue looping
            // through the row of adjacent vertices.
            return -2;
        // Unvisited vertex was not found.
        return -1;
    } // End getTwoEdgeAdjVertex().

    // Displays all vertices one edge away from parameter.
    public void displayOneEdgeAdj(int vertexIndex) {
        // Set initial vertex wasVisited to true.
        vertexList[vertexIndex].wasVisited = true;
        System.out.println("Vertices one edge away from " + vertexList[vertexIndex].label + ":");
        // Flag to check if there are any adjacent vertices.
        boolean hasAdjVertex = false;

        while (true) {
            // Get index of adjacent unvisited vertex.
            int v = getAdjUnvisitedVertex(vertexIndex);

            // All adjacent vertices were found.
            if (v == -1)
                break;
            // Display adjacent vertex and set wasVisited to true.
            else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                System.out.print(" ");
                hasAdjVertex = true;
            }
        }
        // If there are no adjacent vertices found, display a message.
        if (!hasAdjVertex)
            System.out.println(vertexList[vertexIndex].label + " has no adjacent vertices one edge away.");

        resetWasVisited();
    } // End displayOneEdgeAdj().

    // Displays all vertices two edges away from parameter.
    public void displayTwoEdgeAdj(int vertexIndex) {
        // Set initial vertex wasVisited to true.
        vertexList[vertexIndex].wasVisited = true;
        System.out.println("Vertices two edges away from " + vertexList[vertexIndex].label + ":");
        // Flag to check if there are any adjacent vertices.
        boolean hasTwoEdgeAdj = false;

        while (true) {
            // Get the adjacent unvisited vertex two edges away.
            int v = getTwoEdgeAdjVertex(vertexIndex);

            // All adjacent vertices were found.
            if (v == -1)
                break;
            // The adjacent vertex one edge away has no unvisited adjacent vertices left.
            else if (v == -2) {
                // Set the current adjacent vertex wasVisited to true.
                int noUnvisitedVertices = getAdjUnvisitedVertex(vertexIndex);
                vertexList[noUnvisitedVertices].wasVisited = true;
            }
            // Display the adjacent vertex and set wasVisited to true.
            else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                System.out.print(" ");
                hasTwoEdgeAdj = true;
            }
        }

        // If there are no adjacent vertices found, display a message.
        if (!hasTwoEdgeAdj)
            System.out.println(vertexList[vertexIndex].label + " has no adjacent vertices two edges away.");

        resetWasVisited();
    } // displayTwoEdgeAdj().

    // Maps a BST to a directed graph.
    public void BSTMapToDirectedGraph(Node parent, Node child) {
        // Only add edges when it's not the first node being inserted.
        if (parent != null) {
            addEdgeDirected(getCharIndex(parent.cData), nVerts);
            addVertex(child.cData);
        }
        // This is the first node being inserted.
        else {
            addVertex(child.cData);
        }

        // If it has a left child, continue recursion.
        if (child.leftChild != null) {
            BSTMapToDirectedGraph(child, child.leftChild);
        }
        // If it has a right child, continue recursion.
        if (child.rightChild != null) {
            BSTMapToDirectedGraph(child, child.rightChild);
        }
    }

    // Maps a BST to an undirected graph.
    public void BSTMapToUndirectedGraph(Node parent, Node child) {
        // Only add edges when it's not the first node to be inserted.
        if (parent != null) {
            addEdgeUndirected(getCharIndex(parent.cData), nVerts);
            addVertex(child.cData);
        }
        // This is the first node being inserted.
        else
            addVertex(child.cData);

        // If it has a left child, continue recursion.
        if (child.leftChild != null)
            BSTMapToUndirectedGraph(child, child.leftChild);
        // If it has a right child, continue recursion.
        if (child.rightChild != null)
            BSTMapToUndirectedGraph(child, child.rightChild);
    }
}
