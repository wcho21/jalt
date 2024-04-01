package jalt;

import java.util.Iterator;

public class ListIterator<T> implements Iterator<T> {
  public ListNode<T> node;

  public ListIterator(ListNode<T> node) {
    this.node = node;
  }

  public boolean hasNext() {
    return this.node != null;
  }

  public T next() {
    T value = this.node.value;

    this.node = this.node.next;

    return value;
  }
}
