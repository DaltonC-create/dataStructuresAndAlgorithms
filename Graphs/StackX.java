/*
 * Dalton Carter
 * This class establishes a stack, to be used in option 4 of this assignment's menu.
 */
public class StackX {

    private final int SIZE = 20;
    private int[] st;
    private int top;

    // Constructor.
    public StackX() {
        st = new int[SIZE];
        top = -1;
    }

    // Push an integer onto the stack.
    public void push(int n)
    { st[++top] = n; }

    // Return and pop the integer on top of the stack.
    public int pop()
    { return st[top--]; }

    // Return the integer on top of the stack without popping.
    public int peek()
    { return st[top]; }

    public boolean isEmpty()
    { return (top == -1); }
}
