package jalt.collections;

import static jalt.Util.swap;
import static jalt.Util.isLessThan;
import java.util.Comparator;
import jalt.collections.PriorityQueue;
import java.util.function.Function;

public class MaxPriorityQueue<T> implements PriorityQueue<T> {
  private T[] arr;
  private int n;
  private Comparator<T> comparator;

  static public <U extends Comparable<? super U>> MaxPriorityQueue<U> fromArray(U[] arr) {
    Comparator<U> identityComparator = Comparator.comparing(Function.identity());
    MaxPriorityQueue<U> queue = new MaxPriorityQueue<>(arr.length, identityComparator);

    for (U element : arr) {
      queue.enqueue(element);
    }

    return queue;
  }

  public MaxPriorityQueue(int size, Comparator<T> comparator) {
    @SuppressWarnings("unchecked")
    T[] initArr = (T[]) new Object[size+1]; // +1 due to 1-based index

    this.arr = initArr;
    this.n = 1; // next index to fill
    this.comparator = comparator;
  }

  public void enqueue(T element) {
    this.arr[n] = element;

    heapifyUp(n);

    ++n;
  }

  public T dequeue() {
    T toDequeue = this.arr[1];

    --n;
    swapValues(1, n);
    this.arr[n] = null;
    heapifyDown(1);

    return toDequeue;
  }

  public T peek() {
    return this.arr[1];
  }

  public boolean isEmpty() {
    return this.n == 1;
  }

  public int size() {
    return this.n - 1;
  }

  private void heapifyUp(int i) {
    while (i > 1) {
      int parent = i/2;
      if (!hasLessValueThan(parent, i)) {
        break;
      }

      swapValues(parent, i);
      i = parent;
    }
  }

  private void heapifyDown(int i) {
    while (true) {
      int leftChild = 2*i;
      if (leftChild >= this.n) {
        break;
      }

      int rightChild = leftChild+1;

      int largerChild = leftChild;
      if (rightChild < this.n && hasLessValueThan(leftChild, rightChild)) {
        largerChild = rightChild;
      }

      if (!hasLessValueThan(i, largerChild)) {
        break;
      }

      swapValues(i, largerChild);
      i = largerChild;
    }
  }

  private boolean hasLessValueThan(int i, int j) {
    return isLessThan(arr[i], arr[j], this.comparator);
  }

  private void swapValues(int i, int j) {
    swap(this.arr, i, j);
  }
}
