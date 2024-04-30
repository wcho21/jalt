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

**Heap** is another data structure, which can be represented by a complete binary tree with so-called heap-ordered.
(Here by heap we mean binary heap)
If each node in a tree has greater value than its children, the tree is said to be heap-ordered.
Note that the root of a heap-ordered tree has greatest value.
Using this property, we can build a priority queue, as we'll see shortly.

Since heaps can be represented by a complete tree, we can implement it with an array.
We can, specifically, find parent and child for any node with index $i$ as follows:

$$
\begin{align}
  \text{parent} &= i/2 \\
  \text{left child} &= 2\*i \\
  \text{right child} &= 2\*i + 1
\end{align}
$$

We can reheapify any node that violates the heap order.
There are two cases for violations: when the node has greater value than the one of parent, and less value than the one of children.
For the first case, we exchange the node with its parent (heapify up), and for the second one, with its children (heapify down).

The tree has $O(\lg n)$ for the number of nodes $n$.
For each time adding or removing element, we'll keep the heap order by heapifying as described above, so it takes $O(\lg n)$ time.
For a heap that contains $n$ elements, by taking out the root element $n$ times we can sorted elements, which is Heapsort.

*Exercises*

- Implement a heap and heapsort.

  *Possible answer*: TBA

- Suppose we have $n$ integers and want to keep $m (< n)$ greatest ones.
  How can we do that with heap? How much time does it take?

  *Answer*: use a heap of size $m$. $O(n \lg m)$.

- Implement a priority queue.

  *Possible answer*: TBA

- Can we build stacks and queues using a priority queue?
  If so, what kind of "priority" do they use?

## Properties of sorting algorithms

A sorting algorithm is **stable** if it keeps the relative order.
Merge sort is stable.

*Exercises*

- What makes merge sort stable? (See merging step that combines sorted deck from two sub decks.)
