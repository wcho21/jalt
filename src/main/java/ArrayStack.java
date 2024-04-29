package jalt;

import java.util.Scanner;
import java.util.Iterator;

public class ArrayStack<T> implements Stack<T> {
  private T[] arr;
  private int n;

  public ArrayStack() {
    @SuppressWarnings("unchecked")
    T[] initArr = (T[]) new Object[1];

    this.arr = initArr;
    this.n = 0;
  }

  public void push(T element) {
    if (n == this.arr.length) {
      this.resize(2 * this.arr.length);
    }

    this.arr[n++] = element;
  }

  public T pop() {
    T element = this.arr[--n];

    this.arr[n] = null;

    return element;
  }

  public boolean isEmpty() {
    return this.n == 0;
  }

  public int size() {
    return this.n;
  }

  public Iterator<T> iterator() {
    return new ArrayReverseIterator<T>(this.arr, this.n);
  }

  private void resize(int size) {
    @SuppressWarnings("unchecked")
    T[] resized = (T[]) new Object[size];
    for (int i = 0; i < this.arr.length; ++i) {
      resized[i] = this.arr[i];
    }

    this.arr = resized;
  }
}
