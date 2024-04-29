package jalt.sorts;

import java.util.Comparator;
import static jalt.Util.isLessThan;
import static jalt.Util.swap;

public class QuickSort3Way implements SortStrategy {
  public <T> void sort(T[] arr, Comparator<T> comparator) {
    sort(arr, comparator, 0, arr.length);
  }

  private <T> void sort(T[] arr, Comparator<T> comparator, int low, int high) { // high is excluisve
    if (low >= high - 1) {
      return;
    }

    IntPair pivots = partition(arr, comparator, low, high);
    sort(arr, comparator, low, pivots.first);
    sort(arr, comparator, pivots.second, high);
  }

  private <T> IntPair partition(T[] arr, Comparator<T> comparator, int low, int high) {
    assert low < high - 1;

    T pivot = arr[low];
    int pivotLow = low;
    int pivotHigh = high;
    int i = low+1;
    int j = high-1;
    while (i < pivotHigh) {
      int compared = comparator.compare(arr[i], pivot);

      if (compared < 0) { // a[i] < pivot
        swap(arr, pivotLow++, i++);
      } else if (compared > 0) { // a[i] > pivot
        swap(arr, i, --pivotHigh);
      } else {
        ++i;
      }
    }

    return new IntPair(pivotLow, pivotHigh);
  }

  private class IntPair {
    public int first;
    public int second;

    IntPair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }
}
