package jalt;

import java.util.Comparator;

public interface SortStrategy {
  public <T> void sort(T[] arr, Comparator<T> comparator);
}
