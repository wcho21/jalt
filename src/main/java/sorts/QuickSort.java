package jalt.sorts;

import java.util.Comparator;
import static jalt.Utils.isLessThan;
import static jalt.Utils.swap;
import static jalt.Utils.readAsArray;

public class QuickSort implements SortStrategy {
  public <T> void sort(T[] arr, Comparator<T> comparator) {
    sort(arr, comparator, 0, arr.length);
  }

  private <T> void sort(T[] arr, Comparator<T> comparator, int low, int high) { // high is excluisve
    if (low >= high - 1) {
      return;
    }

    int pivot = partition(arr, comparator, low, high);
    sort(arr, comparator, low, pivot);
    sort(arr, comparator, pivot+1, high);
  }

  private <T> int partition(T[] arr, Comparator<T> comparator, int low, int high) {
    assert low < high - 1;

    T pivot = arr[low];

    int i = low+1;
    int j = high-1;
    while (true) {
      while (i < j && isLessThan(arr[i], pivot, comparator)) {
        ++i;
      }
      while (j > i && isLessThan(pivot, arr[j], comparator)) {
        --j;
      }

      if (i >= j) {
        break;
      }
      swap(arr, i, j);
    }

    swap(arr, low, j-1);
    return j;
  }
}
