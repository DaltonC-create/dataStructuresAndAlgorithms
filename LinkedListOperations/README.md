This is an assignment over linked list operations.

PART I: Word Game.
Starts with a string prompted from the user, then builds a single-ended singly linked list out of the string.
Next there are two rules to be implemented on the linked list, that will be applied until the rules are no longer broken:

1. When there is a sequence of "rm", remove this sequence along with the character immediately following the sequence.
2. No vowels should be between consonants. When this occurs delete the vowel.
The current state of the linked list will be displayed after each round of enforcing the rules.

Here is an example of output of three rounds of implementing these rules:

coppermakerimprint

cppkrmprnt

cppkrnt

Part II: Numbers Game.
Prompt the user for two sets of ordered numbers, then create a single-ended singly linked list out of each set. 
Next the two linked lists will be merged into a single sorted linked list.
Then it displays the possible segments of duplicate values found in the merged list on seperate lines, along with a proper message.

Here is an example:

List1: 3 4 6 11 11 19 24 24 

List2: 1 6 6 6 19 22 28 28 28 31

MergedList: 1 3 4 6 6 6 6 11 11 19 19 22 24 24 28 28 28 31

Sublists of duplicates: 

6 6 6 6

11 11

19 19

24 24

28 28 28
