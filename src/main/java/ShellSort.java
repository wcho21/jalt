package jalt;

import java.util.Comparator;
import static jalt.Utils.isLessThanOrEqualTo;
import static jalt.Utils.swap;
import static jalt.Utils.readAsArray;

public class ShellSort implements SortStrategy {
  public <T> void sort(T[] arr, Comparator<T> comparator) {
    int gap = 1;
    while (gap < arr.length / 3) {
      gap = gap * 3 + 1;
    }

    while (gap >= 1) {
      for (int i = gap; i < arr.length; ++i) {
        for (int j = i; j >= gap; j -= gap) {
          if (isLessThanOrEqualTo(arr[j-gap], arr[j], comparator)) {
            break;
          }

          swap(arr, j-gap, j);
        }
      }

      gap /= 3;
    }
  }
}
