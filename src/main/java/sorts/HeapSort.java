package jalt.sorts;

import java.util.Comparator;
import static jalt.Util.swap;
import static jalt.Util.isLessThan;

class HeapSorter<T> {
  private T[] arr;
  private T[] orig;
  private int n;
  private Comparator<T> comparator;

  public HeapSorter(T[] arr, Comparator<T> comparator) {
    this.orig = arr;

    @SuppressWarnings("unchecked")
    T[] initArr = (T[]) new Object[arr.length+1]; // +1 due to 1-based index

    // shift by one index
    this.arr = initArr;
    for (int i = 0; i < arr.length; ++i) {
      this.arr[i+1] = arr[i];
    }
    this.n = arr.length+1;
    this.comparator = comparator;
  }

  public T[] sort() {
    for (int i = arr.length/2; i >= 1; --i) {
      heapifyDown(i);
    }

    while (n > 1) {
      swapValues(1, --n);
      heapifyDown(1);
    }

    for (int i = 0; i < orig.length; ++i) {
      orig[i] = arr[i+1];
    }
    return orig;
  }

  // TODO: factor out heap methods (see jalt.collections.MaxPriorityQueue)
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

public class HeapSort implements SortStrategy {
  public <T> void sort(T[] arr, Comparator<T> comparator) {
    HeapSorter<T> sorter = new HeapSorter(arr, comparator);
    arr = sorter.sort();
  }
}
