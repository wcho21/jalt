# Basic sort and search

Why do we sort? To find things quickly later.
It's like rearranging books in a library.
Here, we'll cover basic sort and search algorithm: insertion sort and binary search.

## Insertion sort

One of the simplest sorting algorithm is **insertion sort**.
The name came from manual sorting in a card game.

Imagine a dealer handing you cards one by one, and
you placing each card in its right place to keep the cards sorted.
This kind of sorting happens in insertion sort.

For an example of implementation, see [InsertionSort.java](../src/InsertionSort.java).

*Exercises*

- Calculate the time complexity of insertion sort for worst cases and best cases.

  *Answer*: $O(n^2)$ for word cases, and $O(n)$ for best cases, where $n$ is the input size.

- (Hard) Let $A$ be an array.
  If two distinct elements are not in sorted order,
  they are called an **inversion**.
  Prove that each swap of elements in insertion sort resolves exactly one inversion.
  Using this fact, conclude that the running time of insertion sort is proportional to
  the number of inversions.
  This explains why insertion sort is fast for fully or partially sorted input.

- We can make a simple but powerful improvement over inserion sort.
  Insertion sort swaps only the adjacent elements.
  Instead, **Shellsort** swaps the elements that are far apart.
  Implement the Shellsort.
  Explain why the shell sort is even faster than insertion sort in terms of inversions.

  **Possible answer**: see [ShellSort.java](../src/ShellSort.java).

Insertion sort is basic sorting algorithm but also used in other sorting algorithm.

*Exercises*

- Research **TimSort**. What factors contribute to its performance?

## Binary search

To find something in a collection, the simplest way is to check from the first to the last elements.
However, if the collection is sorted, we can use this fact and find something way more faster.

Note that we can say that a collection is sorted because the elements have an *order*.
This means that we can say that an element is *greater* or *less* than others.

Suppose that we want to find something, or **key**, in a collection, which is sorted in increasing order.
We first choose the middle element in the collection.
If the key is greater than that, we can discard the first half of the collection (and similarly if the key is less than that).
In this way, we can reduce drastically the number of candidates, which makes the binary search fast.

For an example of implementation, see [BinarySearch.java](../src/BinarySearch.java).

*Exercises*

- Calculate the time complexity of binary sesarch.

  *Answer*: $O(n \lg n)$ for the input size $n$.

Don't be frustrated if you find it hard to implement binary search.
Here is an interesting statistics.
According to Programming Pearls by John Bently,
"only about ten percent of professional programmers were able to get this small program right."
Donald Knuth also said "Although the basic idea of binary search is comparatively straightforward, the details can be surprisingly tricky."
Even in the standard library of Java, the binary search contained a bug for about nine years.
(Search for this if you're interested.)

## Misc.

Swapping elements is usually not an expansive operation in most programming languages.
However, if you have heavy boxes and need to sort them, you may want to minimize the number of swaps.
In this case, **selection sort** can be a good alternative.

*Exercises*

- How many times does a swap occur in selection sort for $n$ elements?

  *Answer*: at most $n$ times.
