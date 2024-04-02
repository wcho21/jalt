package jalt;

public class ShellSort implements SortStrategy {
  public <T extends Comparable<T>> void sort(T[] arr) {
    int gap = 1;
    while (gap < arr.length / 3) {
      gap = gap * 3 + 1;
    }

    while (gap >= 1) {
      for (int i = gap; i < arr.length; ++i) {
        for (int j = i; j >= gap; j -= gap) {
          if (arr[j-gap].compareTo(arr[j]) <= 0) {
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

    // sort
    SortStrategy strategy = new ShellSort();
    strategy.sort(arr);

    assert Utils.isSorted(arr);
  }
}
