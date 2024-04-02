package jalt;

public class InsertionSort implements SortStrategy {
  public <T extends Comparable<T>> void sort(T[] arr) {
    for (int i = 1; i < arr.length; ++i) {
      for (int j = i; j > 0; --j) {
        if (arr[j-1].compareTo(arr[j]) <= 0) {
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
    strategy.sort(arr);

    assert Utils.isSorted(arr);
  }
}
