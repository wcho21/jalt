package jalt.sorts;

import java.util.Comparator;
import static jalt.Util.isLessThanOrEqualTo;
import static jalt.Util.swap;

public class InsertionSort implements SortStrategy {
  public <T> void sort(T[] arr, Comparator<T> comparator) {
    for (int i = 1; i < arr.length; ++i) {
      for (int j = i; j > 0; --j) {
        if (isLessThanOrEqualTo(arr[j-1], arr[j], comparator)) {
          break;
        }

        swap(arr, j-1, j);
      }
    }
  }
}
