package jalt;

public class SelectionSort implements SortStrategy {
  public <T extends Comparable<T>> void sort(T[] arr) {
    for (int i = 0; i < arr.length; ++i) {
      // find minimum
      int min = i;
      for (int j = i; j < arr.length; ++j) {
        if (arr[j].compareTo(arr[min]) < 0) {
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

    // sort
    SortStrategy strategy = new SelectionSort();
    strategy.sort(arr);

    assert Utils.isSorted(arr);
  }
}
