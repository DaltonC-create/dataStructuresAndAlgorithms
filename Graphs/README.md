This is an assignment on Graphs.

This assignment will take a string input (all caps) create a BST out of it, and map it to a graph.
It will visit every node in the BST and not only store it as a vertex (for graph) in the array that represent the graph, but also populate the adjacency matrix based on the parent-child relationship that is detected in the BST.

An important thing is that the order of the vertices in the vertex array do not show the connectivity of these vertices. It's all about the adjacency matrix that determines the connectivity pattern of the graph.

The adjacency matrix will be displayed in a tabular format, since it is constructed using a 2d array.

First the user will decide if it will be a directed, or undirected graph. If a directed graph is chose, the parent-child direction of the BST will be used from paretn to the child.

After mapping the BST into the graph, the following menu will be displayed:

1. Display the BST in a tree format.
2. Display the Vertex array.
3. Display the Adjacency Matrix
4. Given a vertex: Display ALL possible separate paths starting with that vertex in a Depth First Search pattern:
   Enter the letter:
5. Given a vertex: Display ALL its adjacent vertices (one edge apart)
   Enter the letter:
6. Given a vertex: Display ALL the vertices that are two edges away from it:
   Enter the letter:
7. Exit

The BST will be held onto, in case the user chooses option 1 in the menu. Every other menu option will operate on the graph and not the BST.
