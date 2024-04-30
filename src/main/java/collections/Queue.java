package jalt.collections;

public interface Queue<T> extends Iterable<T> {
  public void enqueue(T element);
  public T dequeue();
  public boolean isEmpty();
  public int size();
}
