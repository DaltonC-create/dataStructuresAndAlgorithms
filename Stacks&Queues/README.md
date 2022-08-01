This is a small project about stacks and queues.

We were asked to implement TWO STACKS and ONE QUEUE to implement a sorting algorithm.
We were to populate an output array one item at a time as the data is sorted.
It was acknowledged that this is an inefficient way of sorting, but a challenge to better understand the data structures.

The Item class accepts a key and timestamp argument, to see the stability of our implemented algorithm, since we are allowing duplicates to be accepted.
There is also a toString method that will print out the key:timestamp.

The assignment starts with asking the user the size of data, not exceeding 20.
Then the items are randomly assigned keys in the range of 1-10 inclusive, and the timestamp is assigned incrementally.

The items are processed one at a time, and we have 3 choices, two stacks, a queue, and a variable to hold the minimum or maximum key.

At each interval of sorting it will display the contents of the two stacks, the queue, and finally the output array.
