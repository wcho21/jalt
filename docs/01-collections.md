# Collections

This chapter covers fundamental data structures: array and linked list.
There are important data structures: stack and queue, which can be implemented using array or linked list.

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

  *Possible answer*: see [ListNode.java](../src/main/java/collections/list/ListNode.java)

## Collections

### Stack

**Stack**, or **pushdown stack** is last-in-first-out collection.
It supports abstract operations: **push** to put an element, and **pop** to get.
These two operations should take time independent of the size of stack.

Think of the stack as an abstract data type (ADT).
The client programmer should not need to know the implementation details.
We can actually impelement a stack using either an array or a linked list.

*Exercises*

- Make an interface for stack.

  *Possible answer*: see [Stack.java](../src/main/java/collections/Stack.java)

- Make a stack using an array. Make it iterable if possible.

  *Possible answer*: see [ArrayStack.java](../src/main/java/collections/ArrayStack.java)

- Make a stack using a linked list.

  *Possible answer*: see [ListStack.java](../src/main/java/collections/ListStack.java)

Where can we use stacks?
See the concept of the *call stack* in your favorite programming language.
Whenever we use recursion, the programming lauguage implicitly use a stack data structure,
to remember the calling position in a recursive call.
For another example, see Dijkstra's *shunting yard algorithms*, which evaluates a simple arithmetic expression such as `2*(3+4)`.

*Exercises*

- Can any recursive algorithm be transformed into an iterative algorithm, and vice versa?

### Queue

**Queue** is, on the other hand, first-in-first-out collection.
It supports abstract operations: **enqueue** to put an element, and **dequeue** to get.
These two operations also should take constant time as stack does.

*Exercises*

- Make an interface for queue.

  *Possible answer*: see [Queue.java](../src/main/java/collections/Queue.java)

- Make a queue using a linked list. Make it iterable if possible.

  *Possible answer*: see [ListQueue.java](../src/main/java/collections/ListQueue.java)

- Can you make a queue using two stacks? Can you make a stack using two queues?

*Variation of queue*: The operations such as enqueuing occurs at one end of the queue.
However, we can make a double-ended queue, or **deque**, that supports enqueuing and dequeuing at both ends.
Note that it can be implemented with doubly linked list.

## Misc.

*Java-specific note*: Java does not allow generic arrays.
To understand why, learn about *covariant array*.
When we make a generic stack with array, for example, we need to consider this fact, though there is an workaround.
