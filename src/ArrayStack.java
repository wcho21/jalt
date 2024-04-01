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
    return this.arr[--n];
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

  // test
  public static void main(String[] args) {
    Stack<String> stack = new ArrayStack<>();

    // push
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      String str = scanner.next();
      stack.push(str);
    }

    // size
    System.out.println("Size: " + stack.size());

    // iterate
    System.out.print("Iterate: ");
    for (String s : stack) {
      System.out.print(s + " ");
    }
    System.out.println();

    // pop
    System.out.print("Pop: ");
    while (!stack.isEmpty()) {
      System.out.print(stack.pop() + " ");
    }
    System.out.println();
  }
}