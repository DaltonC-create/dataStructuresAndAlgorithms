This is a project implementing a Binary Search Tree with specific rules.

Part I:
This part will read a string (all Capital letters) from the keyboard and build a Binary Search Tree with the characters. There are four rules that must be enforced when building the BST, on top of the usual BST rules.

1. No vowel parent can have a vowel as a child unless hte parent's sibling is also a vowel. This means you can insert a vowel as a child of another vowel only if its uncle-to-be is also a vowel.

2. No consonant parent can have a duplicate value as a child, meaning the parent and child cannot be the same consonant letters. This only applies to consonants and not vowels. For example letter A can be the child of parent-A as long as the child-A has a vowel uncle. Note: We agreed to insert the legal duplicates as the left child.

3. When a letter cannot be inserted based on these rules, they will be placed in another data structure to be inserted in the BST after the legal ones are inserted. They will be inserted in the exact order they were put on hold in part II.

4. After the BST is populated, each node will have its height calculated and assigned as an attribute to each node.

After Part I is complete, the following will be output:
1. Display the BST (using display method from the book)

2. Display the data structure used for letters that could not be inserted properly.

3. Display the information of every node in the BST: the letter followed by the height , one node per line.

Part II:
This part is about re-inserting the nodes that could not be inserted in Part I. Each node will the inserted in the exact order they were put on hold in the first available spot in the tree starting from the left side.

Afterwards the tree is displayed to show all nodes inserted in the tree.
