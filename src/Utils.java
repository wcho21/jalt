package jalt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Utils {
  static String[] readAsArray() {
    List<String> list = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      String str = scanner.next();
      list.add(str);
    }

    String[] arr = list.toArray(new String[0]);
    return arr;
  }

  static <T extends Comparable<T>> boolean isSorted(T[] arr) {
    for (int i = 1; i < arr.length; ++i) {
      if (arr[i-1].compareTo(arr[i]) > 0) {
        return false;
      }
    }
    return true;
  }
}
