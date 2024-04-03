package jalt;

import java.util.Comparator;

public class ShellSort implements SortStrategy {
  public <T> void sort(T[] arr, Comparator<T> comparator) {
    int gap = 1;
    while (gap < arr.length / 3) {
      gap = gap * 3 + 1;
    }

    while (gap >= 1) {
      for (int i = gap; i < arr.length; ++i) {
        for (int j = i; j >= gap; j -= gap) {
          if (comparator.compare(arr[j-gap], arr[j]) <= 0) {
            break;
          }

          T temp = arr[j-gap];
          arr[j-gap] = arr[j];
          arr[j] = temp;
        }
      }

      gap /= 3;
    }
  }

  public static void main(String[] args) {
    // read input
    String[] arr = Utils.readAsArray();

    Sorter.sort(arr, new ShellSort());

    assert Utils.isSorted(arr);
  }
}
