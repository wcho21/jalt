package jalt;

public interface SortStrategy {
  public <T extends Comparable<T>> void sort(T[] arr);
}
