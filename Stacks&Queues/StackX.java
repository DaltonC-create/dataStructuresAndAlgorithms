public class StackX
{
    // Stack array is of type Item.
    private final Item[] stackArray;
    // Variable for top of the stack.
    private int top;

    // Constructor.
    public StackX(int size)
    {
        stackArray = new Item[size];
        top = -1;
    }

    // Add item to stack.
    public void push(Item p)
    {
        stackArray[++top] = p;
    }

    // Remove item from stack.
    public Item pop()
    {
        return stackArray[top--];
    }

    // Return the top value of the stack.
    public Item peek()
    {
        return stackArray[top];
    }

    // Return the size of the stack.
    public int size()
    {
        return top + 1;
    }

    // Return true if the stack is empty.
    public boolean isEmpty()
    {
        return (top == -1);
    }

    // Return item at index num.
    public Item peekN(int num)
    {
        return stackArray[num];
    }

    // Output the stack.
    public void displayStack(int stackNum)
    {
        System.out.print("\nStack" + stackNum +  " (bottom --> top): ");
        // Loop through the current size of the stack and print.
        for (int i = 0; i < size(); i++)
        {
            System.out.print(peekN(i));
            System.out.print(' ');
        }
    }
}
