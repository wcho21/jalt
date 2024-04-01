# Collections

## Fundamental data structures

### Array

**Array** is one of most fundamental data structures.
Many programming languages provide array as a built-in feature.

When we use an array, or specifically, request to use it to the operating system,
contiguous memory is allocated for the request.
One main disadvantage of array is that we need to determine the size before using it.
To overcome this limitation, we can make "growing" array, which dynamically resizes as needed.

*Exercises*

- Make an array that doubles its size whenever needed. Analyze time complexity for inserting $N$ elements.

  *Answer*: amortized $O(1)$.

### Linked list

**Linked list** is another fundamental data structure, but it is not built-in in many programming languages (one of the exceptions is Lisp).

The linked list consists of nodes, but unlike array, it does not take contiguous memory.
The main advantage is that it requires no predetermined size.
Since it requires additional memory management, manipulating a linked list can be error-prone, even in programming language with garbage collection.

If each node maintains a pointer only to the "next" node, the list is called **singly linked list**.
Now consider operations, such as inserting a new node at any position.
It seems to be easy to implement if each node maintains two pointers for the "next" and "previous" nodes.
It is called **doubly linked list**.
However, note that it can be more error-prone than expected to maintain an extra pointer correctly.

*Exercises*

- Make a singly linked list.

  *Possible answer*: see [LinkNode.java](../src/ListNode.java)

## Collections

### Stack

**Stack**, or **pushdown stack** is last-in-first-out collection.
It supports abstract operations: **push** to put an element, and **pop** to get.
These two operation should take time independent of the size of stack.

Think of the stack as an abstract data type (ADT).
The client programmer should not need to know the implementation details.
We can actually impelement a stack using either an array or a linked list.

*Exercises*

- Make an interface for stack.

  *Possible answer*: see [Stack.java](../src/Stack.java)

- Make a stack using an array. Make it iterable if possible.

  *Possible answer*: see [ArrayStack.java](../src/ArrayStack.java)

- Make a stack using a linked list.

  *Possible answer*: see [ListStack.java](../src/ListStack.java)
