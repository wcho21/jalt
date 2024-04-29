package jalt.collections.iterators;

import java.util.Iterator;

public class ArrayReverseIterator<T> implements Iterator<T> {
  private T[] arr;
  private int i;

  public ArrayReverseIterator(T[] arr, int size) {
    this.arr = arr;
    this.i = size;
  }

  public boolean hasNext() {
    return this.i > 0;
  }

  public T next() {
    return this.arr[--i];
  }
}
