import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import jalt.sorts.HeapSort;
import jalt.sorts.Sorter;

public class HeapSortTest {
  @Test
  public void testSort() {
    Integer[] toSort = { 6, 3, 1, 4, 2, 7, 5 };
    Sorter.sort(toSort, new HeapSort());

    Integer[] expected = { 1, 2, 3, 4, 5, 6, 7 };
    assertArrayEquals(toSort, expected);
  }
}
