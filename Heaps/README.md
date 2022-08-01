This is an assigment implementing a max heap.

Part I:
This program will map a Heap that is stored in an array to a Binary Tree. Here are the steps to be taken:

1. Instantiate an array of 10 Node objects using the Node class from the book that will have attributes of a key, and a left and right child.

2. Each Node object's integer key will be randomly created in the range 10-50, with no duplicates.

3. Build a Max Heap out of this array using the key attribute of the Node.

4. The mapping of this Heap array into a Binary Tree will be done in a bottom up fashion. Meaning it will start with the last parent, find its possible children, attach them to the parent and move to the next parent in line until the tree is populated.

The parent nodes in the Heap array will turn into subtrees as this algorithm progresses.
Afterwards the array will be displayed to show all the subtrees formed. The special display tree method from the book will be used to show a tree structure.

Part II: 
This will be a different approach to mapping a Heap Array to a Binary Tree. This time a Queue will be used to help with the process. Here are the guidelines to implement this:

1. Start with the last parent, connect the children to the parent, but this time enqueue the resulting subtree in a Queue.
2. This will look for children of parents that are part of the Heap Array as long as their possible children are not parents themselves.
3. When it is processing a parent whose children are parents themselves, it will look for the children in the Queue, by dequeueing the first two subtrees/children off hte Queue and connect them with the parent and enqueue the "family" back in the queue.

This process will be continued until the "root" of the heap is processed. At each step the contents of the queue will be displayed.
