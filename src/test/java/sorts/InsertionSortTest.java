import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import jalt.sorts.InsertionSort;
import jalt.sorts.Sorter;

public class InsertionSortTest {
  @Test
  public void testSort() {
    Integer[] toSort = { 3, 1, 2, 4 };
    Sorter.sort(toSort, new InsertionSort());

    Integer[] expected = { 1, 2, 3, 4 };
    assertArrayEquals(toSort, expected);
  }
}
