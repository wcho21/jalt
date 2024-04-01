package jalt;

import java.util.Scanner;
import java.util.Iterator;

public class ListQueue<T> implements Queue<T> {
  private ListNode<T> head;
  private ListNode<T> tail;
  private int n;

  public ListQueue() {
    this.head = null;
    this.tail = null;
    this.n = 0;
  }

  public void enqueue(T value) {
    ListNode<T> oldTail = this.tail;
    this.tail = new ListNode<T>(value);

    if (isEmpty()) {
      this.head = this.tail;
    } else {
      oldTail.next = tail;
    }

    this.n++;
  }

  public T dequeue() {
    T value = this.head.value;

    this.head = this.head.next;
    if (isEmpty()) {
      this.tail = null;
    }

    this.n--;

    return value;
  }

  public boolean isEmpty() {
    return this.head == null;
  }

  public int size() {
    return this.n;
  }

  public Iterator<T> iterator() {
    return new ListIterator<T>(this.head);
  }

  // test
  public static void main(String[] args) {
    Queue<String> queue = new ListQueue<>();

    // enqueue
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      String str = scanner.next();
      queue.enqueue(str);
    }

    // size
    System.out.println("Size: " + queue.size());

    // iterate
    System.out.print("Iterate: ");
    for (String s : queue) {
      System.out.print(s + " ");
    }
    System.out.println();

    // dequeue
    System.out.print("Dequeue: ");
    while (!queue.isEmpty()) {
      System.out.print(queue.dequeue() + " ");
    }
    System.out.println();
  }
}
