package jalt.search;

public class BinarySearch {
  static public <T extends Comparable<T>> int rank(T key, T[] arr) {
    int low = 0;
    int high = arr.length-1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      T midVal = arr[mid];
      int compared = key.compareTo(midVal);

      if (compared < 0) {
        high = mid - 1;
      } else if (compared > 0) {
        low = mid + 1;
      } else {
        return mid;
      }
    }

    return -1; // not found
  }
}
