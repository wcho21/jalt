package jalt;

import java.util.Comparator;

public class InsertionSort implements SortStrategy {
  public <T> void sort(T[] arr, Comparator<T> comparator) {
    for (int i = 1; i < arr.length; ++i) {
      for (int j = i; j > 0; --j) {
        if (comparator.compare(arr[j-1], arr[j]) <= 0) {
          break;
        }

        T temp = arr[j-1];
        arr[j-1] = arr[j];
        arr[j] = temp;
      }
    }
  }

  public static void main(String[] args) {
    // read input
    String[] arr = Utils.readAsArray();

    // sort
    SortStrategy strategy = new InsertionSort();
    Sorter.sort(arr, new InsertionSort());

    assert Utils.isSorted(arr);
  }
}
