This is an assignment dealing with Binary Search Trees.
The rules of the assignment involve taking a series of all capital letters and building a Binary Search Tree out of them.
We are to assume that the user will only enter characters and they will be capital letters.

Then there are 3 methods to be written and added to the Tree.Java class.

1. A method called displayLeftSide that displays all the nodes on the left side of the tree on one single line.
This method must be recursive.

2. A method called displayLeaves that will display all the leaf nodes on one single line.
This method must also be recursive.

3. A method called siblingSubtree that displays the subtree of a node specified by the user.

In the main class it will contain the following menu that will loop until the user decides to stop.

Please choose an option:
1. Display the tree
2. Display the word built out of the characters on the left side of this
tree.
3. Display the word built out of the characters that form the leaves of
this tree.
4. Display the sibling subtree of a character node
 a. Enter the character
5. Exit.

If the user inputs "FHKBDA" the BST would look like the following:

                                F                                                              
                B                              H                              
        A              D              --              K 
        
Option 2 should generate: ABF
Option 3 should generate: ADK
Option 4 based on character B should generate:

                               H                                                              
                --                              K        
