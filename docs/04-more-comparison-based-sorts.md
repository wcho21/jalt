# More comparison-based sorts

We'll cover more sorting algorithms: merge sort, quicksort, and heapsort.
We'll also discuss some important properties of sorting algorithms.

## Merge sort

The basic idea is like *merging* two card decks that are already sorted.
Note that a deck of a single card is already sorted, which is a base case in recursion.
In a divide-and-conquer manner, the whole deck is divided into single cards and then merged into a sorted deck

For an example of implementation, see [MergeSort.java](../src/main/java/sorts/MergeSort.java)

*Exercises*

- Calculate the time complexity of merge sort.

  *Answer*: $O(n \lg n)$ for worst and best cases.

- (Hard) Prove that any *comparison-based* sorting algorithm can have $O(n \lg n)$ at best for worst cases.
  Conclude that the merge sort is an asymtotically optimal compare-based sorting algorithm.

  *Hint*: use a tree to represent the comparison process that occurs during sorting.

- (Hard) Is there $O(n)$ sorting algorithm?
  If so, what is the difference between merge sort and that one?

## Quicksort

Quicksort chooses a "pivot" and partition an array into two parts, where the first one is less than the pivot and the second one is greater.
The choice of the pivot determines the performance of this algorithm, and it usually has $O(n \lg n)$ on average.
While it has $O(n^2)$ for worst cases, such cases are highly unlikely.

For an example of implementation, see [QuickSort.java](../src/main/java/sorts/QuickSort.java)

*Exercises*

- One improvement is called **three-way partitioning**.
  Search for a classical programming problem called *Dutch national flag* problem.
  We can use the algorithm for this problem to partition an array into three parts in quicksort:
  one less than the pivot, one equal to the pivot, and one greater than the pivot.
  It makes sorting much faster especially for arrays containing a large number of duplicate keys,
  and reduces the complexity to $O(n)$ if all keys are the same.
  Implement the quicksort with three-way partitioning.

  *Possible answer*: [QuickSort3Way.java](../src/main/java/sorts/QuickSort3Way.java)

## Heapsort

TODO
