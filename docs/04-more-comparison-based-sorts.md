# More comparison-based sorts

We'll cover more sorting algorithms: merge sort, quicksort, and heapsort.
We'll also discuss some important properties of sorting algorithms.

## Merge sort

The basic idea is like *merging* two card decks that are already sorted.
Note that a deck of a single card is already sorted, which is a base case in recursion.
In a divide-and-conquer manner, the whole deck is divided into single cards and then merged into a sorted deck

For an example of implementation, see [MergeSort.java](../src/MergeSort.java)

*Exercises*

- Calculate the time complexity of merge sort.

  *Answer*: $O(n \lg n)$ for worst and best cases.

- (Hard) Prove that any *comparison-based* sorting algorithm can have $O(n \lg n)$ at best for worst cases.
  Conclude that the merge sort is an asymtotically optimal compare-based sorting algorithm.

  *Hint*: use a tree to represent the comparison process that occurs during sorting.

- (Hard) Is there $O(n)$ sorting algorithm?
  If so, what is the difference between merge sort and that one?
