This assignment involves arrays and array operations.

Part I

Instantiate two integer arrays of size 50 named listA and listB.
Generate a random number between 1-49 for the number of elements that will be in each array.
Each number will be a random number between the range 0-100 and store in each array.
Each individual array can have no duplicate values, but each array can have common values.

Next was to find all common elements between the two arrays, remove them, and display the 
common elements IN ORDER. Finally combine the two arrays into a single sorted array called
TheList.

An example for Part I would be:
ListA: | 13 7 42 2 9 11 38 21 >>> 42 2 9 21 |
ListB: | 7 11 40 91 82 8 13 38 72 12 6 >>> 40 91 82 8 72 6 |
TheList: | 2 6 8 9 21 40 42 72 82 91|

The output for part I will be in the following order:
1. Display original listA and listB.
2. Display common elements in order.
3. Display both arrays after deletion of common elements.
4. Display the merged sorted array TheList

Part II

The second part is an int-array game based on listA and listB from part I with the following steps:
1. Choose the shorter array as the key, listA is the default in case of equal length.
2. Every element of the key array will be the index of the longer array you will use to sum all the 
values in those indices. If a number will cause an out of bound exception, skip that element and move on.
Each element skipped will be part of a counter to display at the end.

A very simple example would be:

ListA: |8 12 4 90|
ListB: |10 6 32 87 50 61 77 39 45|

listB[8] = 45, and listB[4] = 50, 45 + 50 = 95 (skipped elements = 2).

The output for part II will be in the following order:
1. Display listA and listB (common elements removed).
2. Display the sum found from elements in the longer of the arrays.
3. Display the count of elements skipped to avoid out of bounds exception.
