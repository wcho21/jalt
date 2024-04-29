import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import jalt.sorts.ShellSort;
import jalt.sorts.Sorter;

public class ShellSortTest {
  @Test
  public void testSort() {
    Integer[] toSort = { 3, 1, 2, 4 };
    Sorter.sort(toSort, new ShellSort());

    Integer[] expected = { 1, 2, 3, 4 };
    assertArrayEquals(toSort, expected);
  }
}
