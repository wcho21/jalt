package jalt;

import java.util.Iterator;

public interface Stack<T> extends Iterable<T> {
  public void push(T element);
  public T pop();
  public boolean isEmpty();
  public int size();
}