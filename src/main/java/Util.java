package jalt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Util {
  static public <T> boolean isLessThan(T val1, T val2, Comparator<T> comparator) {
    return comparator.compare(val1, val2) < 0;
  }

  static public <T> boolean isLessThanOrEqualTo(T val1, T val2, Comparator<T> comparator) {
    return comparator.compare(val1, val2) <= 0;
  }

  static public <T> void swap(T[] arr, int i, int j) {
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
