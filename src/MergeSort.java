package jalt;

import java.util.Comparator;
import static jalt.Utils.isLessThan;
import static jalt.Utils.readAsArray;

public class MergeSort implements SortStrategy {
  public <T> void sort(T[] arr, Comparator<T> comparator) {
    sort(arr, comparator, 0, arr.length);
  }

  private <T> void sort(T[] arr, Comparator<T> comparator, int low, int high) { // high is exlusive
    if (low >= high - 1) {
      return;
    }

    int mid = low + (high - low) / 2;

    sort(arr, comparator, low, mid);
    sort(arr, comparator, mid, high);

    merge(arr, comparator, low, mid, high);
  }

  private <T> void merge(T[] arr, Comparator<T> comparator, int low, int mid, int high) {
    @SuppressWarnings("unchecked")
    T[] aux = (T[]) new Object[arr.length];

    for (int i = low; i < high; ++i) {
      aux[i] = arr[i];
    }

    int deck1 = low;
    int deck2 = mid;
    for (int i = low; i < high; ++i) {
      if (deck1 >= mid) {
        arr[i] = arr[deck2++];
        continue;
      }
      if (deck2 >= mid) {
        arr[i] = arr[deck1++];
        continue;
      }

      if (isLessThan(arr[deck1], arr[deck2], comparator)) {
        arr[i] = arr[deck1++];
      } else {
        arr[i] = arr[deck2++];
      }
    }
  }

  public static void main(String[] args) {
    // read input
    String[] arr = readAsArray();

    Sorter.sort(arr, new SelectionSort());

    assert Utils.isSorted(arr);
  }
}
