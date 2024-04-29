package jalt;

import java.util.Comparator;
import static jalt.Utils.isLessThanOrEqualTo;
import static jalt.Utils.swap;
import static jalt.Utils.readAsArray;

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
