import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import org.junit.jupiter.api.Test;
import jalt.collections.iterators.ArrayReverseIterator;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayReverseIteratorTest {
  @Test
  public void testInit() {
    Iterable<Integer> iter = new Iterable<Integer>() {
      public Iterator<Integer> iterator() {
        Integer[] arr = { 42, 43, 44 };
        return new ArrayReverseIterator(arr, 3);
      }
    };

    assertIterableEquals(iter, Arrays.asList(44, 43, 42));
  }
}
