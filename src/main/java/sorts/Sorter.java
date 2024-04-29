package jalt.sorts;

import java.util.Comparator;
import java.util.function.Function;

public class Sorter {
  // note: it can sort generic array (T[]), since comparator yields a Comparable value as a key
  public static <T> void sort(T[] arr, SortStrategy strategy, Comparator<T> comparator) {
    strategy.sort(arr, comparator);
  }

  public static <T extends Comparable<? super T>> void sort(T[] arr, SortStrategy strategy) {
    Comparator<T> identityComparator = Comparator.comparing(Function.identity());
    strategy.sort(arr, identityComparator);
  }
}
