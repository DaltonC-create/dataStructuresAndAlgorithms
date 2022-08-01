/*
 * Dalton Carter
 * This class establishes vertices to be inserted and used in the graph.
 */
public class Vertex {

    public char label;
    public boolean wasVisited;

    // Constructor.
    public Vertex(char lab) {
        label = lab;
        wasVisited = false;
    }
}