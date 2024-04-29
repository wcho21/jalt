import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import jalt.BinarySearch;

public class BinarySearchTest {
  @Test
  public void testSearch() {
    Integer[] arr = { 10, 20, 30, 40 };

    int rank = BinarySearch.rank(30, arr);

    assertEquals(rank, 2);
  }

  @Test
  public void testFail() {
    Integer[] arr = { 10, 20, 30, 40 };

    int rank = BinarySearch.rank(0, arr);

    assertEquals(rank, -1);
  }
}
