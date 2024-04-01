# Complexity

## Time complexity

### Analysis and notation

How long will programs take?
It seems a straightforward question
because we can just measure the running time,
but how can we predict it?
A simple analysis can characterize the algorithm
and we can predict the performance regardless of any particular implementation on any specific machine.

For example, we can count how many times array access occurs in the following code:

```java
for (int i = 0; i < n; ++i) {
    for (int j = i; j < n; ++j) {
        sum += arr[j];
    }
}
```

*Exercises*:

- How many times does the array access occur in the code above?

  *Answer*: $n(n+1)/2$ in total.

In complexity analysis, we usually keep the most dominant term only and drop the rest.
In this case, we just say that the algorithm takes $~n^2/2$ time.
We can even drop the coefficient and express it as $O(n^2)$ time, which is called big-O notation.

*Note*: counting is essential in complexity analysis, so you might need to learn basic combinatorics.

### Caveats

- We dropped the lower-order terms, but they may have large coefficients,
  which makes the approximation not work properly.

- We've assumed the instructions such as array access take constant time,
  but it may not be the case.

- We've not considered the computing system.
  Specifically, we've ignored the effects by caching, garbage collection.
  They are usually negligible, but sometimes they may not be.

### Some advanced topics

If an algorithm depends on some randomness, it is called a **randomized algorithm**.
The quicksort is a good example,
since the "pivot" can be determined randomly.
(If you can't understand this right now, it's ok. We'll cover this sometime.);

If algorithm usually takes constant time but sometimes takes longer, we can use **amortized analysis**.
For a growing array (or dynamic array),
each push operation usually takes constant time,
but when the array needs to grow,
it takes time proportional to the size.
We can say that, therefore, each push operation takes $O(n)$ time for the size $n$.

However, $O(n)$ seems to be too much.
Any better description?
Growing occurs when $n = 1, 2, 4, 8, \dots$, so to push $m$ elements it takes $O(m)$ time.
We can average out to $O(1)$ and say that it takes amortized $O(1)$.

*Exercises*:

- Suppose that we've made a growing array that doubles its size whenever needed.
  Prove that, to push $m$ elements, array access occurs $O(m)$ times in total.
  Using this fact, conclude that push operation takes amortized $O(1)$.

- Suppose that we've made a growing array that increases its size by 50%.
  In this case, we say that the **growth factor** is 1.5,
  Java ArrayList (OpenJDK) has this factor.
  Prove that, to push $m$ elements, array access occurs $O(m)$ times in total,
  but with larger coefficient than the case of growth factor 2 (previous exercise).

- In Python (CPython), you can find that the growth factor is about 1.125.
  Does each push operation still take amortized $O(1)$ time?
  Why does Python have such a low growth factor?

## Space complexity

We're not going to cover the space complexity analysis, but here are some notes.

- We usually treat space as cheaper resource than time,
  so the space complexity may not be as important as the time complexity.

- In some cases, we can find a trade-off relationship between time and space,
  which means that we can save time by sacrificing more space.
  Caching is a common example.
  On the contrary, we can also save space by sacrificing time.
