package jalt.sorts;

import java.util.Comparator;
import static jalt.Utils.isLessThan;
import static jalt.Utils.swap;
import static jalt.Utils.readAsArray;

public class SelectionSort implements SortStrategy {
  public <T> void sort(T[] arr, Comparator<T> comparator) {
    for (int i = 0; i < arr.length; ++i) {
      // find minimum
      int min = i;
      for (int j = i; j < arr.length; ++j) {
        if (isLessThan(arr[j], arr[min], comparator)) {
          min = j;
        }
      }

      // put minimum at right place
      swap(arr, i, min);
    }
  }
}
