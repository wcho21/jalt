package jalt;

public class ListNode<T> {
  T value;
  ListNode<T> next;

  public ListNode(T value, ListNode<T> next) {
    this.value = value;
    this.next = next;
  }

  public ListNode(T value) {
    this.value = value;
    this.next = null;
  }

  public ListNode() {
    this.next = null;
  }
}
