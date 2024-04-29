import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import jalt.ListNode;

public class ListNodeTest {
  @Test
  public void testInit() {
    ListNode<Integer> nullNode = new ListNode<>();
    assertNull(nullNode.next);

    ListNode<Integer> valueNode = new ListNode<>(42);
    assertNull(valueNode.next);
    assertEquals(valueNode.value, 42);

    ListNode<Integer> nextNode = new ListNode<>();
    ListNode<Integer> prevNode = new ListNode<>(43, nextNode);
    assertEquals(prevNode.next, nextNode);
    assertEquals(prevNode.value, 43);
  }
}
