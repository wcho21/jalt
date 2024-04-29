import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import org.junit.jupiter.api.Test;
import jalt.collections.list.ListNode;
import jalt.collections.iterators.ListIterator;
import java.util.Arrays;
import java.util.Iterator;

public class ListIteratorTest {
  @Test
  public void testInit() {
    Iterable<Integer> iter = new Iterable<Integer>() {
      public Iterator<Integer> iterator() {
        ListNode<Integer> node1 = new ListNode<>(42);
        ListNode<Integer> node2 = new ListNode<>(43, node1);
        ListNode<Integer> node3 = new ListNode<>(44, node2);
        return new ListIterator<Integer>(node3);
      }
    };

    assertIterableEquals(iter, Arrays.asList(44, 43, 42));
  }
}
