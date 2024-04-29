package jalt.collections;

import java.util.Iterator;
import jalt.collections.Stack;
import jalt.collections.list.ListNode;
import jalt.collections.iterators.ListIterator;

public class ListStack<T> implements Stack<T> {
  private ListNode<T> head;
  private int n;

  public ListStack() {
    this.head = null;
    this.n = 0;
  }

  public void push(T value) {
    ListNode<T> oldHead = this.head;
    this.head = new ListNode<T>(value, oldHead);

    this.n++;
  }

  public T pop() {
    T value = this.head.value;
    this.head = this.head.next;

    this.n--;

    return value;
  }

  public boolean isEmpty() {
    return this.n == 0;
  }

  public int size() {
    return this.n;
  }

  public Iterator<T> iterator() {
    return new ListIterator<T>(this.head);
  }
}
