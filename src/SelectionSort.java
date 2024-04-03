package jalt;

import java.util.Comparator;

public class SelectionSort implements SortStrategy {
  public <T> void sort(T[] arr, Comparator<T> comparator) {
    for (int i = 0; i < arr.length; ++i) {
      // find minimum
      int min = i;
      for (int j = i; j < arr.length; ++j) {
        if (comparator.compare(arr[j], arr[min]) < 0) {
          min = j;
        }
      }

      // put minimum at right place
      T temp = arr[i];
      arr[i] = arr[min];
      arr[min] = temp;
    }
  }

  public static void main(String[] args) {
    // read input
    String[] arr = Utils.readAsArray();

    Sorter.sort(arr, new SelectionSort());

    assert Utils.isSorted(arr);
  }
}
